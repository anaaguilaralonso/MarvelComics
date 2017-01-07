package com.einao.marvelcomics.app.ui.comiclist.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.einao.marvelcomics.R;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicCustomView extends RelativeLayout {

    @BindView(R.id.image)
    ImageView image;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.description)
    TextView description;


    public ComicCustomView(Context context) {
        super(context);
        setup();
    }

    private void setup() {
        LayoutInflater.from(getContext()).inflate(R.layout.comic_list_item, this);

        ButterKnife.bind(this);
    }

    public void setImage(String imageUrl) {

    }

    public void setComicRow(ComicViewModel comicViewModel) {
        setImage(comicViewModel.imageUrl);
        this.title.setText(comicViewModel.title);
        this.description.setText(comicViewModel.description);
    }

}
