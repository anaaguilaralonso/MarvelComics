package com.einao.marvelcomics.app.ui.comiclist.presenter;


import com.einao.marvelcomics.app.ui.comiclist.view.MainView;
import com.einao.marvelcomics.app.ui.common.Presenter;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.app.ui.viewmodel.ComicsViewModel;
import com.einao.marvelcomics.app.ui.viewmodel.mappers.ComicsMapper;
import com.einao.marvelcomics.domain.INotificator;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.DataError;
import com.einao.marvelcomics.domain.usecases.ComicsUseCase;

import java.util.Iterator;

public class MainPresenter implements Presenter, INotificator<Comics> {

    private MainView mainView;

    private ComicsUseCase comicsUseCase;

    public MainPresenter(MainView mainView, ComicsUseCase comicsUseCase) {
        this.mainView = mainView;
        this.comicsUseCase = comicsUseCase;
    }

    @Override
    public void start() {
        getComicList();
    }

    protected void getComicList() {
        comicsUseCase.registerNotificator(this);
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
    public void onError(DataError error) {
        mainView.showToast(error.getMessage());
    }
}
