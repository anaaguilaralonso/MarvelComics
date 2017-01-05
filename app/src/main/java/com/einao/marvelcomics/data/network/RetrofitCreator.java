package com.einao.marvelcomics.data.network;

/**
 * Created by Ana Aguilar.
 */

public class RetrofitCreator implements NetworkDataSourceCreator {

    public ComicRestDataSource factoryMethod() {
        return new RetrofitCient();
    }
}
