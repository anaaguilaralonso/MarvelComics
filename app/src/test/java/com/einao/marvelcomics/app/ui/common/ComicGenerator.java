package com.einao.marvelcomics.app.ui.common;

import com.einao.marvelcomics.domain.beans.Comic;
import com.einao.marvelcomics.domain.beans.Comics;

public class ComicGenerator {

    public Comic getSimpleComic() {
        Comic comic = new Comic();
        comic.setTitle("Comic Title " + Math.random());
        comic.setDescription("Description of the comic " + comic.getTitle());
        comic.setImageUrl("http://www.url.com");
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
