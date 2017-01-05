package com.einao.marvelcomics.app.ui.comiclist.presenter;

import com.einao.marvelcomics.app.ui.comiclist.view.MainView;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.domain.usecases.ComicsUseCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by Ana Aguilar.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    private MainView mainView;

    @Mock
    private ComicsUseCase comicsUseCase;

    private MainPresenter mainPresenter;

    @Before
    public void init() {
        mainPresenter = new MainPresenter(mainView);
    }

    @Test
    public void onStart_getComicList_addItemsToList() {
        mainPresenter.start();

        Mockito.verify(mainView, Mockito.atLeast(1)).addComic(Mockito.any(ComicViewModel.class));
    }

}