package com.example.castlerockassociates.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DisplayModel implements Parcelable {

    @SerializedName("pages")
    @Expose
    private List<PagesModel> pages = null;


    public static final Creator<DisplayModel> CREATOR = new Creator<DisplayModel>() {
        @Override
        public DisplayModel createFromParcel(Parcel in) {
            return new DisplayModel(in);
        }

        @Override
        public DisplayModel[] newArray(int size) {
            return new DisplayModel[size];
        }
    };

    public DisplayModel(Parcel in) {
        pages = in.createTypedArrayList(PagesModel.CREATOR);
    }

    public DisplayModel() {

    }

    public List<PagesModel> getPages() {
        return pages;
    }

    public void setPages(List<PagesModel> pages) {
        this.pages = pages;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(pages);

    }
}
