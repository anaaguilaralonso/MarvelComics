package com.einao.marvelcomics.data.network;

import com.einao.marvelcomics.data.network.entities.ComicEntity;
import com.einao.marvelcomics.data.network.entities.ComicsEntity;
import com.einao.marvelcomics.domain.beans.Comic;
import com.einao.marvelcomics.domain.beans.Comics;

/**
 * Created by Ana Aguilar.
 */

public class RetrofitCient implements ComicRestDataSource {

    public RetrofitCient() {
    }

    @Override
    public ComicsEntity getComics() {
        ComicsEntity fakeList = new ComicsEntity();
        fakeList.add(new ComicEntity("Title 1"));
        fakeList.add(new ComicEntity("Title 2"));
        fakeList.add(new ComicEntity("Title 3"));
        return fakeList;
    }
}
