package com.einao.marvelcomics.data.database.realm.entities.mappers;

import com.einao.marvelcomics.data.database.realm.entities.ComicRealmObject;
import com.einao.marvelcomics.data.entities.ComicEntity;
import com.einao.marvelcomics.data.entities.ComicsEntity;

import java.util.Iterator;

import io.realm.RealmResults;

public class StorageComicsEntityMapper {

    public ComicsEntity map(RealmResults<ComicRealmObject> comicRealmObjects) {
        ComicsEntity comicsEntity = new ComicsEntity();
        StorageComicEntityMapper comicMapper = new StorageComicEntityMapper();


        Iterator<ComicRealmObject> iterator = comicRealmObjects.iterator();
        while (iterator.hasNext()) {
            ComicEntity comic = comicMapper.map(iterator.next());
            comicsEntity.add(comic);
        }

        return comicsEntity;
    }
}
