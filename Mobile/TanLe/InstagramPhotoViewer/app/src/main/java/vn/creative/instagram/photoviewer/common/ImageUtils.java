package vn.creative.instagram.photoviewer.common;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import vn.creative.instagram.photoviewer.R;

/**
 * Created by tanlnm on 3/14/2016.
 */
public class ImageUtils {
    public static void setRoundedImage(Context context, String url, ImageView imageView) {
        Picasso.with(context)
                .load(url)
                .placeholder(R.mipmap.avatar_placeholder)
                .error(R.mipmap.avatar_placeholder)
                .transform(new RoundedTransformation(100, 0))
                .resize(50, 50)
                .centerCrop()
                .tag(context)
                .into(imageView);
    }

    public static void setImage(Context context, String url, ImageView imageView) {
        Picasso.with(context)
                .load(url)
                .placeholder(R.mipmap.photo_placeholder)
                .error(R.mipmap.photo_placeholder)
                .tag(context)
                .fit()
                .into(imageView);
    }
}
