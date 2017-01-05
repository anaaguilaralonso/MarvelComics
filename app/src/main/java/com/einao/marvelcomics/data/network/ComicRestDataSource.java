package com.einao.marvelcomics.data.network;

import com.einao.marvelcomics.data.DataSource;
import com.einao.marvelcomics.domain.beans.Comics;

/**
 * Created by Ana Aguilar.
 */

public interface ComicRestDataSource extends DataSource {
    Comics getComics();
}
