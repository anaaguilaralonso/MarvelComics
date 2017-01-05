package com.einao.marvelcomics.data.network.entities.mappers;

import com.einao.marvelcomics.data.network.entities.ComicEntity;
import com.einao.marvelcomics.data.network.entities.NullComicEntitiesObject;
import com.einao.marvelcomics.domain.beans.Comic;
import com.einao.marvelcomics.domain.beans.Comics;
import com.einao.marvelcomics.domain.beans.NullComicsObject;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Ana Aguilar.
 */

public class ComicsEntityMapper {

    public Comics map(List<ComicEntity> comicsEntity) {

        if (comicsEntity instanceof NullComicEntitiesObject){
            NullComicsObject nullComicsObject = new NullComicsObject();
            nullComicsObject.setError(((NullComicEntitiesObject) comicsEntity).getError());
            return nullComicsObject;
        }

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
