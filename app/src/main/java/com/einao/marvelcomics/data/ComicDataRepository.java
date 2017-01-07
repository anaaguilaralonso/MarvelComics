package com.einao.marvelcomics.data;

import com.einao.marvelcomics.data.database.ComicStorageDataSource;
import com.einao.marvelcomics.data.entities.ComicsEntity;
import com.einao.marvelcomics.data.entities.mappers.DataResponseMapper;
import com.einao.marvelcomics.data.network.ComicNetworkDataSource;
import com.einao.marvelcomics.data.network.entities.NetworkResponse;
import com.einao.marvelcomics.domain.ComicRepository;
import com.einao.marvelcomics.domain.policy.DatabasePolicy;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.DataResponse;

public class ComicDataRepository implements ComicRepository {

    private final ComicNetworkDataSource networkDataSource;
    private final ComicStorageDataSource storageDataSource;
    private final DatabasePolicy databasePolicy;

    public ComicDataRepository(ComicNetworkDataSource comicNetworkDataSource,
                               ComicStorageDataSource comicStorageDataSource,
                               DatabasePolicy databasePolicy) {
        networkDataSource = comicNetworkDataSource;
        storageDataSource = comicStorageDataSource;
        this.databasePolicy = databasePolicy;
    }

    @Override
    public DataResponse<Comics> getComics() {

        if (databasePolicy.isValid(networkDataSource.getLastComicsRequest())){
            return getComicsDatabase();
        }else {
            return getComicsNetwork();
        }
    }

    private DataResponse<Comics> getComicsNetwork() {
        NetworkResponse<ComicsEntity> networkResponse = networkDataSource.getComics();

        DataResponseMapper dataResponseMapper = new DataResponseMapper();
        return dataResponseMapper.map(networkResponse);
    }

    public DataResponse<Comics> getComicsDatabase() {
        DataResponse<Comics> databaseResponse =  new DataResponse<>();


        return databaseResponse;
    }
}
