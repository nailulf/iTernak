package com.example.nailul.iternak.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nailul.iternak.R;

public class SapiDetailActivity extends AppCompatActivity {

    public static final String EXTRA_POST_KEY = "post_key";

    private String mPostKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sapi_detail);


        mPostKey = getIntent().getStringExtra(EXTRA_POST_KEY);
        if (mPostKey == null) {
            throw new IllegalArgumentException("Must pass EXTRA_POST_KEY");
        }
    }

}
