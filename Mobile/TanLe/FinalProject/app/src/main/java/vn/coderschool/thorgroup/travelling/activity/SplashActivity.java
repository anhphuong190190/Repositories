package vn.coderschool.thorgroup.travelling.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.coderschool.thorgroup.travelling.R;

/**
 * Created by minhtan512 on 4/10/2016.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(R.anim.anim_finish_view_in, R.anim.anim_finish_view_out);
                finish();
            }
        }, 1500);
    }
}
