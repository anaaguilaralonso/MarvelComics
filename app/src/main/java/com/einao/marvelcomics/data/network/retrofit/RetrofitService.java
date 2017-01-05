package com.einao.marvelcomics.data.network.retrofit;

import com.einao.marvelcomics.app.common.ApiConstants;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ana Aguilar.
 */

public interface RetrofitService {

    @GET(ApiConstants.HTTP_ENDPOINT_HULK_COMICS)
    Call<ResponseBody> listComics(@Query("ts") String ts, @Query("hash") String hash, @Query("apikey") String apiKey, @Query("limit") int limit);

}
