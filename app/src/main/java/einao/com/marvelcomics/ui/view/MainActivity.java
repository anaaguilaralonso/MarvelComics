package einao.com.marvelcomics.ui.view;

import android.os.Bundle;

import einao.com.marvelcomics.R;
import einao.com.marvelcomics.ui.common.BaseActivity;
import einao.com.marvelcomics.ui.common.Presenter;
import einao.com.marvelcomics.ui.presenter.MainPresenter;

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
