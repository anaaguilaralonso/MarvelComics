package com.einao.marvelcomics.domain;

import com.einao.marvelcomics.domain.beans.DataError;

public interface ICallback<T> {

    void onSuccess(T response);

    void onError(DataError error);

}
