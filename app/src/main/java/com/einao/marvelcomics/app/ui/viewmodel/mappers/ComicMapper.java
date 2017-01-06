package com.einao.marvelcomics.app.ui.viewmodel.mappers;

import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.domain.beans.Comic;

/**

 */

public class ComicMapper {

    public ComicViewModel map(Comic comic) {
        ComicViewModel comicViewModel = new ComicViewModel();
        comicViewModel.setTitle(comic.getTitle());
        return comicViewModel;
    }
}
