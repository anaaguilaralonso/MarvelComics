package com.einao.marvelcomics.app.ui.comiclist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.einao.marvelcomics.app.ui.comiclist.view.ComicView;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.app.ui.viewmodel.ComicsViewModel;
import com.einao.marvelcomics.domain.providers.ImageLoader;

public class ComicListAdapter extends RecyclerView.Adapter<ComicViewHolder> {

    private ComicsViewModel comicsViewModel;
    private Context context;
    private ImageLoader imageLoader;
    private OnComicClickListener onComicClickListener;

    public ComicListAdapter(Context context, ImageLoader imageLoader, OnComicClickListener onComicClickListener) {
        this.comicsViewModel = new ComicsViewModel();
        this.context = context;
        this.imageLoader = imageLoader;
        this.onComicClickListener = onComicClickListener;
    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ComicView comicView = new ComicView(context);
        comicView.setImageLoader(imageLoader);
        return new ComicViewHolder(comicView);
    }

    @Override
    public int getItemCount() {
        return comicsViewModel.getCount();
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, int position) {
        final ComicViewModel comicViewModel = comicsViewModel.getItem(position);
        holder.customView.setComicRow(comicViewModel);
        holder.customView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onComicClickListener.onClick(comicViewModel);
            }
        });
    }

    public void add(ComicViewModel comicViewModel) {
        comicsViewModel.add(comicViewModel);
        notifyItemInserted(comicsViewModel.getCount() - 1);
    }

    public void removeAll() {
        comicsViewModel.deleteAll();
        notifyDataSetChanged();
    }

    public interface OnComicClickListener {
        void onClick(ComicViewModel comicViewModel);
    }
}
