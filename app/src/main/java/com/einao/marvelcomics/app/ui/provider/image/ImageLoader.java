package com.einao.marvelcomics.app.ui.provider.image;

public interface ImageLoader<T> {

    void loadImage(T imageView, String url);

}
