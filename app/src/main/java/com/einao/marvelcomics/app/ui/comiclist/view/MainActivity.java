package com.einao.marvelcomics.app.ui.comiclist.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.einao.marvelcomics.R;
import com.einao.marvelcomics.app.ui.comiclist.adapter.ComicListAdapter;
import com.einao.marvelcomics.app.ui.comiclist.presenter.MainPresenter;
import com.einao.marvelcomics.app.ui.common.BaseActivity;
import com.einao.marvelcomics.app.ui.provider.navigator.DetailNavigator;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.domain.usecases.ComicsUseCase;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.comics_list)
    RecyclerView comicRecyclerView;

    private ComicListAdapter comicListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        comicRecyclerView.setLayoutManager(layoutManager);

        comicListAdapter = new ComicListAdapter(this, imageLoader, onComicClickListener);
        comicRecyclerView.setAdapter(comicListAdapter);

        presenter.start();
    }

    @Override
    public MainPresenter initPresenter() {
        DetailNavigator detailNavigator = navigatorProvider.getDetailNavigator(this);
        ComicsUseCase comicsUseCase = useCaseProvider.getComicsUseCase();
        return new MainPresenter(this, detailNavigator, comicsUseCase);
    }

    @OnClick(R.id.button)
    public void onClickButton() {
        presenter.start();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void addComic(ComicViewModel comic) {
        comicListAdapter.add(comic);
    }

    @Override
    public void removeAllComics() {
        comicListAdapter.removeAll();
    }

    private ComicListAdapter.OnComicClickListener onComicClickListener = new ComicListAdapter.OnComicClickListener() {
        @Override
        public void onClick(ComicViewModel comicViewModel) {
            presenter.onComicClicked(comicViewModel);
        }
    };
}
