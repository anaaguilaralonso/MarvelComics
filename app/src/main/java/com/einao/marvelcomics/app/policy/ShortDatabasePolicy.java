package com.einao.marvelcomics.app.policy;

import com.einao.marvelcomics.domain.policy.DatabasePolicy;

public class ShortDatabasePolicy implements DatabasePolicy {

    public static final int SHORT_COMIC_VALID_TIME = 5000;

    @Override
    public boolean isValid(Long lastComicsRequest) {
        return ((System.nanoTime()/1000) - lastComicsRequest) < SHORT_COMIC_VALID_TIME;
    }
}
