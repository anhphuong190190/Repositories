package vn.coderschool.thorgroup.travelling.adapter;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import vn.coderschool.thorgroup.travelling.R;
import vn.coderschool.thorgroup.travelling.model.PhotoModel;
import vn.coderschool.thorgroup.travelling.model.PostModel;

/**
 * Created by ADMIN on 4/19/2016.
 */
public class PhotosAdapter extends ArrayAdapter<PhotoModel> {

    private List<PostModel> mPosts;

    public PhotosAdapter(Context context, List<PhotoModel> photos, List<PostModel> posts) {
        super(context, 0, photos);
        mPosts = posts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater li = (LayoutInflater) getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            view = li.inflate(R.layout.item_feeds, null);
        }

        PostModel postModel = mPosts.get(position);
        PhotoModel photo = getItem(position);

        TextView tvUserName = (TextView) view.findViewById(R.id.tvUserName);
        tvUserName.setText(postModel.getOwner().getUserName());

        TextView tvTimeCreated = (TextView) view.findViewById(R.id.tvTimeCreated);
        tvTimeCreated.setText(DateUtils.getRelativeTimeSpanString(1000 * photo.getTimestamp()));

        ImageView ivUserImage = (ImageView) view.findViewById(R.id.ivUserImage);
        ivUserImage.setImageResource(android.R.color.transparent);
        ImageLoader.getInstance().displayImage(postModel.getOwner().getAvatar(), ivUserImage);

        ImageView ivFeedImage = (ImageView) view.findViewById(R.id.ivFeedImage);
        ivFeedImage.setImageResource(android.R.color.transparent);

        // Set the dimensions of the ImageView, so it will be resize immediately
        // before the photo
        // finishes downloading.
        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) ivFeedImage
                .getLayoutParams();
        lp.height = 700; // photo.getPhotoHeight() * 2;
        lp.width = 700; // photo.getPhotoWidth() * 2;
        ivFeedImage.setLayoutParams(lp);

        ImageLoader.getInstance().displayImage(photo.getPhotoUrl(), ivFeedImage);

        return view;
    }
}
