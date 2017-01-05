package com.einao.marvelcomics.data;

import com.einao.marvelcomics.domain.ComicRepository;
import com.einao.marvelcomics.domain.INotification;
import com.einao.marvelcomics.domain.beans.Comic;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.threads.ThreadManager;

/**
 * Created by Ana Aguilar.
 */

public class ComicDataRepository implements ComicRepository {

    INotification<Comics> notification;

    public ComicDataRepository(INotification<Comics> notification) {
        this.notification = notification;
    }

    @Override
    public void getComics() {
        Comics fakeList = new Comics();
        fakeList.add(new Comic("Title 1"));
        fakeList.add(new Comic("Title 2"));
        fakeList.add(new Comic("Title 3"));

        notification.onSuccess(fakeList);
    }

}
