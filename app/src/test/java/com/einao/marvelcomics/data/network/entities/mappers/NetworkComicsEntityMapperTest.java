package com.einao.marvelcomics.data.network.entities.mappers;

import com.einao.marvelcomics.data.entities.ComicsEntity;
import com.einao.marvelcomics.data.network.common.NetworkComicResultGenerator;
import com.einao.marvelcomics.data.network.entities.NetworkResponse;
import com.einao.marvelcomics.data.network.entities.marvelentities.Result;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class NetworkComicsEntityMapperTest {

    @Spy
    private NetworkComicsEntityMapper comicsMapper;

    @Test
    public void onSuccess_addAllComics() {
        int numberOfComics = 4;
        NetworkComicResultGenerator comicGenerator = new NetworkComicResultGenerator();
        NetworkResponse<List<Result>> networkResponse = comicGenerator.getNetworkComicsResponse(numberOfComics);

        ComicsEntity comics = comicsMapper.map(networkResponse.getResponse());

        Assert.assertTrue(comics.getCount() == numberOfComics);
    }
}