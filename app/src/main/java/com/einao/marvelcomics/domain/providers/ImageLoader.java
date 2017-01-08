package com.einao.marvelcomics.domain.providers;

public interface ImageLoader<T> {

    void loadImage(T imageView, String url);

}
