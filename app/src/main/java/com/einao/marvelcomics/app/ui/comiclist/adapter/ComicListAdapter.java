package com.einao.marvelcomics.app.ui.comiclist.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.einao.marvelcomics.app.ui.comiclist.view.ComicCustomView;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.app.ui.viewmodel.ComicsViewModel;

public class ComicListAdapter extends RecyclerView.Adapter<ComicViewHolder> {

    private ComicsViewModel comicsViewModel;
    private Context context;

    public ComicListAdapter(Context context) {
        this.comicsViewModel = new ComicsViewModel();
        this.context = context;
    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ComicCustomView comicCustomView = new ComicCustomView(this.context);

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

}
