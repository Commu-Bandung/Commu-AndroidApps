package com.firman.firebasestore;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Firman on 1/7/2017.
 */

public class ItemObject {

    public class ObjectBelajar {
        @SerializedName("commu")
        public List<Results> belajar;

        public class Results {
            @SerializedName("id")
            public String id;

            @SerializedName("kategori")
            public String kategori;

        }
    }
}

