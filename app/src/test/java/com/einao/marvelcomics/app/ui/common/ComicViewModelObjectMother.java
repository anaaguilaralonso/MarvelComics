package com.einao.marvelcomics.app.ui.common;

import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;

public class ComicViewModelObjectMother {

    public ComicViewModel getComicViewModel() {
        ComicViewModel comicViewModel = new ComicViewModel();
        comicViewModel.title = "Title";
        comicViewModel.imageUrl = "url";
        comicViewModel.description = "description";
        return comicViewModel;
    }
}
