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

    INotification<Comics> notification;

    ComicRestDataSource dataSource;
    NetworkDataSourceCreator networkDataSourceCreator;

    public ComicDataRepository(INotification<Comics> notification) {
        this.notification = notification;
        networkDataSourceCreator = new RetrofitCreator();
    }

    @Override
    public void getComics() {
        dataSource = networkDataSourceCreator.factoryMethod(notification);
        dataSource.getComics();
    }

}
