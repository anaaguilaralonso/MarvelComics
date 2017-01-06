package com.einao.marvelcomics.app.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.einao.marvelcomics.R;
import com.einao.marvelcomics.app.App;
import com.einao.marvelcomics.domain.ComicRepository;

import butterknife.ButterKnife;

/**

 */

public abstract class BaseActivity<T extends Presenter> extends AppCompatActivity implements BaseView {

    protected T presenter;

    protected ComicRepository comicRepository;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayout());

        ButterKnife.bind(this);

        comicRepository = ((App)this.getApplication()).repositoryProvider.getComicRepository();

        injectDependencies();

        if (presenter == null){
            presenter = initPresenter();
        }


    }

    public abstract int getLayout();
    public abstract T initPresenter();
    public abstract void injectDependencies();

    @Override
    public void showToast(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
