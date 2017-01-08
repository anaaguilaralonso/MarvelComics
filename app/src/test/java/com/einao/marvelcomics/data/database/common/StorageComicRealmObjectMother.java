package com.einao.marvelcomics.data.database.common;

import com.einao.marvelcomics.data.database.realm.entities.ComicRealmObject;

import java.util.Random;

public class StorageComicRealmObjectMother {

    public ComicRealmObject getSimpleComic() {
        ComicRealmObject comic = new ComicRealmObject();
        comic.setId(new Random().nextInt());
        comic.setTitle("Comic Title " + Math.random());
        comic.setDescription("Description of the comic: " + comic.getTitle());
        comic.setImageUrl("http://www.ab.com");
        return comic;
    }
}
