package com.einao.marvelcomics.app.ui.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

public class ComicViewModel implements Parcelable {

    public String title;
    public String description;
    public String imageUrl;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.imageUrl);
    }

    public ComicViewModel() {
    }

    protected ComicViewModel(Parcel in) {
        this.title = in.readString();
        this.description = in.readString();
        this.imageUrl = in.readString();
    }

    public static final Parcelable.Creator<ComicViewModel> CREATOR = new Parcelable.Creator<ComicViewModel>() {
        @Override
        public ComicViewModel createFromParcel(Parcel source) {
            return new ComicViewModel(source);
        }

        @Override
        public ComicViewModel[] newArray(int size) {
            return new ComicViewModel[size];
        }
    };
}
