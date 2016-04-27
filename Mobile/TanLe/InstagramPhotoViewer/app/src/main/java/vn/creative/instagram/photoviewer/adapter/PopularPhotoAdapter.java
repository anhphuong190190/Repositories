package vn.creative.instagram.photoviewer.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.creative.instagram.photoviewer.R;
import vn.creative.instagram.photoviewer.common.ImageUtils;
import vn.creative.instagram.photoviewer.common.TimeUtils;
import vn.creative.instagram.photoviewer.model.PopularPhotoModel;

/**
 * Created by tanlnm on 3/14/2016.
 */
public class PopularPhotoAdapter extends BaseAdapter {
    private Context mContext;

    private List<PopularPhotoModel> popularPhotos;

    public PopularPhotoAdapter(Context context, List<PopularPhotoModel> popularPhotoList) {
        mContext = context;
        popularPhotos = popularPhotoList;
    }

    @Override
    public int getCount() {
        return popularPhotos == null || popularPhotos.size() == 0 ? 0 : popularPhotos.size();
    }

    @Override
    public Object getItem(int position) {
        return popularPhotos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Holder holder;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.popular_photo_item, parent, false);

            holder = new Holder();
            holder.avatar = (ImageView) view.findViewById(R.id.iv_avatar);
            holder.userName = (TextView) view.findViewById(R.id.tv_username);
            holder.postTime = (TextView) view.findViewById(R.id.tv_post_time);
            holder.caption = (TextView) view.findViewById(R.id.tv_caption);
            holder.photo = (ImageView) view.findViewById(R.id.iv_photo);
            holder.likeCount = (TextView) view.findViewById(R.id.tv_like_count);
            holder.commentCount = (TextView) view.findViewById(R.id.tv_comment_count);
            holder.firstComment = (TextView) view.findViewById(R.id.tv_first_comment);
            holder.secondComment = (TextView) view.findViewById(R.id.tv_second_comment);
            view.setTag(holder);

        } else {
            holder = (Holder) view.getTag();
        }

        PopularPhotoModel popularPhoto = popularPhotos.get(position);
        if (popularPhoto != null) {
            ImageUtils.setRoundedImage(mContext, popularPhoto.getUser().getProfilePicture(), holder.avatar);

            String name = "<font color=\'#3f729b\'><b>" + popularPhoto.getUser().getFullName() + "</b></font>";
            holder.userName.setText(Html.fromHtml(name), TextView.BufferType.SPANNABLE);
            holder.postTime.setText(TimeUtils.calculateTime(popularPhoto.getCreatedTime()));

            if(popularPhoto.getCaption() != null) {
                holder.caption.setVisibility(View.VISIBLE);
                holder.caption.setText(popularPhoto.getCaption().getText());
            }
            ImageUtils.setImage(mContext, popularPhoto.getImages().getStandardRes().getUrl(), holder.photo);

            String likeCount = popularPhoto.getLikes().getCount() + " likes";
            holder.likeCount.setText(likeCount);

            String commentCount;
            if (popularPhoto.getComments().getCount() == 0) {
                commentCount = "No comment";

            } else {
                commentCount = "View all " + popularPhoto.getComments().getCount() + " comments";
            }
            holder.commentCount.setText(commentCount);

            if(popularPhoto.getComments() != null && popularPhoto.getComments().getCaptions() != null) {
                String comment = "<font color=\'#3f729b\'><b>" + popularPhoto.getComments().getCaptions()[0].getFrom().getFullName() + "</b></font>";
                comment += " " + popularPhoto.getComments().getCaptions()[0].getText();
                holder.firstComment.setText(Html.fromHtml(comment), TextView.BufferType.SPANNABLE);
                holder.firstComment.setVisibility(View.VISIBLE);

                if(popularPhoto.getComments().getCaptions().length >1) {
                    comment = "<font color=\'#3f729b\'><b>" + popularPhoto.getComments().getCaptions()[1].getFrom().getFullName() + "</b></font>";
                    comment += " " + popularPhoto.getComments().getCaptions()[1].getText();
                    holder.secondComment.setText(Html.fromHtml(comment), TextView.BufferType.SPANNABLE);
                    holder.secondComment.setVisibility(View.VISIBLE);
                }
            }
        }

        return view;
    }

    private static class Holder {
        ImageView avatar, photo;
        TextView userName, postTime, likeCount, commentCount, caption, firstComment, secondComment;
    }
}
