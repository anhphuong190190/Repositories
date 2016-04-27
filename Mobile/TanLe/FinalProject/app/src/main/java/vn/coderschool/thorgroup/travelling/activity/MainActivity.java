package vn.coderschool.thorgroup.travelling.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import vn.coderschool.thorgroup.travelling.R;
import vn.coderschool.thorgroup.travelling.fragments.NewPostFragment;
import vn.coderschool.thorgroup.travelling.view.timeline.TimelineFrg;

/**
 * Created by minhtan512 on 4/11/2016.
 */
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private FloatingActionButton mFAB;
    private FloatingActionMenu mFABMenu;

    //tag associated with the FAB menu button that take picture
    private static final String TAG_CAMERA = "Camera";
    //tag associated with the FAB menu button that browser images
    private static final String TAG_IMAGE = "Image";
    //tag associated with the FAB menu button that compose action
    private static final String TAG_COMPOSE = "Compose";

    private static final int PICK_PHOTO_CODE = 2;
    public final static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1034;
    public String photoFileName = "photo.jpg";

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setupFAB();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, TimelineFrg.newInstance(), "TimelineFrg")
                .commit();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();

        } else if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_profile:
                break;

            case R.id.nav_sign_out:
                break;

            case R.id.nav_sign_in:
                break;

            default:
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setupFAB() {
        //define the icon for the main floating action button
        ImageView iconFAB = new ImageView(this);
        iconFAB.setImageResource(R.drawable.ic_action_add);

        //set the appropriate background for the main floating action button along with its icon
        mFAB = new FloatingActionButton.Builder(this)
                .setContentView(iconFAB)
                .setBackgroundDrawable(R.drawable.selector_button_red)
                .build();

        //define the icons for the sub action buttons
        ImageView iconTakePicture = new ImageView(this);
        iconTakePicture.setImageResource(R.drawable.ic_action_camera);
        ImageView iconBrowserImage = new ImageView(this);
        iconBrowserImage.setImageResource(R.drawable.ic_action_image);
        ImageView iconCompose = new ImageView(this);
        iconCompose.setImageResource(R.drawable.ic_action_compose);

        //set the background for all the sub buttons
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        itemBuilder.setBackgroundDrawable(getResources().getDrawable(R.drawable.selector_sub_button_gray));


        //build the sub buttons
        SubActionButton buttonTakePicture = itemBuilder.setContentView(iconTakePicture).build();
        SubActionButton buttonBrowserImage = itemBuilder.setContentView(iconBrowserImage).build();
        SubActionButton buttonCompose = itemBuilder.setContentView(iconCompose).build();

        //to determine which button was clicked, set Tags on each button
        buttonTakePicture.setTag(TAG_CAMERA);
        buttonBrowserImage.setTag(TAG_IMAGE);
        buttonCompose.setTag(TAG_COMPOSE);

        buttonTakePicture.setOnClickListener(this);
        buttonBrowserImage.setOnClickListener(this);
        buttonCompose.setOnClickListener(this);

        //add the sub buttons to the main floating action button
        mFABMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(buttonTakePicture)
                .addSubActionView(buttonBrowserImage)
                .addSubActionView(buttonCompose)
                .attachTo(mFAB)
                .build();
    }

    @Override
    public void onClick(View v) {

        if (v.getTag().equals(TAG_CAMERA)) {
            // create Intent to take a picture and return control to the calling application
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, getPhotoFileUri(photoFileName)); // set the image file name
            // Start the image capture intent to take photo
            startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

            //Toast.makeText(v.getContext(), "Handle take picture from camera ", Toast.LENGTH_SHORT).show();
        }

        if (v.getTag().equals(TAG_IMAGE)) {
            //call the sort by date method on any Fragment that implements onClick
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            // Bring up gallery to select a photo
            startActivityForResult(intent, PICK_PHOTO_CODE);

            //Toast.makeText(v.getContext(), "Handle browser existing images ", Toast.LENGTH_SHORT).show();
        }
        if (v.getTag().equals(TAG_COMPOSE)) {
            //call the show new post dialog method on any Fragment that implements onClick
            //Toast.makeText(v.getContext(), "Make compose ", Toast.LENGTH_SHORT).show();
            showNewPostDialog();
        }
    }

    public void showNewPostDialog() {
        DialogFragment dialogFragment = NewPostFragment.newInstance(null);
        dialogFragment.show(getSupportFragmentManager(), "onNewPostDialog");
    }

    // Returns the Uri for a photo stored on disk given the fileName
    public Uri getPhotoFileUri(String fileName) {
        // Only continue if the SD Card is mounted
        if (isExternalStorageAvailable()) {

            // Get safe storage directory for photos
            File mediaStorageDir = new File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "debug");

            // Create the storage directory if it does not exist
            if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
                Log.d("debug", "failed to create directory");
            }

            // Return the file target for the photo based on filename
            return Uri.fromFile(new File(mediaStorageDir.getPath() + File.separator + fileName));
        }
        return null;
    }

    private boolean isExternalStorageAvailable() {
        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

}
