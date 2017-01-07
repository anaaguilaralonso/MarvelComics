package com.einao.marvelcomics.data.database.realm;

import com.einao.marvelcomics.data.database.ComicStorageDataSource;
import com.einao.marvelcomics.data.database.ComicStorageDataSourceRealm;
import com.einao.marvelcomics.data.database.RealmClient;
import com.einao.marvelcomics.data.database.StorageDataSourceCreator;

public class RealmCreator implements StorageDataSourceCreator {

    RealmClient realmClient;

    public RealmCreator() {
        realmClient = new RealmClient();
    }

    @Override
    public ComicStorageDataSource createComicDataSource() {
        return new ComicStorageDataSourceRealm(realmClient);
    }
}
