package com.einao.marvelcomics.domain.beans;

/**
 * Created by Ana Aguilar.
 */

public class DataResponse<T> {

    int code;
    String error;
    boolean hasError;

    T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
        hasError = true;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean hasError() {
        return hasError;
    }
}
