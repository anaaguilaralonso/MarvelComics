package com.einao.marvelcomics.app.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.einao.marvelcomics.app.App;
import com.einao.marvelcomics.app.ui.provider.image.ImageLoader;
import com.einao.marvelcomics.domain.usecases.ComicsUseCase;

import butterknife.ButterKnife;

/**

 */

public abstract class BaseActivity<T extends Presenter> extends AppCompatActivity implements BaseView {

    protected T presenter;

    protected ComicsUseCase comicsUseCase;
    protected ImageLoader imageLoader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayout());

        ButterKnife.bind(this);

        comicsUseCase = ((App) this.getApplication()).useCaseProvider.getComicsUseCase();
        imageLoader = ((App) this.getApplication()).getImageLoader();

        injectDependencies();

        if (presenter == null) {
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
