package com.einao.marvelcomics.data.network.common;

import com.einao.marvelcomics.data.network.entities.NetworkResponse;
import com.einao.marvelcomics.data.network.entities.marvelentities.Result;

import java.util.ArrayList;
import java.util.List;

public class NetworkComicResultGenerator {

    public NetworkResponse getNetworkComicsResponse(int numberItems) {
        NetworkResponse<List<Result>> networkResponse = new NetworkResponse<>();
        networkResponse.setResponse(getSimpleComicList(numberItems));
        return networkResponse;
    }

    public Result getSimpleComic() {
        Result comic = new Result();
        comic.setTitle("Comic Title " + Math.random());
        return comic;
    }

    private List<Result> getSimpleComicList(int numberItems) {
        List<Result> comics = new ArrayList<Result>();
        for (int i = 0; i < numberItems; i++) {
            Result comic = getSimpleComic();
            comics.add(comic);
        }
        return comics;
    }
}
