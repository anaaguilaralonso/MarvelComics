package com.einao.marvelcomics.app.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.einao.marvelcomics.R;

import butterknife.ButterKnife;

/**
 * Created by akiana on 3/1/17.
 */

public abstract class BaseActivity<T extends Presenter> extends AppCompatActivity {

    protected T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayout());

        ButterKnife.bind(this);

        if (presenter == null){
            presenter = initPresenter();
        }
    }


    public abstract int getLayout();
    public abstract T initPresenter();
}
