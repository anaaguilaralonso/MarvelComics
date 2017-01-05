package com.einao.marvelcomics.data;

import com.einao.marvelcomics.data.network.ComicNetworkDataSource;
import com.einao.marvelcomics.data.network.NetworkDataSourceCreator;
import com.einao.marvelcomics.data.network.entities.NetworkResponse;
import com.einao.marvelcomics.data.network.entities.marvelentities.ComicEntity;
import com.einao.marvelcomics.data.network.entities.mappers.ComicsEntityMapper;
import com.einao.marvelcomics.data.network.retrofit.RetrofitCreator;
import com.einao.marvelcomics.domain.ComicRepository;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.DataResponse;

import java.util.List;

/**
 * Created by Ana Aguilar.
 */

public class ComicDataRepository implements ComicRepository {

    ComicNetworkDataSource networkDataSource;
    NetworkDataSourceCreator networkDataSourceCreator;

    public ComicDataRepository() {
        networkDataSourceCreator = new RetrofitCreator();
        networkDataSource = networkDataSourceCreator.factoryMethod();
    }

    @Override
    public DataResponse<Comics> getComics() {

        NetworkResponse<List<ComicEntity>> networkResponse = null;
        networkResponse = networkDataSource.getComics();

        ComicsEntityMapper comicsMapper = new ComicsEntityMapper();
        DataResponse<Comics> dataComicResponse = comicsMapper.map(networkResponse);
        return dataComicResponse;
    }

}
