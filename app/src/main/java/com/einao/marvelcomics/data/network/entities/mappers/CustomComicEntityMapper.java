package com.einao.marvelcomics.data.network.entities.mappers;

import com.einao.marvelcomics.data.entities.ComicEntity;
import com.einao.marvelcomics.data.network.entities.marvelentities.Result;
import com.einao.marvelcomics.domain.beans.Comic;

public class CustomComicEntityMapper {

    public ComicEntity map(Result result) {
        ComicEntity comic = new ComicEntity();
        comic.setTitle(result.getTitle());
        return comic;
    }
}
