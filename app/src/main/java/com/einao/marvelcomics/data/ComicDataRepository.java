package com.einao.marvelcomics.data;

import com.einao.marvelcomics.data.database.ComicStorageDataSource;
import com.einao.marvelcomics.data.entities.ComicsEntity;
import com.einao.marvelcomics.data.entities.mappers.DataResponseMapper;
import com.einao.marvelcomics.data.network.ComicNetworkDataSource;
import com.einao.marvelcomics.data.network.entities.NetworkResponse;
import com.einao.marvelcomics.domain.ComicRepository;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.DataResponse;

public class ComicDataRepository implements ComicRepository {

    private final ComicNetworkDataSource networkDataSource;
    private final ComicStorageDataSource storageDataSource;

    public ComicDataRepository(ComicNetworkDataSource comicNetworkDataSource, ComicStorageDataSource comicStorageDataSource) {
        networkDataSource = comicNetworkDataSource;
        storageDataSource = comicStorageDataSource;
    }

    @Override
    public DataResponse<Comics> getComics() {

        NetworkResponse<ComicsEntity> networkResponse = networkDataSource.getComics();

        DataResponseMapper dataResponseMapper = new DataResponseMapper();
        DataResponse<Comics> dataComicResponse = dataResponseMapper.map(networkResponse);
        return dataComicResponse;
    }

}
