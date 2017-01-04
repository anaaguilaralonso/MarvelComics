package com.einao.marvelcomics.app.ui.comiclist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.einao.marvelcomics.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by akiana on 4/1/17.
 */

public class ComicViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.title)
    public TextView title;

    public ComicViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);

    }
}
