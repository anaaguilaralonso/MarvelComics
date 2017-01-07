package com.einao.marvelcomics.domain.usecases;

import com.einao.marvelcomics.data.ComicDataRepository;
import com.einao.marvelcomics.domain.ComicRepository;
import com.einao.marvelcomics.domain.INotificator;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.DataResponse;
import com.einao.marvelcomics.domain.threads.ThreadManager;

public class ComicsUseCase extends UseCase<Comics, Void> {

    private ComicRepository comicRepository;
    private INotificator<Comics> notificator;
    private ThreadManager threadManager;

    public ComicsUseCase(ThreadManager threadManager, ComicRepository comicRepository) {
        this.comicRepository = comicRepository;
        this.threadManager = threadManager;
    }

    @Override
    public void execute() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                final DataResponse<Comics> dataResponse = comicRepository.getComics();
                threadManager.post(new Runnable() {
                    @Override
                    public void run() {
                        if (dataResponse.isSuccessful()){
                            Comics comics = dataResponse.getData();
                            notificator.onSuccess(comics);
                        } else {
                            notificator.onError(dataResponse.getError());
                        }
                    }
                });
            }
        });
        thread.start();
    }

    @Override
    public void registerNotificator(INotificator<Comics> notification) {
        this.notificator = notification;
    }
}
