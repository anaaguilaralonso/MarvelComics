package com.einao.marvelcomics.app.ui.comiclist.presenter;

import com.einao.marvelcomics.app.ui.comiclist.view.MainView;
import com.einao.marvelcomics.app.ui.common.ComicGenerator;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
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

/**
 * Created by Ana Aguilar.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    private MainView mainView;

    @Mock
    private ThreadManager threadManager;

    @Mock
    private ComicsUseCase comicsUseCase;

    private MainPresenter mainPresenter;

    private ComicGenerator comicGenerator;

    @Before
    public void init() {
        comicGenerator = new ComicGenerator();
        mainPresenter = new MainPresenter(mainView, comicsUseCase);
    }

    @Test
    public void onStart_getComicList_addItemsToList() {
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                mainPresenter.onSuccess(comicGenerator.getSimpleComicList(3));
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
                mainPresenter.onError("Error");
                return null;
            }
        }).when(comicsUseCase).execute();

        mainPresenter.start();

        Mockito.verify(mainView).showToast(Mockito.anyString());
    }

}