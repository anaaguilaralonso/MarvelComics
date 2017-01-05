package com.einao.marvelcomics.domain.usecases;

import com.einao.marvelcomics.data.ComicDataRepository;
import com.einao.marvelcomics.domain.ComicRepository;
import com.einao.marvelcomics.domain.INotificator;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.NullComicsObject;
import com.einao.marvelcomics.domain.threads.ThreadManager;

/**
 * Created by Ana Aguilar.
 */

public class ComicsUseCase extends UseCase<Comics, Void> {

    private ComicRepository comicRepository;
    private INotificator<Comics> notificator;
    private ThreadManager threadManager;

    public ComicsUseCase(ThreadManager threadManager) {
        comicRepository = new ComicDataRepository();
        this.threadManager = threadManager;
    }

    @Override
    public void execute() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                final Comics comics = comicRepository.getComics();
                threadManager.post(new Runnable() {
                    @Override
                    public void run() {
                        if (comics instanceof NullComicsObject) {
                            notificator.onError(((NullComicsObject) comics).getError());
                        } else {
                            notificator.onSuccess(comics);
                        }

                    }
                });
            }
        });
        thread.start();
    }

    public void registerNotificator(INotificator<Comics> notification) {
        this.notificator = notification;
    }
}
