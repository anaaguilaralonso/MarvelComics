package com.einao.marvelcomics.data.network.retrofit;

import com.einao.marvelcomics.data.network.ComicNetworkDataSource;
import com.einao.marvelcomics.data.network.NetworkDataSourceCreator;

/**

 */

public class RetrofitCreator implements NetworkDataSourceCreator {

    public ComicNetworkDataSource factoryMethod() {
        return new RetrofitCient();
    }
}
