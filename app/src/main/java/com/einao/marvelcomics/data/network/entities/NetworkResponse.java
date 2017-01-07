package com.einao.marvelcomics.data.network.entities;

/**

 */

public class NetworkResponse<T> {

    NetworkError error;

    T response;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public NetworkError getError() {
        return error;
    }

    public void setError(NetworkError error) {
        this.error = error;
    }

    public boolean isSuccessful(){
        return error == null;
    }
}
