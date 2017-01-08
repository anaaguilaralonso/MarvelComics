package com.einao.marvelcomics.app.threads;

import android.os.Handler;
import android.os.Looper;

import com.einao.marvelcomics.domain.threads.ThreadManager;


public class ThreadManagerImpl implements ThreadManager {

    private Handler handler;

    public ThreadManagerImpl() {
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void post(Runnable runnable) {
        handler.post(runnable);
    }
}
