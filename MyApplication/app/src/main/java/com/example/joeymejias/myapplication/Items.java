package com.example.joeymejias.myapplication;

/**
 * Created by joey on 7/29/16.
 */
public class Items {
    private String mBread;
    private String mPrice;
    private String mDetails;

    public Items(String bread, String price){
        mBread = bread;
        mPrice = price;
    }

    public Items(String bread, String price, String details){
        mBread = bread;
        mPrice = price;
        mDetails = details;
    }

    public String getBread() {
        return mBread;
    }

    public String getPrice() {
        return mPrice;
    }

    public String getDetails() {
        return mDetails;
    }
}
