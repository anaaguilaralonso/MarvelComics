package com.einao.marvelcomics.data.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComicsEntity {

    List<ComicEntity> comics;

    public ComicsEntity() {
        comics = new ArrayList<ComicEntity>();
    }

    public ComicsEntity(List<ComicEntity> comics) {
        this.comics = comics;
    }

    public ComicEntity getItem(int position) {
        return comics.get(position);
    }

    public int getCount() {
        return comics.size();
    }

    public void add(ComicEntity comic) {
        comics.add(comic);
    }

    public void addAll(List<ComicEntity> comics) {
        this.comics.addAll(comics);
    }

    public Iterator<ComicEntity> iterator() {
        return comics.iterator();
    }


}
