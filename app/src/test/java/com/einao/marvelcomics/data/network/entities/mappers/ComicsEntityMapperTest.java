package com.einao.marvelcomics.data.network.entities.mappers;

import com.einao.marvelcomics.data.network.common.ComicEntityGenerator;
import com.einao.marvelcomics.data.network.entities.NetworkResponse;
import com.einao.marvelcomics.data.network.entities.marvelentities.ComicEntity;
import com.einao.marvelcomics.data.network.entities.marvelentities.Events;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.DataResponse;

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
    public void onSuccess_addAllComics() {
        int numberOfComics = 4;
        ComicEntityGenerator comicGenerator = new ComicEntityGenerator();
        NetworkResponse<List<ComicEntity>> networkResponse = comicGenerator.getNetworkComicsResponse(numberOfComics);

        DataResponse<Comics> dataResponse = comicsMapper.map(networkResponse);
        Comics comics = dataResponse.getData();

        Assert.assertTrue(comics.getCount() == numberOfComics);
    }

    @Test
    public void onFailure_setError() {
        ComicEntityGenerator comicGenerator = new ComicEntityGenerator();
        NetworkResponse<List<ComicEntity>> networkResponse = comicGenerator.getFailureNetworkComicsResponse();

        DataResponse<Comics> dataResponse = comicsMapper.map(networkResponse);

        Assert.assertTrue(dataResponse.hasError());
    }

}