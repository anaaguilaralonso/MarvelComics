package com.einao.marvelcomics.data.network.entities.mappers;

import com.einao.marvelcomics.data.entities.ComicEntity;
import com.einao.marvelcomics.data.network.common.NetworkComicResultObjectMother;
import com.einao.marvelcomics.data.network.entities.marvelentities.Result;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NetworkComicEntityMapperTest {

    @Spy
    private NetworkComicEntityMapper comicMapper;

    @Test
    public void onComicsMap_checkTitle() {
        NetworkComicResultObjectMother comicGenerator = new NetworkComicResultObjectMother();
        Result result = comicGenerator.getSimpleComic();

        ComicEntity comic = comicMapper.map(result);

        Assert.assertTrue(comic.getTitle().compareTo(result.getTitle()) == 0);
    }

}