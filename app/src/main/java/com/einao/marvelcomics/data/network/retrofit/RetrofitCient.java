package com.einao.marvelcomics.data.network.retrofit;

import android.util.Log;

import com.einao.marvelcomics.app.common.ApiConstants;
import com.einao.marvelcomics.data.network.ComicNetworkDataSource;
import com.einao.marvelcomics.data.network.entities.ComicDataContainer;
import com.einao.marvelcomics.data.network.entities.ComicDataWrapper;
import com.einao.marvelcomics.data.network.entities.ComicEntity;
import com.einao.marvelcomics.data.network.entities.NullComicEntitiesObject;
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

public class RetrofitCient implements ComicNetworkDataSource {

    private Retrofit retrofit;

    public RetrofitCient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.HTTP_BASEURL)
                .build();
    }

    @Override
    public List<ComicEntity> getComics() {

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<ResponseBody> responseBodyCall = retrofitService.listComics(ApiConstants.HTTP_REQUEST_TIMESTAMP, ApiConstants.HTTP_REQUEST_HASH, ApiConstants.HTTP_REQUEST_APIKEY, 5);
        try {
            Response<ResponseBody> response = responseBodyCall.execute();
            if (response.isSuccessful()) {
                List<ComicEntity> comics = getComicsFromResponse(response);
                return comics;
            } else {
                return getNullObject(response.message());
            }
        }catch (IOException exception){
            return getNullObject("Error getting data");
        }

    }

    private NullComicEntitiesObject getNullObject(String error){
        NullComicEntitiesObject nullComicEntityObject = new NullComicEntitiesObject();
        nullComicEntityObject.setError(error);
        return nullComicEntityObject;
    }

    private List<ComicEntity> getComicsFromResponse(Response<ResponseBody> response) throws IOException {
        String json = "";
        Gson gson = new Gson();

        json = response.body().string();
        Log.i(this.getClass().getName(), json);

        List<ComicEntity> comicEntities = mapJsonToComicEntities(json, gson);
        return comicEntities;
    }

    private List<ComicEntity> mapJsonToComicEntities(String json, Gson gson) {
        ComicDataWrapper comicDataWrapper = gson.fromJson(json, ComicDataWrapper.class);
        ComicDataContainer comicDataContainer = comicDataWrapper.getData();
        return comicDataContainer.getResults();
    }
}
