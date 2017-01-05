package com.einao.marvelcomics.data.network.entities.mappers;

import com.einao.marvelcomics.data.network.entities.ComicEntity;
import com.einao.marvelcomics.domain.beans.Comic;

/**
 * Created by Ana Aguilar.
 */


public class ComicEntityMapper {

    public Comic map(ComicEntity comicEntity) {
        Comic comic = new Comic();
        comic.setTitle(comicEntity.getTitle());
        return comic;
    }
}
