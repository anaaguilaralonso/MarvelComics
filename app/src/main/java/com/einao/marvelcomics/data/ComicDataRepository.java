package com.einao.marvelcomics.data;

import com.einao.marvelcomics.data.network.ComicNetworkDataSource;
import com.einao.marvelcomics.data.network.NetworkDataSourceCreator;
import com.einao.marvelcomics.data.network.entities.ComicEntity;
import com.einao.marvelcomics.data.network.entities.mappers.ComicsEntityMapper;
import com.einao.marvelcomics.data.network.retrofit.RetrofitCreator;
import com.einao.marvelcomics.domain.ComicRepository;
import com.einao.marvelcomics.domain.beans.Comics;

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
    public Comics getComics() {

        List<ComicEntity> comicsEntity = null;
        comicsEntity = networkDataSource.getComics();

        ComicsEntityMapper comicsMapper = new ComicsEntityMapper();
        Comics comics = comicsMapper.map(comicsEntity);
        return comics;
    }

}
