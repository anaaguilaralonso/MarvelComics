package com.einao.marvelcomics.app;

import android.app.Application;
import android.support.annotation.NonNull;

import com.einao.marvelcomics.app.policy.ShortDatabasePolicy;
import com.einao.marvelcomics.app.provider.RepositoryProvider;
import com.einao.marvelcomics.app.provider.UseCaseProvider;
import com.einao.marvelcomics.app.threads.ThreadManagerImpl;
import com.einao.marvelcomics.domain.providers.ImageLoader;
import com.einao.marvelcomics.app.ui.provider.image.PicassoImageLoader;
import com.einao.marvelcomics.data.database.StorageDataSourceCreator;
import com.einao.marvelcomics.data.database.realm.RealmCreator;
import com.einao.marvelcomics.data.network.NetworkDataSourceCreator;
import com.einao.marvelcomics.data.network.retrofit.RetrofitCreator;
import com.einao.marvelcomics.domain.policy.DatabasePolicy;
import com.einao.marvelcomics.domain.threads.ThreadManager;

public class App extends Application {

    public UseCaseProvider useCaseProvider;
    public ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();

        useCaseProvider = getUseCaseProvider();
        imageLoader = getImageLoader();
    }

    private UseCaseProvider getUseCaseProvider() {
        RepositoryProvider repositoryProvider = getRepositoryProvider();
        ThreadManager threadManager = getThreadManager();

        return getUseCaseProvider(threadManager, repositoryProvider);
    }

    @NonNull
    private RepositoryProvider getRepositoryProvider() {
        NetworkDataSourceCreator networkDataSourceCreator = getNetworkDataSourceCreator();
        StorageDataSourceCreator storageDataSourceCreator = getStorageDataSourceCreator();
        DatabasePolicy databasePolicy = getDatabasePolicy();

        return getRepositoryProvider(networkDataSourceCreator,
                storageDataSourceCreator, databasePolicy);
    }

    private UseCaseProvider getUseCaseProvider(ThreadManager threadManager, RepositoryProvider repositoryProvider) {
        return new UseCaseProvider(threadManager, repositoryProvider);
    }

    private ThreadManager getThreadManager() {
        return ThreadManagerImpl.getInstance();
    }

    @NonNull
    private RepositoryProvider getRepositoryProvider(NetworkDataSourceCreator networkDataSourceCreator,
                                                     StorageDataSourceCreator storageDataSourceCreator,
                                                     DatabasePolicy databasePolicy) {
        return new RepositoryProvider(networkDataSourceCreator, storageDataSourceCreator, databasePolicy);
    }

    @NonNull
    private RetrofitCreator getNetworkDataSourceCreator() {
        return new RetrofitCreator();
    }


    public DatabasePolicy getDatabasePolicy() {
        return new ShortDatabasePolicy();
    }

    public StorageDataSourceCreator getStorageDataSourceCreator() {
        return new RealmCreator(this);
    }

    public ImageLoader getImageLoader() {
        return new PicassoImageLoader(this);
    }
}
