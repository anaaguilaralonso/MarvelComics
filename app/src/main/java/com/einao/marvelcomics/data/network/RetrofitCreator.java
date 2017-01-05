package com.einao.marvelcomics.data.network;

import com.einao.marvelcomics.domain.INotification;

/**
 * Created by Ana Aguilar.
 */

public class RetrofitCreator implements NetworkDataSourceCreator {

    public ComicRestDataSource factoryMethod(INotification notification) {
        return new RetrofitCient(notification);
    }
}
