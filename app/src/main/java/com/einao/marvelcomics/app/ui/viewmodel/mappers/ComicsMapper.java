package com.einao.marvelcomics.app.ui.viewmodel.mappers;

import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.app.ui.viewmodel.ComicsViewModel;
import com.einao.marvelcomics.domain.beans.Comic;
import com.einao.marvelcomics.domain.beans.Comics;

import java.util.Iterator;

/**
 * Created by Ana Aguilar.
 */

public class ComicsMapper {

    public static ComicsViewModel map(Comics comics) {
        ComicsViewModel comicsViewModel= getComicsViewModelFromComics(comics);
        return comicsViewModel;
    }

    private static ComicsViewModel getComicsViewModelFromComics(Comics comics) {
        ComicsViewModel comicsViewModel = new ComicsViewModel();
        Iterator<Comic> iterator = comics.iterator();

        while (iterator.hasNext()) {
            ComicViewModel comic = getComicViewModelFromComic(iterator.next());
            comicsViewModel.add(comic);
        }
        return comicsViewModel;
    }

    private static ComicViewModel getComicViewModelFromComic(Comic comic) {
        ComicMapper comicMapper = new ComicMapper();
        return comicMapper.map(comic);
    }
}
