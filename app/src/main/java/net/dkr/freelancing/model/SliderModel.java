package net.dkr.freelancing.model;

import android.graphics.Bitmap;

public class SliderModel {
    private Bitmap bitmap;
    private String  name;

    public SliderModel(Bitmap bitmap, String name) {
        this.bitmap = bitmap;
        this.name = name;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
