package com.einao.marvelcomics.domain.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Ana Aguilar.
 */

public class Comics {

    List<Comic> comics;

    public Comics() {
        comics = new ArrayList<Comic>();
    }

    public Comics(List<Comic> comics) {
        this.comics = comics;
    }

    public Comic getItem(int position) {
        return comics.get(position);
    }

    public int getCount() {
        return comics.size();
    }

    public void add(Comic comic) {
        comics.add(comic);
    }

    public void addAll(List<Comic> comics) {
        this.comics.addAll(comics);
    }

    public Iterator<Comic> iterator() {
        return comics.iterator();
    }

}
