package vn.coderschool.thorgroup.travelling.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import vn.coderschool.thorgroup.travelling.R;
import vn.coderschool.thorgroup.travelling.activity.DetailPostActivity;
import vn.coderschool.thorgroup.travelling.common.CommonUtils;
import vn.coderschool.thorgroup.travelling.common.RoundedTransformation;
import vn.coderschool.thorgroup.travelling.model.PostModel;

/**
 * Created by Boo on 4/13/2016.
 */
public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.FeedsHolder> {
    private static Context mContext;
    private List<PostModel> mPosts;

    public FeedsAdapter(List<PostModel> posts) {
        mPosts = posts;
    }

    @Override
    public FeedsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(R.layout.item_feeds, parent, false);
        FeedsHolder feedsHolder = new FeedsHolder(mContext,view,mPosts);
        return feedsHolder;
    }

    @Override
    public void onBindViewHolder(FeedsHolder holder, int position) {
        PostModel postModel = mPosts.get(position);

        holder.tvUserLocation.setText(getDistance(postModel.getLatitude(),postModel.getLongitude()));

        holder.tvUserName.setText(postModel.getOwner().getFullName());
        Picasso.with(mContext)
                .load(postModel.getOwner().getAvatar())
                .transform(new RoundedTransformation(20, 0))
                .resize(150, 150)
                .centerCrop()
                .tag(mContext)
                .into(holder.ivUserImage);

        if (TextUtils.isEmpty(postModel.getStatus())) {
            holder.tvUserStatus.setVisibility(View.GONE);

        } else {
            holder.tvUserStatus.setVisibility(View.VISIBLE);
            holder.tvUserStatus.setText(postModel.getStatus());
        }

        if (postModel.getReaction().equals("true")) {
            holder.ivFavoriteIcon.setImageResource(R.drawable.ic_action_like);

        } else {
            holder.ivFavoriteIcon.setImageResource(R.drawable.ic_action_unlike);
        }

        holder.tvTimeCreated.setText(DateUtils.getRelativeTimeSpanString(postModel.getCreatedAt() * 1000).toString());
        Picasso.with(mContext).load(postModel.getImages()).into(holder.ivFeedImage);
    }

    // Calculate distance between user location to post location
    public static String getDistance(double latitude,double longitude){
        LatLng location = CommonUtils.getLocation(mContext);
        String distance = null;
        if(location != null){
            double currentLongitude = location.longitude;
            double currentLatitude = location.latitude;
            distance = (int)CommonUtils.calDistance(latitude, longitude, currentLatitude, currentLongitude) + "km";
        }
        return distance;
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public static class FeedsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Context context;
        private List<PostModel> posts;
        @Bind(R.id.tvUserName)
        TextView tvUserName;

        @Bind(R.id.tvUserStatus)
        TextView tvUserStatus;

        @Bind(R.id.ivUnLikeIcon)
        ImageView ivFavoriteIcon;

        @Bind(R.id.tvTimeCreated)
        TextView tvTimeCreated;

        @Bind(R.id.tvUserLocation)
        TextView tvUserLocation;

        @Bind(R.id.ivFeedImage)
        ImageView ivFeedImage;

        @Bind(R.id.ivUserImage)
        ImageView ivUserImage;

        @Bind(R.id.ivCommentIcon)
        ImageView ivCommentIcon;

        public FeedsHolder(Context context,final View itemView,List<PostModel> posts) {
            super(itemView);
            this.context = context;
            this.posts = posts;
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(context, DetailPostActivity.class);
            i.putExtra("DataToSend",posts.get(getAdapterPosition()));
            context.startActivity(i);

        }
    }
}
