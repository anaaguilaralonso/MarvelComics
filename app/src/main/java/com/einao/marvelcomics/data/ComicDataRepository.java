package com.einao.marvelcomics.data;

import com.einao.marvelcomics.data.network.ComicRestDataSource;
import com.einao.marvelcomics.data.network.NetworkDataSourceCreator;
import com.einao.marvelcomics.data.network.retrofit.RetrofitCreator;
import com.einao.marvelcomics.data.network.entities.ComicsEntity;
import com.einao.marvelcomics.data.network.entities.mappers.ComicsEntityMapper;
import com.einao.marvelcomics.domain.ComicRepository;
import com.einao.marvelcomics.domain.beans.Comics;

/**
 * Created by Ana Aguilar.
 */

public class ComicDataRepository implements ComicRepository {


    ComicRestDataSource dataSource;
    NetworkDataSourceCreator networkDataSourceCreator;

    public ComicDataRepository() {
        networkDataSourceCreator = new RetrofitCreator();
    }

    @Override
    public Comics getComics() {
        dataSource = networkDataSourceCreator.factoryMethod();
        ComicsEntity comicsEntity = dataSource.getComics();
        ComicsEntityMapper comicsMapper = new ComicsEntityMapper();
        return comicsMapper.map(comicsEntity);
    }

}
