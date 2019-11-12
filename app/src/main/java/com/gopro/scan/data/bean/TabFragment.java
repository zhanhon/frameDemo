package com.gopro.scan.data.bean;

import androidx.fragment.app.Fragment;

public class TabFragment {
    private Fragment fragment;
    private String name;
    private int imageId;

    public TabFragment(Fragment fragment, String name, int imageId) {
        this.fragment = fragment;
        this.name = name;
        this.imageId = imageId;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
