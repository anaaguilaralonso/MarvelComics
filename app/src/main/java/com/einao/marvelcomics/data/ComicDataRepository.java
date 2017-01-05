package com.einao.marvelcomics.data;

import com.einao.marvelcomics.data.network.ComicRestDataSource;
import com.einao.marvelcomics.data.network.NetworkDataSourceCreator;
import com.einao.marvelcomics.data.network.RetrofitCreator;
import com.einao.marvelcomics.domain.ComicRepository;
import com.einao.marvelcomics.domain.INotification;
import com.einao.marvelcomics.domain.beans.Comic;
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
        return dataSource.getComics();
    }

}
