package com.einao.marvelcomics.data.database.realm;

import android.content.Context;

import com.einao.marvelcomics.data.database.ComicStorageDataSource;
import com.einao.marvelcomics.data.database.StorageDataSourceCreator;

public class RealmCreator implements StorageDataSourceCreator {
    RealmClient realmClient;

    public RealmCreator(Context context){
        realmClient = new RealmClient(context);
    }


    @Override
    public ComicStorageDataSource createComicDataSource() {
        return new ComicStorageDataSourceRealm(realmClient);
    }
}
