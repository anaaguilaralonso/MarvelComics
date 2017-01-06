package com.einao.marvelcomics.app;

import android.app.Application;
import android.support.annotation.NonNull;

import com.einao.marvelcomics.app.provider.RepositoryProvider;
import com.einao.marvelcomics.data.network.retrofit.RetrofitCreator;

public class App extends Application {

    public RepositoryProvider repositoryProvider;

    @Override
    public void onCreate() {
        super.onCreate();
        repositoryProvider = getRepositoryProvider();
    }

    @NonNull
    private RepositoryProvider getRepositoryProvider() {
        return new RepositoryProvider(new RetrofitCreator());
    }
}
