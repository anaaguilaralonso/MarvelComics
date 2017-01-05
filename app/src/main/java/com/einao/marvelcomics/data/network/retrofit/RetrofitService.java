package com.einao.marvelcomics.data.network.retrofit;

import com.einao.marvelcomics.app.common.ApiConstants;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ana Aguilar.
 */

public interface RetrofitService {

    @GET(ApiConstants.HTTP_ENDPOINT)
    Call<ResponseBody> listComics();

}
