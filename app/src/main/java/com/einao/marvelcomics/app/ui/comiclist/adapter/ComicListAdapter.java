package com.einao.marvelcomics.app.ui.comiclist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.einao.marvelcomics.app.ui.comiclist.view.ComicCustomView;
import com.einao.marvelcomics.app.ui.provider.image.ImageLoader;
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
        ComicCustomView comicCustomView = new ComicCustomView(this.context, imageLoader);

        return new ComicViewHolder(comicCustomView);
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
