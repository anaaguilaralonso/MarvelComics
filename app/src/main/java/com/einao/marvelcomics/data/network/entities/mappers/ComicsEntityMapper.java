package com.einao.marvelcomics.data.network.entities.mappers;

import com.einao.marvelcomics.data.network.entities.NetworkResponse;
import com.einao.marvelcomics.data.network.entities.marvelentities.ComicEntity;
import com.einao.marvelcomics.domain.beans.Comic;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.DataResponse;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Ana Aguilar.
 */

public class ComicsEntityMapper {

    public DataResponse<Comics> map(NetworkResponse<List<ComicEntity>> networkResponse) {

        DataResponse<Comics> dataResponse;

        if (networkResponse.hasError()){
            dataResponse = setErrorDataResponse(networkResponse);
        }else{
            dataResponse = setComicsDataResponse(networkResponse);
        }

        return dataResponse;
    }

    private DataResponse<Comics> setComicsDataResponse(NetworkResponse<List<ComicEntity>> networkResponse) {
        DataResponse<Comics> dataResponse =  new DataResponse<Comics>();

        Comics comics = new Comics();
        ComicEntityMapper comicMapper = new ComicEntityMapper();
        List<ComicEntity> comicEntities = networkResponse.getResponse();

        Iterator<ComicEntity> iterator = comicEntities.iterator();
        while (iterator.hasNext()) {
            Comic comic = comicMapper.map(iterator.next());
            comics.add(comic);
        }
        dataResponse.setData(comics);

        return dataResponse;
    }

    private DataResponse<Comics> setErrorDataResponse(NetworkResponse<List<ComicEntity>> networkResponse) {
        DataResponse<Comics> dataResponse =  new DataResponse<Comics>();

        dataResponse.setCode(networkResponse.getCode());
        dataResponse.setError(networkResponse.getError());

        return dataResponse;
    }

}
