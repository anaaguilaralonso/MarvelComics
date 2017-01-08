package com.einao.marvelcomics.app.ui.viewmodel.mappers;

import com.einao.marvelcomics.app.ui.common.ComicObjectMother;
import com.einao.marvelcomics.app.ui.viewmodel.ComicsViewModel;
import com.einao.marvelcomics.domain.beans.Comics;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComicsMapperTest {

    @Spy
    private ComicsMapper comicsMapper;

    @Test
    public void onComicsMap_allItemsAdded() {
        int numberOfComics = 4;
        ComicObjectMother comicObjectMother = new ComicObjectMother();
        Comics comics = comicObjectMother.getSimpleComicList(numberOfComics);

        ComicsViewModel comicsViewModel = comicsMapper.map(comics);

        Assert.assertTrue(comicsViewModel.getCount() == numberOfComics);
    }

}