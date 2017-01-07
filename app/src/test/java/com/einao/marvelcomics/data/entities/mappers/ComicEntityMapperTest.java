package com.einao.marvelcomics.data.entities.mappers;

import com.einao.marvelcomics.data.ComicEntityGenerator;
import com.einao.marvelcomics.data.entities.ComicEntity;
import com.einao.marvelcomics.domain.beans.Comic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ComicEntityMapperTest {

    @Spy
    private ComicEntityMapper comicMapper;

    @Test
    public void onComicsMap_checkTitle() {
        ComicEntityGenerator comicGenerator = new ComicEntityGenerator();
        ComicEntity comicEntity = comicGenerator.getSimpleComic();

        Comic comic = comicMapper.map(comicEntity);

        Assert.assertTrue(comic.getTitle().compareTo(comicEntity.getTitle()) == 0);
    }

}