package com.einao.marvelcomics.app.ui.comiclist.presenter;


import com.einao.marvelcomics.app.ui.comiclist.view.MainView;
import com.einao.marvelcomics.app.ui.common.Presenter;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.app.ui.viewmodel.ComicsViewModel;
import com.einao.marvelcomics.app.ui.viewmodel.mappers.ComicsMapper;
import com.einao.marvelcomics.domain.beans.Comic;
import com.einao.marvelcomics.domain.beans.Comics;

import java.util.Iterator;

/**
 * Created by Ana Aguilar.
 */

public class MainPresenter implements Presenter {

    MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }


    @Override
    public void start() {
        Comics comicList = getComicList();
        ComicsMapper comicsMapper = new ComicsMapper();
        ComicsViewModel comicsViewModel = comicsMapper.map(comicList);
        showComicList(comicsViewModel);
    }

    private Comics getComicList() {
        Comics fakeList = new Comics();
        fakeList.add(new Comic("Title 1"));
        fakeList.add(new Comic("Title 2"));
        fakeList.add(new Comic("Title 3"));

        return fakeList;
    }

    private void showComicList(ComicsViewModel comicList) {
        Iterator<ComicViewModel> iterator = comicList.iterator();
        while (iterator.hasNext()) {
            mainView.addComic(iterator.next());
        }
    }
}
