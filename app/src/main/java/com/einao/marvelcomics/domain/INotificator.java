package com.einao.marvelcomics.domain;

/**
 * Created by Ana Aguilar.
 */
public interface INotificator<T> {

    public void onSuccess(T response);

    public void onError(String error);

}
