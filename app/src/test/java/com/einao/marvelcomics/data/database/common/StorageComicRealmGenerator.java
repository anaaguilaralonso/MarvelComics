package com.einao.marvelcomics.data.database.common;

import com.einao.marvelcomics.data.database.realm.entities.ComicRealmObject;

public class StorageComicRealmGenerator {

    public ComicRealmObject getSimpleComic() {
        ComicRealmObject comic = new ComicRealmObject();
        comic.setTitle("Comic Title " + Math.random());
        comic.setDescription("Description of the comic: "+comic.getTitle());
        comic.setImageUrl("http://www.ab.com");
        return comic;
    }

    /*public RealmResults<ComicRealmObject> getSimpleComicList(int numberItems) {
        RealmResults<ComicRealmObject> comics = new ArrayList<ComicRealmObject>();

        for (int i = 0; i < numberItems; i++) {
            ComicRealmObject comic = getSimpleComic();
            comics.add(comic);
        }
        return comics;
    }*/
}
