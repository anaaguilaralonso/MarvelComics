package com.einao.marvelcomics.app.ui.comiclist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.einao.marvelcomics.R;

import java.util.List;

/**
 * Created by akiana on 4/1/17.
 */

public class ComicListAdapter extends RecyclerView.Adapter<ComicViewHolder> {

    List<String> comicList;

    public ComicListAdapter(List<String> comicList){
        this.comicList = comicList;
    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.comic_list_item, parent, false);

        ComicViewHolder comicViewHolder = new ComicViewHolder(view);
        return comicViewHolder;
    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, int position) {
        holder.title.setText(comicList.get(position));
    }

}
