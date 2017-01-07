package com.einao.marvelcomics.data.entities.mappers;

import com.einao.marvelcomics.data.entities.ComicEntity;
import com.einao.marvelcomics.data.entities.ComicsEntity;
import com.einao.marvelcomics.domain.beans.Comic;
import com.einao.marvelcomics.domain.beans.Comics;

import java.util.Iterator;

public class ComicsEntityMapper {

    public Comics map(ComicsEntity comicsEntity) {
        Comics comics = new Comics();
        ComicEntityMapper comicMapper = new ComicEntityMapper();

        Iterator<ComicEntity> iterator = comicsEntity.iterator();
        while (iterator.hasNext()) {
            Comic comic = comicMapper.map(iterator.next());
            comics.add(comic);
        }
        return comics;
    }

}
