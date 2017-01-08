package com.einao.marvelcomics.domain.beans;

/**

 */

public class DataResponse<T> {

    DataError error;

    T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DataError getError() {
        return error;
    }

    public void setError(DataError error) {
        this.error = error;
    }

    public boolean isSuccessful(){
        return error == null;
    }
}
