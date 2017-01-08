package com.einao.marvelcomics.app.ui.common;

import java.lang.ref.WeakReference;

public abstract class Presenter<TView> {

    protected final WeakReference<TView> view;

    protected Presenter(TView view) {
        this.view = new WeakReference<>(view);
    }

    public abstract void start();

    public abstract void stop();

    public boolean existView() {
        return view.get() != null;
    }

}
