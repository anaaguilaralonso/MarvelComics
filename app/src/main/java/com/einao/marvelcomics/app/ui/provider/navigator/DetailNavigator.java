package com.einao.marvelcomics.app.ui.provider.navigator;

import android.app.Activity;
import android.content.Intent;

import com.einao.marvelcomics.app.ui.comicdetail.view.ComicDetailActivity;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.domain.providers.Navigator;

public class DetailNavigator implements Navigator<ComicViewModel> {

    private Activity activity;

    public DetailNavigator(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void goTo(ComicViewModel comic) {
        Intent intent = new Intent(activity, ComicDetailActivity.class);
        intent.putExtra("comic", comic);
        activity.startActivity(intent);
    }
}
