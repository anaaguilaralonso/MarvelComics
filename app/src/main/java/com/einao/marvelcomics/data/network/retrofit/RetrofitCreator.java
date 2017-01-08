package com.einao.marvelcomics.data.network.retrofit;

import com.einao.marvelcomics.data.network.ComicNetworkDataSource;
import com.einao.marvelcomics.data.network.NetworkDataSourceCreator;


public class RetrofitCreator implements NetworkDataSourceCreator {

    private final RetrofitClient retrofitClient;

    public RetrofitCreator() {
        retrofitClient = new RetrofitClient();
    }

    public ComicNetworkDataSource createComicDataSource() {
        return new ComicNetworkDataSourceRetrofit(retrofitClient);
    }
}
