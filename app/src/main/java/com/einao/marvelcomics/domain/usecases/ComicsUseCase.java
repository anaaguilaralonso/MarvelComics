package com.einao.marvelcomics.domain.usecases;

import com.einao.marvelcomics.domain.ComicRepository;
import com.einao.marvelcomics.domain.UseCaseCallback;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.DataResponse;
import com.einao.marvelcomics.domain.threads.ThreadManager;

public class ComicsUseCase extends UseCase<Comics, Void> {

    private ComicRepository comicRepository;
    private UseCaseCallback<Comics> callback;
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
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (dataResponse.isSuccessful()) {
                            handleSuccessful(dataResponse);
                        } else {
                            handleError(dataResponse);
                        }
                    }
                };
                threadManager.post(runnable);
            }
        });
        thread.start();
    }

    private void handleError(DataResponse<Comics> dataResponse) {
        if (isCallbackAlive()) {
            callback.onError(dataResponse.getError());
        }
    }

    private void handleSuccessful(DataResponse<Comics> dataResponse) {
        Comics comics = dataResponse.getData();
        if (isCallbackAlive()) {
            callback.onSuccess(comics);
        }
    }

    @Override
    public void addCallback(UseCaseCallback<Comics> notification) {
        this.callback = notification;
    }

    @Override
    public void stopCallback() {
        this.callback = null;
    }

    private boolean isCallbackAlive() {
        return callback != null;
    }
}
