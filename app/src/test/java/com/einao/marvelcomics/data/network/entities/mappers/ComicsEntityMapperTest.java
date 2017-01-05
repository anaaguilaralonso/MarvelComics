package com.einao.marvelcomics.data.network.entities.mappers;

import com.einao.marvelcomics.data.network.common.ComicEntityGenerator;
import com.einao.marvelcomics.data.network.entities.ComicEntity;
import com.einao.marvelcomics.domain.beans.Comics;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

/**
 * Created by Ana Aguilar.
 */
@RunWith(MockitoJUnitRunner.class)

public class ComicsEntityMapperTest {

    @Spy
    private ComicsEntityMapper comicsMapper;

    @Test
    public void onComicsMap_allItemsAdded() {
        int numberOfComics = 4;
        ComicEntityGenerator comicGenerator = new ComicEntityGenerator();
        List<ComicEntity> comicsEntity = comicGenerator.getSimpleComicList(numberOfComics);

        Comics comics = comicsMapper.map(comicsEntity);

        Assert.assertTrue(comics.getCount() == numberOfComics);
    }


}