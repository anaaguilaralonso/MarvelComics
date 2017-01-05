package com.einao.marvelcomics.domain.usecases;

import com.einao.marvelcomics.data.ComicDataRepository;
import com.einao.marvelcomics.domain.ComicRepository;
import com.einao.marvelcomics.domain.INotification;
import com.einao.marvelcomics.domain.beans.Comics;

/**
 * Created by Ana Aguilar.
 */

public class ComicsUseCase extends UseCase<Comics, Void> {

    private ComicRepository comicRepository;
    private INotification<Comics> notification;

    public ComicsUseCase(INotification notification) {
        comicRepository = new ComicDataRepository();
        this.notification = notification;
    }

    @Override
    public void execute() {
        Comics comics = comicRepository.getComics();
        notification.onSuccess(comics);
    }
}
