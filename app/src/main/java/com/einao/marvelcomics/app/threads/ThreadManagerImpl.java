package com.einao.marvelcomics.app.threads;

import android.os.Handler;
import android.os.Looper;

import com.einao.marvelcomics.domain.threads.ThreadManager;

/**
 * Created by Ana Aguilar.
 */

public class ThreadManagerImpl implements ThreadManager {

    private static ThreadManager threadManager;

    private Handler handler;

    private ThreadManagerImpl(){
        handler = new Handler(Looper.getMainLooper());
    }

    public static ThreadManager getInstance(){
        if (threadManager == null){
            threadManager = new ThreadManagerImpl();
        }
        return threadManager;
    }

    @Override
    public void post(Runnable runnable){
        handler.post(runnable);
    }
}
