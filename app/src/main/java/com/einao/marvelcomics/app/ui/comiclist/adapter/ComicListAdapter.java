package com.einao.marvelcomics.app.ui.comiclist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.einao.marvelcomics.R;
import com.einao.marvelcomics.app.ui.comiclist.view.ComicView;
import com.einao.marvelcomics.domain.providers.ImageLoader;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.app.ui.viewmodel.ComicsViewModel;

public class ComicListAdapter extends RecyclerView.Adapter<ComicViewHolder> {

    private ComicsViewModel comicsViewModel;
    private Context context;
    private ImageLoader imageLoader;

    public ComicListAdapter(Context context, ImageLoader imageLoader) {
        this.comicsViewModel = new ComicsViewModel();
        this.context = context;
        this.imageLoader = imageLoader;
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
        holder.customView.setComicRow(comicsViewModel.getItem(position));
    }

    public void add(ComicViewModel comicViewModel) {
        comicsViewModel.add(comicViewModel);
        notifyItemInserted(comicsViewModel.getCount() - 1);
    }

    public void removeAll() {
        comicsViewModel.deleteAll();
        notifyDataSetChanged();
    }
}
