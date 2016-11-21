package com.example.nailul.iternak.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nailul.iternak.Models.Sapi;
import com.example.nailul.iternak.Models.User;
import com.example.nailul.iternak.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Nailul on 11/19/2016.
 */

public class SapiBaru extends AppCompatActivity {

    private static final String TAG = "SapiAda Baru";
    private Toolbar mSapiBaruToolbar;
    private DatabaseReference mDatabase;

    private EditText mIDSapiBaru, mBB, mTB, mLB, mJenisSapi, mPTSapi, mPJSapi, mUsiaSapi;
    private Button mTambahSapiBtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sapi_baru);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mSapiBaruToolbar =(Toolbar)findViewById(R.id.toolbarSapiBaru);
        setSupportActionBar(mSapiBaruToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mIDSapiBaru=(EditText)findViewById(R.id.ID_Sapi);
        mBB=(EditText)findViewById(R.id.addBB);
        mTB=(EditText)findViewById(R.id.addTB);
        mLB=(EditText)findViewById(R.id.addLB);
        mPTSapi=(EditText)findViewById(R.id.addLB);
        mTambahSapiBtn=(Button)findViewById(R.id.submitSapiBtn);

        mTambahSapiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SubmitPost();
            }
        });
    }

    private void SubmitPost() {

        final String IDSapi = mIDSapiBaru.getText().toString();
        final String BB = mBB.getText().toString();
        final String TB = mTB.getText().toString();
        final String LB = mLB.getText().toString();

        //ID SapiAda haru diisi
        if(TextUtils.isEmpty(IDSapi)){
            mIDSapiBaru.setError("REQUIRED!");
            return;
        }

        // Disable button so there are no multi-posts
        setEditingEnabled(false);
        Toast.makeText(this, "Menambahkan...", Toast.LENGTH_SHORT).show();
        
        // [START single_value_read]
        final String userId = getUid();
        mDatabase.child("users").child(userId).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        User user = dataSnapshot.getValue(User.class);

                        // [START_EXCLUDE]
                        if (user == null) {
                            // User is null, error out
                            Log.e(TAG, "User " + userId + " is unexpectedly null");
                            Toast.makeText(SapiBaru.this,
                                    "Error: could not fetch user.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // Write new post
                            writeNewPost(userId, user.username, IDSapi, BB, TB, LB, UsiaSapi, JenisSapi,
                                    PTSapi, PJSapi);
                        }

                        // Finish this Activity, back to the stream
                        setEditingEnabled(true);
                        finish();
                        // [END_EXCLUDE]
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                        // [START_EXCLUDE]
                        setEditingEnabled(true);
                        // [END_EXCLUDE]
                    }
                });
        // [END single_value_read]
    }

    private void setEditingEnabled(boolean b) {
    }

    // [START write_fan_out]
    private void writeNewPost(String uid, String petani, String sapiid,
                              int bb, int tb, int lb, int usiasapi,
                              String jenissapi, String ptsapi, String pjsapi) {
        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously
        String key = mDatabase.child("posts").push().getKey();
        Sapi sapi = new Sapi(uid, petani, sapiid, bb, tb, lb, usiasapi, jenissapi, ptsapi, pjsapi);
        Map<String, Object> postValues = sapi.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/sapi/" + key, postValues);
        childUpdates.put("/user-sapis/" + uid + "/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
    }
    // [END write_fan_out]

    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }
}
