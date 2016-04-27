package vn.coderschool.thorgroup.travelling.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import vn.coderschool.thorgroup.travelling.R;
import vn.coderschool.thorgroup.travelling.adapter.FeedsAdapter;
import vn.coderschool.thorgroup.travelling.common.RoundedTransformation;
import vn.coderschool.thorgroup.travelling.model.PostModel;

/**
 * Created by Boo on 4/21/2016.
 */
public class DetailPostActivity extends AppCompatActivity {
    @Bind(R.id.ivDetailPostUserImage)
    ImageView ivDetailUserImage;
    @Bind(R.id.tvDetailPostUserName)
    TextView tvDetailUserName;
    @Bind(R.id.tvDetailPostLocation) TextView tvDetailLocation;
    @Bind(R.id.tvDetailPostStatus) TextView tvDetailStatus;
    @Bind(R.id.ivDetailPostFeedImage) ImageView ivDetailFeedImage;
    @Bind(R.id.ivDetailPostLike) ImageView ivDetailLike;
    @Bind(R.id.ivDetailPostPin) ImageView ivDetailPin;
    @Bind(R.id.tvDetailPostLikeCount) TextView tvDetailLikeCount;
    @Bind(R.id.toolbar1) Toolbar tb1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailpost);
        ButterKnife.bind(this);
        tb1.setNavigationIcon(R.drawable.ic_action_name2);
        setSupportActionBar(tb1);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        PostModel postModel = (PostModel) getIntent().getParcelableExtra("DataToSend");
        addData(postModel);
    }


    private void addData(PostModel postModel) {
        Log.d("TEST",postModel.getOwner().getAvatar());
        Picasso.with(getApplicationContext()).load(postModel.getOwner().getAvatar()).transform(new RoundedTransformation(25,0)).into(ivDetailUserImage);
        tvDetailUserName.setText(postModel.getOwner().getFullName());
        tvDetailLocation.setText(FeedsAdapter.getDistance(postModel.getLatitude(), postModel.getLongitude()));
        if(TextUtils.isEmpty(postModel.getStatus())){
            tvDetailStatus.setVisibility(View.GONE);
        }
        else{
            tvDetailStatus.setVisibility(View.VISIBLE);
            tvDetailStatus.setText(postModel.getStatus());
        }
        Picasso.with(getApplicationContext()).load(postModel.getImages()).into(ivDetailFeedImage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
                break;
        }
        return false;
    }
}
