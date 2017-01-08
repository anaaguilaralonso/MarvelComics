package com.einao.marvelcomics.data.database.realm;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmClient {

    public RealmClient(Context context) {
        Realm.init(context);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    public Realm getRealm() {
        return Realm.getDefaultInstance();
    }

    public void closeRealm(Realm realm){
        realm.close();
    }
}
