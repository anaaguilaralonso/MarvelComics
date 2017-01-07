package com.einao.marvelcomics.data.network;

import com.einao.marvelcomics.data.entities.ComicsEntity;
import com.einao.marvelcomics.data.network.entities.NetworkResponse;

public interface ComicNetworkDataSource {
    NetworkResponse<ComicsEntity> getComics();

    Long getLastComicsRequest();
}
