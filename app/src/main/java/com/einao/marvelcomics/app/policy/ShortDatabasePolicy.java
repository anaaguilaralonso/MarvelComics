package com.einao.marvelcomics.app.policy;

import com.einao.marvelcomics.domain.policy.DatabasePolicy;

public class ShortDatabasePolicy implements DatabasePolicy {

    public static final int SHORT_COMIC_VALID_TIME = 10000;

    @Override
    public boolean isValid(Long lastComicsRequest) {
        Long now = System.nanoTime() / (1000*1000);
        return (now - lastComicsRequest) < SHORT_COMIC_VALID_TIME;
    }
}
