package com.einao.marvelcomics.data.entities.mappers;

import com.einao.marvelcomics.data.entities.ComicEntity;
import com.einao.marvelcomics.domain.beans.Comic;

public class ComicEntityMapper {

    public Comic map(ComicEntity comicEntity) {
        Comic.ComicBuilder comicBuilder = new Comic.ComicBuilder();
        comicBuilder.setId(comicEntity.getId());
        comicBuilder.setTitle(comicEntity.getTitle());
        comicBuilder.setDescription(comicEntity.getDescription());
        comicBuilder.setImageUrl(comicEntity.getImageUrl());
        return comicBuilder.build();
    }
}