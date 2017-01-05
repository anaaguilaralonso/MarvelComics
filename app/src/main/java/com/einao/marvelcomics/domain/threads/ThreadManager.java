package com.einao.marvelcomics.domain.threads;

/**
 * Created by Ana Aguilar.
 */

public interface ThreadManager {
    void post(Runnable runnable);
}
