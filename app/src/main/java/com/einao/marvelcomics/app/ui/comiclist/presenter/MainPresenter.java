package com.einao.marvelcomics.app.ui.comiclist.presenter;


import com.einao.marvelcomics.app.ui.comiclist.view.MainView;
import com.einao.marvelcomics.app.ui.common.Presenter;

import java.util.ArrayList;

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
        ArrayList<String> comicList = getComicList();
        showComicList(comicList);
    }

    private ArrayList<String> getComicList() {
        ArrayList<String> fakeList = new ArrayList<String>();
        fakeList.add("Title 1");
        fakeList.add("Title 2");
        fakeList.add("Title 3");

        return fakeList;
    }

    private void showComicList(ArrayList<String> comicList){
        for (int i = 0; i < comicList.size(); i++){
            mainView.addComic(comicList.get(i));
        }
    }
}
