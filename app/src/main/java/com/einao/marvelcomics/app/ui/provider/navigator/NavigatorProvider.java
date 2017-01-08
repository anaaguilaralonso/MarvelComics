package com.einao.marvelcomics.app.ui.provider.navigator;

import android.app.Activity;

public class NavigatorProvider {

    public DetailNavigator getDetailNavigator(Activity activity) {
        return new DetailNavigator(activity);
    }
}
