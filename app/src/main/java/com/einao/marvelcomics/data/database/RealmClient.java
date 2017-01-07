package com.einao.marvelcomics.data.database;

import io.realm.Realm;

public class RealmClient {

    Realm realm;

    public RealmClient() {
        realm = Realm.getDefaultInstance();
    }

    public Realm getRealm() {
        return realm;
    }
}
