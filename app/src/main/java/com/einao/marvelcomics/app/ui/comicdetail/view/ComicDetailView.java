package com.einao.marvelcomics.app.ui.comicdetail.view;

import com.einao.marvelcomics.app.ui.common.BaseView;

public interface ComicDetailView extends BaseView {
    void setTitle(String title);

    void setDescription(String description);

    void setImage(String imageUrl);
}
