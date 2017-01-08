package com.einao.marvelcomics.app.ui.provider.image;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.einao.marvelcomics.R;
import com.einao.marvelcomics.domain.providers.ImageLoader;
import com.squareup.picasso.Picasso;

public class PicassoImageLoader implements ImageLoader<ImageView> {

    private final Context context;

    public PicassoImageLoader(Context context) {
        this.context = context;
    }

    @Override
    public void loadImage(final ImageView imageView, String url) {

        if (url != null && !url.isEmpty() && Uri.parse(url) != null) {
            Picasso.with(context)
                    .load(url)
                    .placeholder(R.mipmap.ic_placeholder)
                    .error(R.mipmap.ic_placeholder)
                    .into(imageView);
        } else {
            imageView.setImageResource(R.mipmap.ic_placeholder);
        }
    }


}
