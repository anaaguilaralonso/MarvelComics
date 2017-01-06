package com.einao.marvelcomics.app;

import android.app.Application;
import android.support.annotation.NonNull;

import com.einao.marvelcomics.app.provider.RepositoryProvider;
import com.einao.marvelcomics.app.provider.UseCaseProvider;
import com.einao.marvelcomics.app.threads.ThreadManagerImpl;
import com.einao.marvelcomics.data.network.retrofit.RetrofitCreator;
import com.einao.marvelcomics.domain.threads.ThreadManager;

public class App extends Application {

    public UseCaseProvider useCaseProvider;

    @Override
    public void onCreate() {
        super.onCreate();
        RepositoryProvider repositoryProvider = getRepositoryProvider();
        ThreadManager threadManager = getThreadManager();
        useCaseProvider = getUseCaseProvider(threadManager, repositoryProvider);
    }

    private UseCaseProvider getUseCaseProvider(ThreadManager threadManager, RepositoryProvider repositoryProvider) {
        return new UseCaseProvider(threadManager, repositoryProvider);
    }

    private ThreadManager getThreadManager() {
        return ThreadManagerImpl.getInstance();
    }

    @NonNull
    private RepositoryProvider getRepositoryProvider() {
        return new RepositoryProvider(new RetrofitCreator());
    }


}
