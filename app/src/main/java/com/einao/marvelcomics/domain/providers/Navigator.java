package com.einao.marvelcomics.domain.providers;

public interface Navigator<T> {
    void goTo(T viewModel);
}
