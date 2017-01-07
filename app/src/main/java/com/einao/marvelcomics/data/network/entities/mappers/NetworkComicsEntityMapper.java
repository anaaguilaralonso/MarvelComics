package com.einao.marvelcomics.data.network.entities.mappers;

import com.einao.marvelcomics.data.entities.ComicEntity;
import com.einao.marvelcomics.data.entities.ComicsEntity;
import com.einao.marvelcomics.data.network.entities.marvelentities.Result;

import java.util.Iterator;
import java.util.List;

public class NetworkComicsEntityMapper {

    public ComicsEntity map(List<Result> results) {
        ComicsEntity comicsEntity = new ComicsEntity();
        NetworkComicEntityMapper comicMapper = new NetworkComicEntityMapper();

        Iterator<Result> iterator = results.iterator();
        while (iterator.hasNext()) {
            ComicEntity comic = comicMapper.map(iterator.next());
            comicsEntity.add(comic);
        }

        return comicsEntity;

    }
}
