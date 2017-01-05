package com.einao.marvelcomics.data.network.common;

import com.einao.marvelcomics.data.network.entities.ComicEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ana Aguilar.
 */

public class ComicEntityGenerator {

    public ComicEntity getSimpleComic() {
        ComicEntity comic = new ComicEntity();
        comic.setTitle("Comic Title " + Math.random());
        return comic;
    }

    public List<ComicEntity> getSimpleComicList(int numberItems) {
        List<ComicEntity> comics = new ArrayList<ComicEntity>();
        for (int i = 0; i < numberItems; i++) {
            ComicEntity comic = getSimpleComic();
            comics.add(comic);
        }
        return comics;
    }
}
