package einao.com.marvelcomics.ui.presenter;

import einao.com.marvelcomics.ui.common.Presenter;
import einao.com.marvelcomics.ui.view.MainView;

/**
 * Created by akiana on 3/1/17.
 */

public class MainPresenter implements Presenter {

    MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

}
