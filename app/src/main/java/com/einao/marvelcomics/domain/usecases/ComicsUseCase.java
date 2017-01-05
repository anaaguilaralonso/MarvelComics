package com.einao.marvelcomics.domain.usecases;

import android.support.annotation.NonNull;

import com.einao.marvelcomics.data.ComicDataRepository;
import com.einao.marvelcomics.domain.ComicRepository;
import com.einao.marvelcomics.domain.INotification;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.threads.ThreadManager;

/**
 * Created by Ana Aguilar.
 */

public class ComicsUseCase extends UseCase<Comics, Void> {

    private ComicRepository comicRepository;
    private INotification<Comics> notification;
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
                        notification.onSuccess(comics);
                    }
                });
            }
        });
        thread.start();
    }

    public INotification<Comics> getNotification() {
        return notification;
    }

    public void registerNotificator(INotification<Comics> notification) {
        this.notification = notification;
    }
}
