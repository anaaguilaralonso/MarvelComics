package com.einao.marvelcomics.data.database.realm.entities.mappers;

import com.einao.marvelcomics.data.database.realm.entities.ComicRealmObject;
import com.einao.marvelcomics.data.entities.ComicEntity;
import com.einao.marvelcomics.domain.beans.Comic;

import java.util.UUID;

public class StorageComicEntityMapper {

    public ComicEntity map(ComicRealmObject comicRealmObject) {
        ComicEntity comic = new ComicEntity();
        comic.setTitle(comicRealmObject.getTitle());
        comic.setDescription(comicRealmObject.getDescription());
        comic.setImageUrl(comicRealmObject.getImageUrl());
        return comic;
    }

    public ComicRealmObject map(Comic comic) {
        ComicRealmObject comicRealmObject = new ComicRealmObject();
        comicRealmObject.setId(UUID.randomUUID().toString());
        comicRealmObject.setTitle(comic.getTitle());
        comicRealmObject.setDescription(comic.getDescription());
        comicRealmObject.setImageUrl(comic.getImageUrl());
        return comicRealmObject;
    }
}
