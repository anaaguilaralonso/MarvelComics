package com.einao.marvelcomics.app.ui.comiclist.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.einao.marvelcomics.R;
import com.einao.marvelcomics.app.threads.ThreadManagerImpl;
import com.einao.marvelcomics.app.ui.comiclist.adapter.ComicListAdapter;
import com.einao.marvelcomics.app.ui.comiclist.presenter.MainPresenter;
import com.einao.marvelcomics.app.ui.common.BaseActivity;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.app.ui.viewmodel.ComicsViewModel;
import com.einao.marvelcomics.domain.usecases.ComicsUseCase;

import butterknife.BindView;


public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.comics_list)
    RecyclerView comicRecyclerView;

    private ComicsViewModel comicList;
    private RecyclerView.Adapter comicListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        comicRecyclerView.setLayoutManager(layoutManager);

        comicList = new ComicsViewModel();
        comicListAdapter = new ComicListAdapter(comicList);
        comicRecyclerView.setAdapter(comicListAdapter);

        presenter.start();
    }

    @Override
    public MainPresenter initPresenter() {
        return new MainPresenter(this, new ComicsUseCase(ThreadManagerImpl.getInstance()));
    }

    @Override
    public void injectDependencies() {

    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void addComic(final ComicViewModel comic) {
        comicList.add(comic);
        comicListAdapter.notifyDataSetChanged();
    }
}
