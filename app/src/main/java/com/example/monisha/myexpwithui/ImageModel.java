package com.example.monisha.myexpwithui;

import android.graphics.drawable.Drawable;

/**
 * Created by Monisha on 1/22/2017.
 */

public class ImageModel {
    private Drawable imageLocalAddress;
    private String imageUrl;

    public ImageModel(Drawable imageLocalAddress, String imageUrl) {
        this.imageLocalAddress = imageLocalAddress;
        this.imageUrl = imageUrl;
    }

    public Drawable getImageLocalAddress() {
        return imageLocalAddress;
    }

    public void setImageLocalAddress(Drawable imageLocalAddress) {
        this.imageLocalAddress = imageLocalAddress;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
