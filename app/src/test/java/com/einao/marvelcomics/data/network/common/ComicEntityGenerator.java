package com.einao.marvelcomics.data.network.common;

import com.einao.marvelcomics.data.network.entities.NetworkError;
import com.einao.marvelcomics.data.network.entities.NetworkResponse;
import com.einao.marvelcomics.data.network.entities.marvelentities.ComicEntity;

import java.util.ArrayList;
import java.util.List;

/**

 */

public class ComicEntityGenerator {

    public NetworkResponse getFailureNetworkComicsResponse(){
        NetworkResponse<List<ComicEntity>> networkResponse = new NetworkResponse<>();
        NetworkError networkError = new NetworkError();
        networkError.setMessage("Error");
        networkResponse.setError(networkError);
        return networkResponse;
    }

    public NetworkResponse getNetworkComicsResponse(int numberItems){
        NetworkResponse<List<ComicEntity>> networkResponse = new NetworkResponse<>();
        networkResponse.setResponse(getSimpleComicList(numberItems));
        return networkResponse;
    }

    public ComicEntity getSimpleComic() {
        ComicEntity comic = new ComicEntity();
        comic.setTitle("Comic Title " + Math.random());
        return comic;
    }

    private List<ComicEntity> getSimpleComicList(int numberItems) {
        List<ComicEntity> comics = new ArrayList<ComicEntity>();
        for (int i = 0; i < numberItems; i++) {
            ComicEntity comic = getSimpleComic();
            comics.add(comic);
        }
        return comics;
    }
}
