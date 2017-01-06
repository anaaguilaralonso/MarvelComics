package com.einao.marvelcomics.app.ui.comiclist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.einao.marvelcomics.R;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.app.ui.viewmodel.ComicsViewModel;

public class ComicListAdapter extends RecyclerView.Adapter<ComicViewHolder> {

    private ComicsViewModel comicsViewModel;

    public ComicListAdapter() {
        this.comicsViewModel = new ComicsViewModel();
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
        return comicsViewModel.getCount();
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, int position) {
        ComicViewModel comicViewModel = comicsViewModel.getItem(position);
        holder.title.setText(comicViewModel.getTitle());
    }

    public void add(ComicViewModel comicViewModel){
        comicsViewModel.add(comicViewModel);
        notifyItemInserted(comicsViewModel.getCount() - 1);
    }

}
