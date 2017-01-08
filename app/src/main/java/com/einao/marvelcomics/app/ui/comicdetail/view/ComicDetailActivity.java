package com.einao.marvelcomics.app.ui.comicdetail.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.einao.marvelcomics.R;
import com.einao.marvelcomics.app.ui.comicdetail.presenter.ComicDetailPresenter;
import com.einao.marvelcomics.app.ui.common.BaseActivity;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;

import butterknife.BindView;

public class ComicDetailActivity extends BaseActivity<ComicDetailPresenter> implements ComicDetailView {

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.description)
    TextView description;

    @BindView(R.id.image)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        ComicViewModel comic = intent.getParcelableExtra("comic");
        presenter.setComic(comic);

        presenter.start();
    }

    @Override
    public int getLayout() {
        return R.layout.activity_comic_detail;
    }

    @Override
    public ComicDetailPresenter initPresenter() {
        return new ComicDetailPresenter(this);
    }

    @Override
    public void setTitle(String title){
        this.title.setText(title);
    }

    @Override
    public void setDescription(String description){
        this.description.setText(description);
    }

    @Override
    public void setImage(String imageUrl){
        imageLoader.loadImage(image, imageUrl);
    }


}
