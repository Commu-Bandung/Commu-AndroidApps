package com.firman.firebasestore;

/**
 * Created by Firman on 1/3/2017.
 */
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;


public class AlertDialogManager {

    public void showAlertDialog(Context context, String title, String message,
                                Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        //Seting dialog title
        alertDialog.setTitle(title);

        //Setting Dialog message
        alertDialog.setMessage(message);

        if (status!=null)

            //setting alert dialog
            alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

        //Setting OK Burron
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        //showing alert message
        alertDialog.show();
    }
}
