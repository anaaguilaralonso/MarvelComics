package einao.com.marvelcomics.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by akiana on 3/1/17.
 */

public abstract class BaseActivity<T extends Presenter> extends AppCompatActivity {

    private T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (presenter != null){
            presenter = initPresenter();
        }
    }

    public abstract T initPresenter();
}
