package com.einao.marvelcomics.app.ui.viewmodel.mappers;

import com.einao.marvelcomics.app.ui.common.ComicObjectMother;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.domain.beans.Comic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComicMapperTest {

    @Spy
    private ComicMapper comicMapper;

    @Test
    public void onComicsMap_checkTitle() {
        ComicObjectMother comicObjectMother = new ComicObjectMother();
        Comic comic = comicObjectMother.getSimpleComic();

        ComicViewModel comicViewModel = comicMapper.map(comic);

        Assert.assertTrue(comic.getTitle().compareTo(comicViewModel.title) == 0);
    }

    @Test
    public void onComicsMap_checkDescription() {
        ComicObjectMother comicObjectMother = new ComicObjectMother();
        Comic comic = comicObjectMother.getSimpleComic();

        ComicViewModel comicViewModel = comicMapper.map(comic);

        Assert.assertTrue(comic.getDescription().compareTo(comicViewModel.description) == 0);
    }

    @Test
    public void onComicsMap_checkImageUrl() {
        ComicObjectMother comicObjectMother = new ComicObjectMother();
        Comic comic = comicObjectMother.getSimpleComic();

        ComicViewModel comicViewModel = comicMapper.map(comic);

        Assert.assertTrue(comic.getImageUrl().compareTo(comicViewModel.imageUrl) == 0);
    }

}