package com.einao.marvelcomics.domain.usecases;

import com.einao.marvelcomics.domain.ICallback;

/**

 */
public abstract class UseCase<T, Z> {

    public abstract void execute();

    public abstract void addCallback(ICallback<T> notification);

    public abstract void stopCallback();
}
