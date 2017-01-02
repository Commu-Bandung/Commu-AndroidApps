package com.firman.firebasestore.model;

/**
 * Created by Firman on 1/2/2017.
 */

public class ItemAllNews {

    private int CategoryId;
    private String CategoryName;
    private String CategoryImageUrl;

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryid) {
        this.CategoryId = categoryid;
    }


    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryname) {
        this.CategoryName = categoryname;
    }

    public String getCategoryImageurl()
    {
        return CategoryImageUrl;

    }

    public void setCategoryImageurl(String catimageurl)
    {
        this.CategoryImageUrl=catimageurl;
    }

}
