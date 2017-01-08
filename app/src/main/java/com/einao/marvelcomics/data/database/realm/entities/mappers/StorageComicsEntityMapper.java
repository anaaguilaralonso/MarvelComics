package com.einao.marvelcomics.data.database.realm.entities.mappers;

import com.einao.marvelcomics.data.database.realm.entities.ComicRealmObject;
import com.einao.marvelcomics.data.entities.ComicEntity;
import com.einao.marvelcomics.data.entities.ComicsEntity;
import com.einao.marvelcomics.domain.beans.Comic;
import com.einao.marvelcomics.domain.beans.Comics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    public List<ComicRealmObject> map(Comics comics) {
        StorageComicEntityMapper comicMapper = new StorageComicEntityMapper();
        List<ComicRealmObject> realmObjects = new ArrayList<>();

        Iterator<Comic> iterator = comics.iterator();
        while (iterator.hasNext()) {
            ComicRealmObject comic = comicMapper.map(iterator.next());
            realmObjects.add(comic);
        }

        return realmObjects;
    }
}
