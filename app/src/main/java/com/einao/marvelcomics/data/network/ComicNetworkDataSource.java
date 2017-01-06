package com.einao.marvelcomics.data.network;

import com.einao.marvelcomics.data.DataSource;
import com.einao.marvelcomics.data.network.entities.NetworkResponse;
import com.einao.marvelcomics.data.network.entities.marvelentities.ComicEntity;

import java.util.List;

/**

 */

public interface ComicNetworkDataSource extends DataSource {
    NetworkResponse<List<ComicEntity>> getComics();
}
