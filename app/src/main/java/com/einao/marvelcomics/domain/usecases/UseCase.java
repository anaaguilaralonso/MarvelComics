package com.einao.marvelcomics.domain.usecases;

import com.einao.marvelcomics.domain.INotificator;

/**

 */
public abstract class UseCase<T, Z> {

    public abstract void execute();

    public abstract void registerNotificator(INotificator<T> notification);

}
