package com.einao.marvelcomics.app.ui.comicdetail.presenter;

import com.einao.marvelcomics.app.ui.comicdetail.view.ComicDetailView;
import com.einao.marvelcomics.app.ui.common.Presenter;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;

public class ComicDetailPresenter implements Presenter {

    ComicDetailView comicDetailView;
    ComicViewModel comic;

    public ComicDetailPresenter(ComicDetailView comicDetailView) {
        this.comicDetailView = comicDetailView;
    }

    @Override
    public void start() {
        showComic();
    }

    private void showComic() {
        comicDetailView.setTitle(comic.title);
        comicDetailView.setDescription(comic.description);
        comicDetailView.setImage(comic.imageUrl);
    }

    @Override
    public void stop() {

    }

    public void setComic(ComicViewModel comic) {
        this.comic = comic;
    }
}
