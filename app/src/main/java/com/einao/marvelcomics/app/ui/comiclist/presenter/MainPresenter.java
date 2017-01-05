package com.einao.marvelcomics.app.ui.comiclist.presenter;


import android.util.Log;

import com.einao.marvelcomics.app.threads.ThreadManagerImpl;
import com.einao.marvelcomics.app.ui.comiclist.view.MainView;
import com.einao.marvelcomics.app.ui.common.Presenter;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.app.ui.viewmodel.ComicsViewModel;
import com.einao.marvelcomics.app.ui.viewmodel.mappers.ComicsMapper;
import com.einao.marvelcomics.domain.INotification;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.usecases.ComicsUseCase;

import java.util.Iterator;

/**
 * Created by Ana Aguilar.
 */

public class MainPresenter implements Presenter, INotification<Comics> {

    private MainView mainView;

    private ComicsUseCase comicsUseCase;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void start() {
        getComicList();
    }

    protected void getComicList() {

        comicsUseCase = new ComicsUseCase(this);
        comicsUseCase.execute();

    }

    private void showComicList(ComicsViewModel comicList) {
        Iterator<ComicViewModel> iterator = comicList.iterator();
        while (iterator.hasNext()) {
            mainView.addComic(iterator.next());
        }
    }

    @Override
    public void onSuccess(Comics response) {
        ComicsMapper comicsMapper = new ComicsMapper();
        ComicsViewModel comicsViewModel = comicsMapper.map(response);
        showComicList(comicsViewModel);
    }

    @Override
    public void onError(String error) {
        Log.i(this.getClass().getName(), "Error");
    }
}
