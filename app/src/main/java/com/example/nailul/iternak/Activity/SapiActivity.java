package com.example.nailul.iternak.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.nailul.iternak.Adapter.SapiAda;
import com.example.nailul.iternak.Adapter.SapiAdapter;
import com.example.nailul.iternak.Models.Sapi;
import com.example.nailul.iternak.R;
import com.example.nailul.iternak.ViewHolder.SapiViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.widget.SearchViewCompat.getQuery;

public class SapiActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private Toolbar mSapiToolbar;
    private List<SapiAda> sapiAdaList =new ArrayList<>();

    private FirebaseRecyclerAdapter<Sapi, SapiViewHolder> mAdapter;
    private RecyclerView mRecycler;
    private LinearLayoutManager mManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sapi);

        mSapiToolbar =(Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(mSapiToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        
        mRecycler = (RecyclerView) findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setItemAnimator(new DefaultItemAnimator());
        mRecycler.setAdapter(mAdapter);

        Query postsQuery = getQuery(mDatabase);
        mAdapter = new FirebaseRecyclerAdapter<Sapi, SapiViewHolder>(Sapi.class, R.layout.activity_sapi_detail,
                SapiViewHolder.class, postsQuery) {

            @Override
            protected void populateViewHolder(final SapiViewHolder viewHolder, final Sapi model, final int position) {
                final DatabaseReference postRef = getRef(position);

                // Set click listener for the whole post view
                final String postKey = postRef.getKey();
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Launch PostDetailActivity
                        Intent sapiDetail = new Intent(SapiActivity.this, SapiDetailActivity.class);
                        sapiDetail.putExtra(SapiDetailActivity.EXTRA_POST_KEY, postKey);
                        startActivity(sapiDetail);
                    }
                });

            }
        };
        mRecycler.setAdapter(mAdapter);

    }

    @Override
    public Query getQuery(DatabaseReference databaseReference) {
        // [START recent_posts_query]
        // Last 100 posts, these are automatically the 100 most recent
        // due to sorting by push() keys
        Query recentPostsQuery = databaseReference.child("posts")
                .limitToFirst(100);
        // [END recent_posts_query]

        return recentPostsQuery;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //addSapiBtn clicked
        if(id == R.id.addSapiBtn){
            startActivity(new Intent(SapiActivity.this, SapiBaru.class));
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }
}
