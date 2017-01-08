package com.einao.marvelcomics.app.ui.comiclist.presenter;


import com.einao.marvelcomics.app.ui.comiclist.view.MainView;
import com.einao.marvelcomics.app.ui.common.Presenter;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.app.ui.viewmodel.ComicsViewModel;
import com.einao.marvelcomics.app.ui.viewmodel.mappers.ComicsMapper;
import com.einao.marvelcomics.domain.ICallback;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.DataError;
import com.einao.marvelcomics.domain.providers.Navigator;
import com.einao.marvelcomics.domain.usecases.ComicsUseCase;

import java.lang.ref.WeakReference;
import java.util.Iterator;

public class MainPresenter implements Presenter {

    private WeakReference<MainView> mainView;

    private ComicsUseCase comicsUseCase;

    private Navigator<ComicViewModel> comicViewModelNavigator;

    public MainPresenter(MainView mainView, Navigator<ComicViewModel> comicViewModelNavigator, ComicsUseCase
            comicsUseCase) {
        this.mainView = new WeakReference<>(mainView);
        this.comicsUseCase = comicsUseCase;
        this.comicViewModelNavigator = comicViewModelNavigator;
    }

    @Override
    public void start() {
        getComicList();
    }

    @Override
    public void stop() {
        comicsUseCase.stopCallback();
    }

    protected void getComicList() {
        comicsUseCase.addCallback(callback);
        comicsUseCase.execute();
    }

    private void showComicList(ComicsViewModel comicList) {
        if (existView()) {
            mainView.get().removeAllComics();
        }
        Iterator<ComicViewModel> iterator = comicList.iterator();
        while (iterator.hasNext()) {
            if (existView()) {
                mainView.get().addComic(iterator.next());
            }
        }
    }

    private boolean existView() {
        return mainView.get() != null;
    }

    protected ICallback<Comics> callback = new ICallback<Comics>() {
        @Override
        public void onSuccess(Comics response) {
            ComicsMapper comicsMapper = new ComicsMapper();
            ComicsViewModel comicsViewModel = comicsMapper.map(response);
            showComicList(comicsViewModel);
        }

        @Override
        public void onError(DataError error) {
            if (existView()) {
                mainView.get().showToast(error.getMessage());
            }
        }
    };

    public void onComicClicked(ComicViewModel comicViewModel) {
        comicViewModelNavigator.goTo(comicViewModel);
    }
}
