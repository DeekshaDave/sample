package com.example.castlerockassociates.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PagesModel implements Parcelable {

    @SerializedName("lines")
    @Expose
    private List<String> lines = null;
    @SerializedName("justification")
    @Expose
    private String justification;

    public PagesModel(Parcel in) {
        lines = in.createStringArrayList();
        justification = in.readString();
    }


    public static final Creator<PagesModel> CREATOR = new Creator<PagesModel>() {
        @Override
        public PagesModel createFromParcel(Parcel in) {
            return new PagesModel(in);
        }

        @Override
        public PagesModel[] newArray(int size) {
            return new PagesModel[size];
        }
    };

    public PagesModel() {

    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringList(lines);
        parcel.writeString(justification);
    }
}
