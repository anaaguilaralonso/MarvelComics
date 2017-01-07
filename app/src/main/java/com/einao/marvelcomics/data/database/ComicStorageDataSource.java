package com.einao.marvelcomics.data.database;

import com.einao.marvelcomics.data.entities.ComicsEntity;
import com.einao.marvelcomics.domain.beans.DataResponse;

public interface ComicStorageDataSource {
    DataResponse<ComicsEntity> getComics();
}
