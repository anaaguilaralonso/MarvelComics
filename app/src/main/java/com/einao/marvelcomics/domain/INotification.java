package com.einao.marvelcomics.domain;

/**
 * Created by Ana Aguilar.
 */
public interface INotification<T> {

    public void onSuccess(T response);

    public void onError(String error);

}
