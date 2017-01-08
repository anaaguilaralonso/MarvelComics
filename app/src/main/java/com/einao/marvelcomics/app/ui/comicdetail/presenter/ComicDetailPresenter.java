package com.einao.marvelcomics.app.ui.comicdetail.presenter;

import com.einao.marvelcomics.app.ui.comicdetail.view.ComicDetailView;
import com.einao.marvelcomics.app.ui.common.Presenter;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;


public class ComicDetailPresenter extends Presenter<ComicDetailView> {

    ComicViewModel comic;

    public ComicDetailPresenter(ComicDetailView comicDetailView) {
        super(comicDetailView);
    }

    @Override
    public void start() {
        showComic();
    }

    private void showComic() {
        if(!existView()) return;
        view.get().setTitle(comic.title);
        view.get().setDescription(comic.description);
        view.get().setImage(comic.imageUrl);
    }

    @Override
    public void stop() {

    }

    public void setComic(ComicViewModel comic) {
        this.comic = comic;
    }


}
