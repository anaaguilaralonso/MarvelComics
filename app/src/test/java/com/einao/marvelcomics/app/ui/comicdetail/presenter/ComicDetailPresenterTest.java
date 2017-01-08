package com.einao.marvelcomics.app.ui.comicdetail.presenter;

import com.einao.marvelcomics.app.ui.comicdetail.view.ComicDetailView;
import com.einao.marvelcomics.app.ui.common.ComicViewModelObjectMother;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class ComicDetailPresenterTest {

    @Mock
    private ComicDetailView comicDetailView;

    private ComicDetailPresenter comicDetailPresenter;

    @Before
    public void init() {
        comicDetailPresenter = new ComicDetailPresenter(comicDetailView);
        ComicViewModelObjectMother comicViewModelObjectMother = new ComicViewModelObjectMother();

        comicDetailPresenter.setComic(comicViewModelObjectMother.getComicViewModel());
    }

    @Test
    public void onStart_showComicTitle() {

        comicDetailPresenter.start();

        Mockito.verify(comicDetailView, Mockito.atLeast(1)).setTitle(Mockito.anyString());
    }

    @Test
    public void onStart_showComicDescription() {

        comicDetailPresenter.start();

        Mockito.verify(comicDetailView, Mockito.atLeast(1)).setDescription(Mockito.anyString());
    }

    @Test
    public void onStart_showComicImage() {

        comicDetailPresenter.start();

        Mockito.verify(comicDetailView, Mockito.atLeast(1)).setImage(Mockito.anyString());
    }

}