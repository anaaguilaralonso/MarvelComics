package com.einao.marvelcomics.data;

import com.einao.marvelcomics.data.entities.ComicEntity;
import com.einao.marvelcomics.data.entities.ComicsEntity;

import java.util.Random;
import java.util.UUID;

public class ComicEntityObjectMother {


    public ComicEntity getSimpleComic() {
        ComicEntity comicEntity = new ComicEntity();
        comicEntity.setId(new Random().nextInt());
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
