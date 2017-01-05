package com.einao.marvelcomics.data.network.retrofit;

import com.einao.marvelcomics.data.network.ComicRestDataSource;
import com.einao.marvelcomics.data.network.NetworkDataSourceCreator;
import com.einao.marvelcomics.data.network.retrofit.RetrofitCient;

/**
 * Created by Ana Aguilar.
 */

public class RetrofitCreator implements NetworkDataSourceCreator {

    public ComicRestDataSource factoryMethod() {
        return new RetrofitCient();
    }
}
