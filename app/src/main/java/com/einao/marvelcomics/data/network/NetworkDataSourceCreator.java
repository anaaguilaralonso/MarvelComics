package com.einao.marvelcomics.data.network;

import com.einao.marvelcomics.domain.INotification;

/**
 * Created by Ana Aguilar.
 */

public interface NetworkDataSourceCreator {

    ComicRestDataSource factoryMethod(INotification notification);
}
