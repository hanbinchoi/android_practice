package org.techtown.moviedetailscreen;

public class CommentItem {

    String userID;
    String comment;

    public CommentItem(String userID, String comment) {
        this.userID = userID;
        this.comment = comment;
    }

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

    @Override
    public String toString() {
        return "CommentItem{" +
                "userID='" + userID + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
