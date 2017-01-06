package com.einao.marvelcomics.app.ui.viewmodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**

 */

public class ComicsViewModel {

    List<ComicViewModel> comics;

    public ComicsViewModel() {
        comics = new ArrayList<ComicViewModel>();
    }

    public ComicsViewModel(List<ComicViewModel> comics) {
        this.comics = comics;
    }

    public ComicViewModel getItem(int position) {
        return comics.get(position);
    }

    public int getCount() {
        return comics.size();
    }

    public void add(ComicViewModel comic) {
        comics.add(comic);
    }

    public void addAll(List<ComicViewModel> comics) {
        this.comics.addAll(comics);
    }

    public Iterator<ComicViewModel> iterator() {
        return comics.iterator();
    }

}
