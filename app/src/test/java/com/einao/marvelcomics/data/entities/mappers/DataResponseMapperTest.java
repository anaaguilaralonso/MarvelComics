package com.einao.marvelcomics.data.entities.mappers;

import com.einao.marvelcomics.data.ComicEntityObjectMother;
import com.einao.marvelcomics.data.entities.ComicsEntity;
import com.einao.marvelcomics.data.network.entities.NetworkError;
import com.einao.marvelcomics.data.network.entities.NetworkResponse;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.DataResponse;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DataResponseMapperTest {

    @Spy
    private DataResponseMapper dataResponseMapper;

    @Test
    public void onSuccess_responseSuccessful() {
        int numberOfComics = 4;
        ComicEntityObjectMother comicGenerator = new ComicEntityObjectMother();
        ComicsEntity comics = comicGenerator.getSimpleComicList(numberOfComics);
        NetworkResponse<ComicsEntity> networkResponse = new NetworkResponse<>();
        networkResponse.setResponse(comics);

        DataResponse<Comics> comicsDataResponse = dataResponseMapper.map(networkResponse);

        Assert.assertTrue(comicsDataResponse.isSuccessful());
    }

    @Test
    public void onFailure_responseError() {
        NetworkResponse<ComicsEntity> networkResponse = new NetworkResponse<>();
        NetworkError error = new NetworkError();
        error.setCode(0);
        error.setMessage("Error");
        networkResponse.setError(error);

        DataResponse<Comics> comicsDataResponse = dataResponseMapper.map(networkResponse);

        Assert.assertTrue(!comicsDataResponse.isSuccessful());
    }

}