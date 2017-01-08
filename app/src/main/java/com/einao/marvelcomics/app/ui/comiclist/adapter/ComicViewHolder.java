package com.einao.marvelcomics.app.ui.comiclist.adapter;

import android.support.v7.widget.RecyclerView;

import com.einao.marvelcomics.app.ui.widget.ComicView;

/**

 */

public class ComicViewHolder extends RecyclerView.ViewHolder{

    ComicView customView;

    public ComicViewHolder(ComicView customView) {
        super(customView);
        this.customView = customView;

    }
}
