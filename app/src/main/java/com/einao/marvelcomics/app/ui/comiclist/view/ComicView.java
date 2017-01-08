package com.einao.marvelcomics.app.ui.comiclist.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.einao.marvelcomics.R;
import com.einao.marvelcomics.app.ui.viewmodel.ComicViewModel;
import com.einao.marvelcomics.domain.providers.ImageLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicView extends RelativeLayout {

    @BindView(R.id.image)
    ImageView image;

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.description)
    TextView description;

    ImageLoader<ImageView> imageLoader;

    public ComicView(Context context) {
        super(context);
        setup();
    }

    public ComicView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setup();
    }

    public ComicView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ComicView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setup();
    }

    public void setImageLoader(ImageLoader<ImageView> imageLoader) {
        this.imageLoader = imageLoader;
    }

    private void setup() {
        LayoutInflater.from(getContext()).inflate(R.layout.comic_view, this);
        ButterKnife.bind(this);
    }

    public void setComicRow(ComicViewModel comicViewModel) {
        this.title.setText(comicViewModel.title);
        this.description.setText(comicViewModel.description);
        if (imageLoader == null) return;
        imageLoader.loadImage(image, comicViewModel.imageUrl);
    }

}
