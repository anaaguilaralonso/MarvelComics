package com.einao.marvelcomics.data.network.retrofit;

import com.einao.marvelcomics.data.network.common.ApiConstants;
import com.einao.marvelcomics.data.network.common.Endpoints;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**

 */

public interface RetrofitComicService {

    @GET(Endpoints.HTTP_ENDPOINT_HULK_COMICS)
    Call<ResponseBody> listComics(@Query("ts") String ts, @Query("hash") String hash, @Query("apikey") String apiKey, @Query("limit") int limit);

}
