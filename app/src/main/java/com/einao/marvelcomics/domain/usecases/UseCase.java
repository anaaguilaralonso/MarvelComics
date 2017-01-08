package com.einao.marvelcomics.domain.usecases;

import com.einao.marvelcomics.domain.UseCaseCallback;

public abstract class UseCase<TResponse, Param> {

    public abstract void execute();

    public abstract void addCallback(UseCaseCallback<TResponse> notification);

    public abstract void stopCallback();
}
