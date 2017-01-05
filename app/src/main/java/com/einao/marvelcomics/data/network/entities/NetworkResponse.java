package com.einao.marvelcomics.data.network.entities;

/**
 * Created by Ana Aguilar.
 */

public class NetworkResponse<T> {
    int code;
    String error;
    boolean hasError;

    T response;

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

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public boolean hasError() {
        return hasError;
    }
}
