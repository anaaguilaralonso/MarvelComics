package com.einao.marvelcomics.data.network;

import com.einao.marvelcomics.data.DataSource;
import com.einao.marvelcomics.data.network.entities.ComicEntity;

import java.util.List;

/**
 * Created by Ana Aguilar.
 */

public interface ComicRestDataSource extends DataSource {
    List<ComicEntity> getComics();
}
