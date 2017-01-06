package com.einao.marvelcomics.data.network.entities.mappers;

import com.einao.marvelcomics.data.network.entities.NetworkError;
import com.einao.marvelcomics.data.network.entities.NetworkResponse;
import com.einao.marvelcomics.data.network.entities.marvelentities.ComicEntity;
import com.einao.marvelcomics.domain.beans.Comic;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.DataError;
import com.einao.marvelcomics.domain.beans.DataResponse;

import java.util.Iterator;
import java.util.List;

/**

 */

public class ComicsEntityMapper {

    public DataResponse<Comics> map(NetworkResponse<List<ComicEntity>> networkResponse) {

        DataResponse<Comics> dataResponse;

        if (networkResponse.isSuccessful()){
            dataResponse = setComicsDataResponse(networkResponse);
        }else{
            dataResponse = setErrorDataResponse(networkResponse);
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
        DataError dataError = map(networkResponse.getError());

        dataResponse.setError(dataError);

        return dataResponse;
    }

    private DataError map(NetworkError networkError) {
        DataError dataError = new DataError();

        dataError.setCode(networkError.getCode());
        dataError.setMessage(networkError.getMessage());

        return dataError;
    }

}
