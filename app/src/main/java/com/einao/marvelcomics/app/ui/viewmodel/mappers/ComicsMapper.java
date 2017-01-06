package com.einao.marvelcomics.app.ui.viewmodel.mappers;

import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.app.ui.viewmodel.ComicsViewModel;
import com.einao.marvelcomics.domain.beans.Comic;
import com.einao.marvelcomics.domain.beans.Comics;

import java.util.Iterator;

/**

 */

public class ComicsMapper {

    public ComicsViewModel map(Comics comics) {
        ComicsViewModel comicsViewModel = new ComicsViewModel();
        ComicMapper comicMapper = new ComicMapper();

        Iterator<Comic> iterator = comics.iterator();
        while (iterator.hasNext()) {
            ComicViewModel comic = comicMapper.map(iterator.next());
            comicsViewModel.add(comic);
        }
        return comicsViewModel;
    }

}
