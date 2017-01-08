package com.einao.marvelcomics.app.provider;

import com.einao.marvelcomics.data.ComicDataRepository;
import com.einao.marvelcomics.data.database.ComicStorageDataSource;
import com.einao.marvelcomics.data.database.StorageDataSourceCreator;
import com.einao.marvelcomics.data.network.ComicNetworkDataSource;
import com.einao.marvelcomics.data.network.NetworkDataSourceCreator;
import com.einao.marvelcomics.domain.ComicRepository;
import com.einao.marvelcomics.domain.policy.DatabasePolicy;

public class RepositoryProvider {

    private final ComicRepository comicRepository;

    public RepositoryProvider(NetworkDataSourceCreator networkDataSourceCreator, StorageDataSourceCreator
            storageDataSourceCreator, DatabasePolicy databasePolicy) {
        ComicNetworkDataSource comicNetworkDataSource = networkDataSourceCreator.createComicDataSource();
        ComicStorageDataSource comicStorageDataSource = storageDataSourceCreator.createComicDataSource();

        comicRepository = new ComicDataRepository(comicNetworkDataSource, comicStorageDataSource, databasePolicy);
    }

    public ComicRepository getComicRepository() {
        return comicRepository;
    }
}
