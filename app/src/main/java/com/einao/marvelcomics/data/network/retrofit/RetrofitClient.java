package com.einao.marvelcomics.data.network.retrofit;

import com.einao.marvelcomics.data.network.common.Endpoints;

import retrofit2.Retrofit;

public class RetrofitClient {

    private final Retrofit retrofit;

    public RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Endpoints.HTTP_BASEURL)
                .build();
    }

    public RetrofitComicService getComicService() {
        return retrofit.create(RetrofitComicService.class);
    }
}
