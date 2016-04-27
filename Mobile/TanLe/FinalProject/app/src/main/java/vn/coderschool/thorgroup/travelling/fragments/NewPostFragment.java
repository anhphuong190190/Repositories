package vn.coderschool.thorgroup.travelling.fragments;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import vn.coderschool.thorgroup.travelling.R;

/**
 * Created by ILenTT on 4/18/2016.
 */
public class NewPostFragment extends DialogFragment {

    public final static String REPLY_TO_EXTRA_TAG = "REPLY_TO_USER_NAME";
    public final static int MAXIMUM_CHAR_NUMBER = 140;

    private Button btnCancelNewPost;
    private Button btnPostNewPost;
    private TextView tvNewPostCharsNumber;
    private TextView tvNewPostUserScreenName;
    private ImageView ivNewPostUserProfilePic;
    private EditText etNewPostText;

    private String replyToUserName;

    public NewPostFragment() {
    }

    public static NewPostFragment newInstance(String replyToUserName) {
        NewPostFragment newTweetFragment = new NewPostFragment();
        Bundle args = new Bundle();
        args.putString(REPLY_TO_EXTRA_TAG, replyToUserName);
        newTweetFragment.setArguments(args);
        return newTweetFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_new_post, container);

        btnCancelNewPost = (Button) view.findViewById(R.id.btnCancelNewPost);
        btnPostNewPost = (Button) view.findViewById(R.id.btnPostNewPost);
        tvNewPostCharsNumber = (TextView) view.findViewById(R.id.tvNewPostCharsNumber);
        ivNewPostUserProfilePic = (ImageView) view.findViewById(R.id.ivNewPostUserProfilePic);
        tvNewPostUserScreenName = (TextView) view.findViewById(R.id.tvNewPostUserScreenName);
        etNewPostText = (EditText) view.findViewById(R.id.etNewPostText);
        setupFields();

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        return view;
    }

    private void setNewPostCharsNumber() {
        tvNewPostCharsNumber.setText(String.valueOf(getNewPostCharsLeftCount()));
    }

    private int getNewPostCharsLeftCount() {
        return MAXIMUM_CHAR_NUMBER - getNewPostCharsCount();
    }

    private int getNewPostCharsCount() {
        return etNewPostText.getText().toString().length();
    }

    private void activateTweetNewTweetButton() {
        if (getNewPostCharsCount() > 0) {
            if (btnPostNewPost != null) {
                btnPostNewPost.setEnabled(true);
            }
        } else {
            if (btnPostNewPost != null) {
                btnPostNewPost.setEnabled(false);
            }
        }
    }

    private void setupFields() {
        /*
        SharedLoggedUserDetails loggedUserDetails = ((SimpleTwitterApp) getActivity().getApplicationContext()).getSharedLoggedUserDetails();
        tvNewPostUserScreenName.setText("@" + loggedUserDetails.getUserScreenName());
        if (!loggedUserDetails.getUserProfilePicUrl().isEmpty()) {
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(loggedUserDetails.getUserProfilePicUrl(), ivNewTweetUserProfilePic);
        }
        */
        tvNewPostUserScreenName.setText("User Login");

        if (replyToUserName != null && !replyToUserName.isEmpty()) {
            etNewPostText.setText(replyToUserName + " ");
            etNewPostText.setSelection(getNewPostCharsCount());
        }
        etNewPostText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setNewPostCharsNumber();
                activateTweetNewTweetButton();
            }
        });
        setNewPostCharsNumber();
        activateTweetNewTweetButton();
        etNewPostText.requestFocus();

        btnCancelNewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelNewTweet(v);
            }
        });
        btnPostNewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postNewPost(v);
            }
        });
    }

    public void cancelNewTweet(View view) {
        closeInputFromWindow();
        getDialog().dismiss();
    }

    public void postNewPost(View view) {
        //twitterRestClient.postNewTweet(etNewPostText.getText().toString());
        /*
         * Handle action add new post into timeline
         */
        Toast.makeText(view.getContext(), "Handle add a new post ", Toast.LENGTH_SHORT).show();
        getDialog().dismiss();
    }

    private void closeInputFromWindow() {
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }
}
