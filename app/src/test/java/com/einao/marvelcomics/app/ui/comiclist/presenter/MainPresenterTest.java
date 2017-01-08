package com.einao.marvelcomics.app.ui.comiclist.presenter;

import com.einao.marvelcomics.app.ui.comiclist.view.MainView;
import com.einao.marvelcomics.app.ui.common.ComicObjectMother;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.domain.beans.DataError;
import com.einao.marvelcomics.domain.providers.Navigator;
import com.einao.marvelcomics.domain.threads.ThreadManager;
import com.einao.marvelcomics.domain.usecases.ComicsUseCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    private MainView mainView;

    @Mock
    private ThreadManager threadManager;

    @Mock
    private ComicsUseCase comicsUseCase;

    @Mock
    private Navigator<ComicViewModel> navigator;

    private MainPresenter mainPresenter;

    private ComicObjectMother comicObjectMother;

    @Before
    public void init() {
        comicObjectMother = new ComicObjectMother();
        mainPresenter = new MainPresenter(mainView, navigator, comicsUseCase);
    }

    @Test
    public void onStart_getComicList_addItemsToList() {
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                mainPresenter.callback.onSuccess(comicObjectMother.getSimpleComicList(3));
                return null;
            }
        }).when(comicsUseCase).execute();

        mainPresenter.start();

        Mockito.verify(mainView, Mockito.atLeast(1)).addComic(Mockito.any(ComicViewModel.class));
    }

    @Test
    public void onStart_getComicListError_showErrorMessage() {
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                DataError error = new DataError();
                error.setMessage("Error");
                mainPresenter.callback.onError(error);
                return null;
            }
        }).when(comicsUseCase).execute();

        mainPresenter.start();

        Mockito.verify(mainView).showMessage(Mockito.anyString());
    }

}