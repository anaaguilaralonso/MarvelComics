package com.einao.marvelcomics.data.database.realm.entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ComicRealmObject extends RealmObject {

    @PrimaryKey
    private Integer id;

    private String title;
    private String description;
    private String imageUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
