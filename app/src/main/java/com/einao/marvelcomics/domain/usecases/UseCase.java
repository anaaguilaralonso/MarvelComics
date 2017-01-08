package com.einao.marvelcomics.domain.usecases;

import com.einao.marvelcomics.domain.UseCaseCallback;

/**

 */
public abstract class UseCase<T, Z> {

    public abstract void execute();

    public abstract void addCallback(UseCaseCallback<T> notification);

    public abstract void stopCallback();
}
