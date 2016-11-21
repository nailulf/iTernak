package com.example.nailul.iternak.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.nailul.iternak.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        ImageButton sapiBtn = (ImageButton)findViewById(R.id.sapiButton);
        ImageButton investorBtn = (ImageButton)findViewById(R.id.investorButton);
        ImageButton petaniBtn = (ImageButton)findViewById(R.id.petaniButton);
        ImageButton mantriBtn = (ImageButton)findViewById(R.id.mantriButton);
        ImageButton plannerBtn = (ImageButton)findViewById(R.id.plannerButton);


        sapiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SapiActivity.class);
                startActivity(intent);
            }
        });

        petaniBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "This option not ready yet",Toast.LENGTH_LONG).show();
            }
        });


        investorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "This option not ready yet",Toast.LENGTH_LONG).show();
            }
        });

        mantriBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "This option not ready yet",Toast.LENGTH_LONG).show();
            }
        });

        plannerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "This option not ready yet",Toast.LENGTH_LONG).show();
            }
        });
    }
}
