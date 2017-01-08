package com.einao.marvelcomics.data.entities.mappers;

import com.einao.marvelcomics.data.ComicEntityObjectMother;
import com.einao.marvelcomics.data.entities.ComicsEntity;
import com.einao.marvelcomics.domain.beans.Comics;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComicsEntityMapperTest {

    @Spy
    private ComicsEntityMapper comicsMapper;

    @Test
    public void onSuccess_addAllComics() {
        int numberOfComics = 4;
        ComicEntityObjectMother comicGenerator = new ComicEntityObjectMother();
        ComicsEntity comicsEntity = comicGenerator.getSimpleComicList(numberOfComics);

        Comics comics = comicsMapper.map(comicsEntity);

        Assert.assertTrue(comics.getCount() == numberOfComics);
    }
}