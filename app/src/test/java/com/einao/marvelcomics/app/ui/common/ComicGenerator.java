package com.einao.marvelcomics.app.ui.common;

import com.einao.marvelcomics.domain.beans.Comic;
import com.einao.marvelcomics.domain.beans.Comics;

/**
 * Created by Ana Aguilar.
 */

public class ComicGenerator {

    public Comic getSimpleComic() {
        Comic comic = new Comic();
        comic.setTitle("Comic Title " + Math.random());
        return comic;
    }

    public Comics getSimpleComicList(int numberItems) {
        Comics comics = new Comics();
        for (int i = 0; i < numberItems; i++) {
            Comic comic = getSimpleComic();
            comics.add(comic);
        }
        return comics;
    }
}
