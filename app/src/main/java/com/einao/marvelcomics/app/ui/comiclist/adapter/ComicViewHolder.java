package com.einao.marvelcomics.app.ui.comiclist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.einao.marvelcomics.R;
import com.einao.marvelcomics.app.ui.comiclist.view.ComicCustomView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**

 */

public class ComicViewHolder extends RecyclerView.ViewHolder{

    ComicCustomView customView;

    public ComicViewHolder(ComicCustomView customView) {
        super(customView);
        this.customView = customView;

    }
}
