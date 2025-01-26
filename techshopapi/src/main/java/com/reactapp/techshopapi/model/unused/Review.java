package com.reactapp.techshopapi.model.unused;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Review implements Serializable {
    private int id;
    private float rating;
    private String comment;
    private String create_at;

    public Review() {
    }

    public Review(int id, float rating, String comment, String create_at) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.create_at = create_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", create_at='" + create_at + '\'' +
                '}';
    }
}
