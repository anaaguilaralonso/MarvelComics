package com.einao.marvelcomics.data.network.retrofit;

import android.support.annotation.NonNull;
import android.util.Log;

import com.einao.marvelcomics.app.common.ApiConstants;
import com.einao.marvelcomics.data.network.ComicNetworkDataSource;
import com.einao.marvelcomics.data.network.entities.NetworkError;
import com.einao.marvelcomics.data.network.entities.NetworkResponse;
import com.einao.marvelcomics.data.network.entities.marvelentities.ComicDataContainer;
import com.einao.marvelcomics.data.network.entities.marvelentities.ComicDataWrapper;
import com.einao.marvelcomics.data.network.entities.marvelentities.ComicEntity;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**

 */

public class RetrofitCient implements ComicNetworkDataSource {

    private Retrofit retrofit;

    public RetrofitCient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.HTTP_BASEURL)
                .build();
    }

    @Override
    public NetworkResponse<List<ComicEntity>> getComics() {

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<ResponseBody> responseBodyCall = retrofitService.listComics(ApiConstants.HTTP_REQUEST_TIMESTAMP, ApiConstants.HTTP_REQUEST_HASH, ApiConstants.HTTP_REQUEST_APIKEY, 5);
        try {
            Response<ResponseBody> response = responseBodyCall.execute();
            if (response.isSuccessful()) {
                NetworkResponse<List<ComicEntity>> networkResponse = new NetworkResponse<List<ComicEntity>>();
                networkResponse.setResponse(getComicsFromResponse(response));
                return networkResponse;
            } else {
                return getErrorResponse(response.code(), response.message());
            }
        }catch (IOException exception){
            return getErrorResponse(0, "Error getting data");
        }
    }

    private NetworkResponse<List<ComicEntity>> getErrorResponse(int code, String message) {
        NetworkResponse<List<ComicEntity>> networkResponse = new NetworkResponse<List<ComicEntity>>();
        NetworkError networkError = createNetworkError(code, message);
        networkResponse.setError(networkError);
        return networkResponse;
    }

    @NonNull
    private NetworkError createNetworkError(int code, String message) {
        NetworkError networkError = new NetworkError();
        networkError.setCode(code);
        networkError.setMessage(message);
        return networkError;
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
