package com.einao.marvelcomics.data.network.retrofit;

import android.util.Log;

import com.einao.marvelcomics.app.common.ApiConstants;
import com.einao.marvelcomics.data.network.ComicRestDataSource;
import com.einao.marvelcomics.data.network.entities.ComicDataWrapper;
import com.einao.marvelcomics.data.network.entities.ComicEntity;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Ana Aguilar.
 */

public class RetrofitCient implements ComicRestDataSource {

    private Retrofit retrofit;

    public RetrofitCient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.HTTP_BASEURL)
                .build();
    }

    @Override
    public List<ComicEntity> getComics() {

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<ResponseBody> responseBodyCall = retrofitService.listComics();
        try {
            Response<ResponseBody> response = responseBodyCall.execute();
            if (response.isSuccessful()){

                String json = null;
                try {
                    json = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Gson gson = new Gson();

                Log.i(this.getClass().getName(), json);

                ComicDataWrapper comicDataWrapper = gson.fromJson(json, ComicDataWrapper.class);
                List<ComicEntity> comics = comicDataWrapper.getData().getResults();

                return comics;
            }else{
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
