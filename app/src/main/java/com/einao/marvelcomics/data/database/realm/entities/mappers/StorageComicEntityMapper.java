package com.einao.marvelcomics.data.database.realm.entities.mappers;

import com.einao.marvelcomics.data.database.realm.entities.ComicRealmObject;
import com.einao.marvelcomics.data.entities.ComicEntity;

public class StorageComicEntityMapper {

    public ComicEntity map(ComicRealmObject comicRealmObject) {
        ComicEntity comic = new ComicEntity();
        comic.setTitle(comicRealmObject.getTitle());
        comic.setDescription(comicRealmObject.getDescription());
        comic.setImageUrl(comicRealmObject.getImageUrl());
        return comic;
    }
}
