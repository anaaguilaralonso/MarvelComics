package com.einao.marvelcomics.data.network;

import com.einao.marvelcomics.domain.INotification;
import com.einao.marvelcomics.domain.beans.Comic;
import com.einao.marvelcomics.domain.beans.Comics;

/**
 * Created by Ana Aguilar.
 */

public class RetrofitCient implements ComicRestDataSource {

    public RetrofitCient(){
    }

    @Override
    public Comics getComics() {
        Comics fakeList = new Comics();
        fakeList.add(new Comic("Title 1"));
        fakeList.add(new Comic("Title 2"));
        fakeList.add(new Comic("Title 3"));
        return fakeList;
    }
}
