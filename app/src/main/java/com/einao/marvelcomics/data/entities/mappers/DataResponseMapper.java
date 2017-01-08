package com.einao.marvelcomics.data.entities.mappers;

import com.einao.marvelcomics.data.entities.ComicsEntity;
import com.einao.marvelcomics.data.network.entities.NetworkError;
import com.einao.marvelcomics.data.network.entities.NetworkResponse;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.DataError;
import com.einao.marvelcomics.domain.beans.DataResponse;

public class DataResponseMapper {

    public DataResponse<Comics> map(NetworkResponse<ComicsEntity> networkResponse) {

        DataResponse<Comics> dataResponse;

        if (networkResponse.isSuccessful()) {
            dataResponse = setComicsDataResponse(networkResponse);
        } else {
            dataResponse = setErrorDataResponse(networkResponse);
        }

        return dataResponse;
    }

    private DataResponse<Comics> setComicsDataResponse(NetworkResponse<ComicsEntity> networkResponse) {
        DataResponse<Comics> dataResponse = new DataResponse<Comics>();

        ComicsEntityMapper comicsEntityMapper = new ComicsEntityMapper();
        Comics comics = comicsEntityMapper.map(networkResponse.getResponse());

        dataResponse.setData(comics);
        return dataResponse;
    }

    private DataResponse<Comics> setErrorDataResponse(NetworkResponse<ComicsEntity> networkResponse) {
        DataResponse<Comics> dataResponse = new DataResponse<Comics>();
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

    public DataResponse<Comics> map(DataResponse<ComicsEntity> comicsEntity) {
        ComicsEntityMapper comicsMapper = new ComicsEntityMapper();
        Comics comics = comicsMapper.map(comicsEntity.getData());

        DataResponse<Comics> comicsDataResponse = new DataResponse<>();
        comicsDataResponse.setData(comics);
        return comicsDataResponse;
    }
}
