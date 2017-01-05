package com.einao.marvelcomics.domain;

import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.DataResponse;

/**
 * Created by Ana Aguilar.
 */

public interface ComicRepository {

    DataResponse<Comics>  getComics();

}
