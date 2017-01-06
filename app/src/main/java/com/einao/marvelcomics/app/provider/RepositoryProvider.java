package com.einao.marvelcomics.app.provider;

import com.einao.marvelcomics.data.ComicDataRepository;
import com.einao.marvelcomics.data.network.ComicNetworkDataSource;
import com.einao.marvelcomics.data.network.NetworkDataSourceCreator;
import com.einao.marvelcomics.domain.ComicRepository;

public class RepositoryProvider {

    private final ComicRepository comicRepository;

    public RepositoryProvider(NetworkDataSourceCreator networkDataSourceCreator) {
        ComicNetworkDataSource comicNetworkDataSource = networkDataSourceCreator.createComicDataSource();

        comicRepository = new ComicDataRepository(comicNetworkDataSource);
    }

    public ComicRepository getComicRepository() {
        return comicRepository;
    }
}
