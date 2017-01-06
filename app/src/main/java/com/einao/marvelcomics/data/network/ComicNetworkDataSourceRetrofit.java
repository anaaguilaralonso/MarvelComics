package com.einao.marvelcomics.data.network;

import android.support.annotation.NonNull;
import android.util.Log;

import com.einao.marvelcomics.data.entities.ComicEntity;
import com.einao.marvelcomics.data.entities.ComicsEntity;
import com.einao.marvelcomics.data.network.common.ApiConstants;
import com.einao.marvelcomics.data.network.entities.NetworkError;
import com.einao.marvelcomics.data.network.entities.NetworkResponse;
import com.einao.marvelcomics.data.network.entities.mappers.CustomComicsEntityMapper;
import com.einao.marvelcomics.data.network.entities.marvelentities.ComicDataContainer;
import com.einao.marvelcomics.data.network.entities.marvelentities.ComicDataWrapper;
import com.einao.marvelcomics.data.network.entities.marvelentities.Result;
import com.einao.marvelcomics.data.network.retrofit.RetrofitClient;
import com.einao.marvelcomics.data.network.retrofit.RetrofitComicService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class ComicNetworkDataSourceRetrofit implements ComicNetworkDataSource {

    RetrofitComicService retrofitComicService;

    public ComicNetworkDataSourceRetrofit(RetrofitClient retrofitClient) {
        this.retrofitComicService = retrofitClient.getComicService();
    }

    @Override
    public NetworkResponse<ComicsEntity> getComics() {

        Call<ResponseBody> responseBodyCall = retrofitComicService.listComics(ApiConstants.HTTP_REQUEST_TIMESTAMP, ApiConstants.HTTP_REQUEST_HASH, ApiConstants.HTTP_REQUEST_APIKEY, 5);
        try {
            return getListNetworkResponse(responseBodyCall);
        } catch (IOException exception) {
            return getErrorResponse(0, "Error getting data. " + exception.getMessage());
        }
    }

    private NetworkResponse<ComicsEntity> getListNetworkResponse(Call<ResponseBody> responseBodyCall) throws IOException {
        Response<ResponseBody> response = responseBodyCall.execute();
        if (response.isSuccessful()) {
            NetworkResponse<ComicsEntity> networkResponse = new NetworkResponse<>();
            networkResponse.setResponse(getComicsFromResponse(response));
            return networkResponse;
        } else {
            return getErrorResponse(response.code(), response.message());
        }
    }

    private NetworkResponse<ComicsEntity> getErrorResponse(int code, String message) {
        NetworkResponse<ComicsEntity> networkResponse = new NetworkResponse<>();
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

    private ComicsEntity getComicsFromResponse(Response<ResponseBody> response) throws IOException {
        String json = response.body().string();
        Log.i(this.getClass().getName(), json);

        ComicsEntity comicEntities = mapJsonToComicEntities(json);
        return comicEntities;
    }

    private ComicsEntity mapJsonToComicEntities(String json) {
        List<Result> results = getComicResults(json);

        CustomComicsEntityMapper comicsEntityMapper = new CustomComicsEntityMapper();
        return comicsEntityMapper.map(results);
    }

    private List<Result> getComicResults(String json) {
        Gson gson = new Gson();
        ComicDataWrapper comicDataWrapper = gson.fromJson(json, ComicDataWrapper.class);

        ComicDataContainer comicDataContainer = comicDataWrapper.getData();
        return comicDataContainer.getResults();
    }
}
