package com.einao.marvelcomics.data.entities.mappers;

import com.einao.marvelcomics.data.entities.ComicEntity;
import com.einao.marvelcomics.domain.beans.Comic;

public class ComicEntityMapper {

    public Comic map(ComicEntity comicEntity) {
        Comic comic = new Comic();
        comic.setId(comicEntity.getId());
        comic.setTitle(comicEntity.getTitle());
        comic.setDescription(comicEntity.getDescription());
        comic.setImageUrl(comicEntity.getImageUrl());
        return comic;
    }
}