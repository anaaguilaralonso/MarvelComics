package com.einao.marvelcomics.data.database.realm.entities.mappers;

import com.einao.marvelcomics.data.database.common.StorageComicRealmGenerator;
import com.einao.marvelcomics.data.database.realm.entities.ComicRealmObject;
import com.einao.marvelcomics.data.entities.ComicEntity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class StorageComicEntityMapperTest {

    @Spy
    private StorageComicEntityMapper comicMapper;

    @Test
    public void onComicsMap_checkTitle() {
        StorageComicRealmGenerator comicGenerator = new StorageComicRealmGenerator();
        ComicRealmObject simpleComic = comicGenerator.getSimpleComic();

        ComicEntity comic = comicMapper.map(simpleComic);

        Assert.assertTrue(comic.getTitle().compareTo(simpleComic.getTitle()) == 0);
    }

    @Test
    public void onComicsMap_checkDescription() {
        StorageComicRealmGenerator comicGenerator = new StorageComicRealmGenerator();
        ComicRealmObject simpleComic = comicGenerator.getSimpleComic();

        ComicEntity comic = comicMapper.map(simpleComic);

        Assert.assertTrue(comic.getDescription().compareTo(simpleComic.getDescription()) == 0);
    }

    @Test
    public void onComicsMap_checkImage() {
        StorageComicRealmGenerator comicGenerator = new StorageComicRealmGenerator();
        ComicRealmObject simpleComic = comicGenerator.getSimpleComic();

        ComicEntity comic = comicMapper.map(simpleComic);

        Assert.assertTrue(comic.getImageUrl().compareTo(simpleComic.getImageUrl()) == 0);
    }

}