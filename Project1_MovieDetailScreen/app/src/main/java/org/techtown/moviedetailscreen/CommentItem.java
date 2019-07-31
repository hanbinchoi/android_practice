package org.techtown.moviedetailscreen;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.*;

public class CommentItem implements Parcelable {

    String userID;
    String comment;
    float rating;

    public CommentItem(String userID, String comment, float rating) {
        this.userID = userID;
        this.comment = comment;
        this.rating = rating;
    }

    protected CommentItem(Parcel in) {
        userID = in.readString();
        comment = in.readString();
        rating = in.readFloat();
    }

    public static final Creator<CommentItem> CREATOR = new Creator<CommentItem>() {
        @Override
        public CommentItem createFromParcel(Parcel in) {
            return new CommentItem(in);
        }

        @Override
        public CommentItem[] newArray(int size) {
            return new CommentItem[size];
        }
    };

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "CommentItem{" +
                "userID='" + userID + '\'' +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userID);
        parcel.writeString(comment);
        parcel.writeFloat(rating);
    }
}
