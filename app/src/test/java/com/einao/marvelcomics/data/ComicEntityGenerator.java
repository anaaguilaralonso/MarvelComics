package com.einao.marvelcomics.data;

import com.einao.marvelcomics.data.entities.ComicEntity;
import com.einao.marvelcomics.data.entities.ComicsEntity;

public class ComicEntityGenerator {


    public ComicEntity getSimpleComic() {
        ComicEntity comicEntity = new ComicEntity();
        comicEntity.setTitle("Comic Title " + Math.random());
        comicEntity.setDescription("Description of the comic: "+comicEntity.getTitle());
        comicEntity.setImageUrl("http://hola.com");
        return comicEntity;
    }

    public ComicsEntity getSimpleComicList(int numberItems) {
        ComicsEntity comics = new ComicsEntity();
        for (int i = 0; i < numberItems; i++) {
            ComicEntity comic = getSimpleComic();
            comics.add(comic);
        }
        return comics;
    }
}
