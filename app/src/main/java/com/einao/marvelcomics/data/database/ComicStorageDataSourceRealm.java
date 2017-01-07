package com.einao.marvelcomics.data.database;

import android.util.Log;

import com.einao.marvelcomics.data.database.realm.entities.ComicRealmObject;
import com.einao.marvelcomics.data.database.realm.entities.mappers.StorageComicsEntityMapper;
import com.einao.marvelcomics.data.entities.ComicsEntity;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.DataResponse;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ComicStorageDataSourceRealm implements ComicStorageDataSource {

    RealmClient realmClient;

    public ComicStorageDataSourceRealm(RealmClient realmClient) {
        this.realmClient = realmClient;
    }

    @Override
    public DataResponse<ComicsEntity> getComics() {
        Realm realm = realmClient.getRealm();

        RealmResults<ComicRealmObject> comicRealmObjects =
                realm.where(ComicRealmObject.class).findAll();

        ComicsEntity comicsEntity = map(comicRealmObjects);

        DataResponse<ComicsEntity> dataResponse = new DataResponse<>();
        dataResponse.setData(comicsEntity);

        Log.i(this.getClass().getName(), "Getting comic "+comicsEntity.getCount());

        realmClient.closeRealm(realm);

        return dataResponse;
    }

    private ComicsEntity map(RealmResults<ComicRealmObject> comicRealmObjects) {
        StorageComicsEntityMapper comicsEntityMapper = new StorageComicsEntityMapper();
        return comicsEntityMapper.map(comicRealmObjects);
    }

    @Override
    public Comics saveComics(Comics comics) {
        Realm realm = realmClient.getRealm();

        StorageComicsEntityMapper comicMapper = new StorageComicsEntityMapper();

        realm.beginTransaction();
        List<ComicRealmObject> comicsRealmObjects = comicMapper.map(comics);
        List<ComicRealmObject> result = realm.copyToRealmOrUpdate(comicsRealmObjects);
        realm.commitTransaction();

        Log.i(this.getClass().getName(), "Saving comics: "+result.size());

        realmClient.closeRealm(realm);

        return comics;
    }
}
