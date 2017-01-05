package com.einao.marvelcomics.data.network;

import com.einao.marvelcomics.data.DataSource;
import com.einao.marvelcomics.data.network.entities.ComicsEntity;

/**
 * Created by Ana Aguilar.
 */

public interface ComicRestDataSource extends DataSource {
    ComicsEntity getComics();
}
