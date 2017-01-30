package com.firman.firebasestore;

/**
 * Created by Firman on 11/8/2016.
 */


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.firman.firebasestore.preference.AppPreference;
import com.firman.firebasestore.util.FacebookLoginUtil;
import com.firman.firebasestore.util.GooglePlusLoginUtil;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity
        implements View.OnClickListener, OnCompleteListener<AuthResult>,
        FacebookLoginUtil.OnFacebookLoginSuccessListener {

    private GradientBackgroundPainter gradientBackgroundPainter;

    private Button bSignIn;

    @BindView(R.id.btn_login_google)
    Button btnLoginGoogle;
    @BindView(R.id.btn_login_facebook)
    Button btnLoginFacebook;
    @BindView(R.id.facebookLogin)
    LoginButton facebookLogin;

    private AppPreference appPreference;
    private FirebaseAuth mFirebaseAuth;
    private GooglePlusLoginUtil googlePlusLoginUtil;
    private FacebookLoginUtil facebookLoginUtil;
    private ProgressDialog progressDialog;

    private AuthCredential mAuthCredential = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        View backgroundImage = findViewById(R.id.login);
        getSupportActionBar().setTitle("Login");
        final int[] drawables = new int[5];
        drawables[0] = R.drawable.gradient_1;
        drawables[1] = R.drawable.gradient_2;
        drawables[2] = R.drawable.gradient_3;
        drawables[3] = R.drawable.gradient_4;
        drawables[4] = R.drawable.gradient_5;

        gradientBackgroundPainter = new GradientBackgroundPainter(backgroundImage, drawables);
        gradientBackgroundPainter.start();

        appPreference = new AppPreference(LoginActivity.this);
        mFirebaseAuth = FirebaseAuth.getInstance();
        googlePlusLoginUtil = new GooglePlusLoginUtil(this);
        googlePlusLoginUtil.connect();
        facebookLoginUtil = new FacebookLoginUtil(facebookLogin, this);
        facebookLoginUtil.setOnFacebookLoginSuccessListener(this);

        bSignIn = (Button) findViewById(R.id.btn_login);
        bSignIn.setOnClickListener(this);
        btnLoginFacebook.setOnClickListener(this);
        btnLoginGoogle.setOnClickListener(this);

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setTitle("Login");
        progressDialog.setMessage("Please wait...");
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        boolean isLogin = false;
        switch (view.getId()) {
            case R.id.btn_login :
                Intent i = new Intent(this, SignInHere.class);
                startActivity(i);
                overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
                Toast.makeText(getApplicationContext(), "Login", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_login_google:
                googlePlusLoginUtil.signIn(this);
                break;

            case R.id.btn_login_facebook:
                facebookLoginUtil.doLogin();
                break;
        }

        if (intent != null) {
            startActivity(intent);
            if (isLogin) {
                finish();
            }
        }
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (googlePlusLoginUtil != null) {
            googlePlusLoginUtil.disconnect();
        }
        gradientBackgroundPainter.stop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == googlePlusLoginUtil.RC_SIGN_IN) {
            GoogleSignInAccount account = googlePlusLoginUtil.getSignInResult(data);
            if (account != null) {
                progressDialog.show();
                firebaseAuthWithGoogle(account);
            } else {
                Toast.makeText(this, "Couldn't connect you to Google Account", Toast.LENGTH_LONG).show();
            }
        }
        facebookLoginUtil.onActivityResult(requestCode, resultCode, data);
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount googleSignInAccount) {
        mAuthCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
        mFirebaseAuth.signInWithCredential(mAuthCredential).addOnCompleteListener(this);
    }

    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        progressDialog.cancel();
        if (task.isSuccessful()) {
            appPreference.setEmail(task.getResult().getUser().getEmail());
            appPreference.setUserId(task.getResult().getUser().getUid());
            HomeActivity.start(this);
            Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show();
            finish();
        } else {
            Log.d("Firebase", task.getException().getMessage());
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFacebookLoginSuccess(LoginResult loginResult) {
        progressDialog.show();
        mAuthCredential = FacebookAuthProvider.getCredential(loginResult.getAccessToken().getToken());
        mFirebaseAuth.signInWithCredential(mAuthCredential).addOnCompleteListener(this);
    }

}
