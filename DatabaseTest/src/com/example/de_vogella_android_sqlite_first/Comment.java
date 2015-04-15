package com.example.de_vogella_android_sqlite_first;

/**
 * Created by Yoder on 5/15/2014.
 */
public class Comment {
    private long id;
    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return comment;
    }
}
