package com.einao.marvelcomics.app.ui.comiclist.view;

import android.os.Bundle;

import com.einao.marvelcomics.R;
import com.einao.marvelcomics.app.ui.comiclist.presenter.MainPresenter;
import com.einao.marvelcomics.app.ui.common.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public MainPresenter initPresenter() {
        return new MainPresenter(this);
    }

}
