package com.einao.marvelcomics.data.database;

import com.einao.marvelcomics.data.database.realm.entities.ComicRealmObject;
import com.einao.marvelcomics.data.database.realm.entities.mappers.StorageComicEntityMapper;
import com.einao.marvelcomics.data.database.realm.entities.mappers.StorageComicsEntityMapper;
import com.einao.marvelcomics.data.entities.ComicsEntity;
import com.einao.marvelcomics.domain.beans.DataResponse;

import io.realm.RealmResults;

public class ComicStorageDataSourceRealm implements ComicStorageDataSource {

    RealmClient realmClient;

    public ComicStorageDataSourceRealm(RealmClient realmClient) {
        this.realmClient = realmClient;
    }

    @Override
    public DataResponse<ComicsEntity> getComics() {

        RealmResults<ComicRealmObject> comicRealmObjects =
                realmClient.getRealm().where(ComicRealmObject.class).findAll();

        ComicsEntity comicsEntity = map(comicRealmObjects);

        DataResponse<ComicsEntity> dataResponse = new DataResponse<>();
        dataResponse.setData(comicsEntity);

        return dataResponse;
    }

    private ComicsEntity map(RealmResults<ComicRealmObject> comicRealmObjects) {
        StorageComicsEntityMapper comicsEntityMapper = new StorageComicsEntityMapper();
        return comicsEntityMapper.map(comicRealmObjects);
    }
}
