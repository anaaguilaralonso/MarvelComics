package com.einao.marvelcomics.app.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.einao.marvelcomics.app.App;
import com.einao.marvelcomics.app.provider.UseCaseProvider;
import com.einao.marvelcomics.domain.providers.ImageLoader;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends Presenter> extends AppCompatActivity implements BaseView {

    protected T presenter;

    protected UseCaseProvider useCaseProvider;
    protected ImageLoader imageLoader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayout());

        ButterKnife.bind(this);

        useCaseProvider = ((App) this.getApplication()).useCaseProvider;
        imageLoader = ((App) this.getApplication()).getImageLoader();

        if (presenter == null) {
            presenter = initPresenter();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (presenter != null){
            presenter.stop();
        }
    }

    public abstract int getLayout();

    public abstract T initPresenter();

    @Override
    public void showToast(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
