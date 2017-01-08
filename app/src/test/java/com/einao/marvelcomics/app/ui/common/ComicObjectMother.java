package com.einao.marvelcomics.app.ui.common;

import com.einao.marvelcomics.domain.beans.Comic;
import com.einao.marvelcomics.domain.beans.Comics;

import java.util.Random;

public class ComicObjectMother {

    public Comic getSimpleComic() {
        Comic.ComicBuilder comicBuilder = new Comic.ComicBuilder();
        comicBuilder.setId(new Random().nextInt());
        comicBuilder.setTitle("Comic Title " + Math.random());
        comicBuilder.setDescription("Description of the comic");
        comicBuilder.setImageUrl("http://www.url.com");
        return comicBuilder.build();
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
