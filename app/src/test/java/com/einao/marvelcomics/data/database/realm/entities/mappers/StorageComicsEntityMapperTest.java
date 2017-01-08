package com.einao.marvelcomics.data.database.realm.entities.mappers;

import com.einao.marvelcomics.data.database.common.StorageComicRealmObjectMother;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StorageComicsEntityMapperTest {

    @Spy
    private StorageComicsEntityMapper comicsMapper;

    @Test
    public void onSuccess_addAllComics() {
        int numberOfComics = 4;
        StorageComicRealmObjectMother comicGenerator = new StorageComicRealmObjectMother();
        //List<ComicRealmObject> simpleComicList = comicGenerator.getSimpleComicList(numberOfComics);

        //ComicsEntity comics = comicsMapper.map(simpleComicList);

        //Assert.assertTrue(comics.getCount() == numberOfComics);
    }

}