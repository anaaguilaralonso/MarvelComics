package com.einao.marvelcomics.app.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.einao.marvelcomics.app.App;
import com.einao.marvelcomics.app.provider.UseCaseProvider;
import com.einao.marvelcomics.app.ui.provider.navigator.NavigatorProvider;
import com.einao.marvelcomics.domain.providers.ImageLoader;
import com.einao.marvelcomics.domain.providers.Navigator;

import butterknife.ButterKnife;

public abstract class BaseActivity<T extends Presenter> extends AppCompatActivity implements BaseView {

    protected T presenter;

    protected UseCaseProvider useCaseProvider;
    protected ImageLoader imageLoader;
    protected NavigatorProvider navigatorProvider;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayout());

        ButterKnife.bind(this);

        useCaseProvider = ((App) this.getApplication()).useCaseProvider;
        imageLoader = ((App) this.getApplication()).getImageLoader();

        navigatorProvider = new NavigatorProvider();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getMenu() != 0) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(getMenu(), menu);
            return true;
        }else{
            return super.onCreateOptionsMenu(menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return onOptionsItemSelected(item);
        }
    }

    public abstract int getLayout();

    public abstract T initPresenter();

    public abstract int getMenu();

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
