package com.example.nailul.iternak.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nailul.iternak.Models.Sapi;
import com.example.nailul.iternak.R;

/**
 * Created by Nailul on 11/21/2016.
 * ini adalah file java untuk menyimpan informasi sapi, viewHolder ini akan dipanggil pada SapiDetailAtivity.java
 */

public class SapiViewHolder extends RecyclerView.ViewHolder {

    //inisialisasi informasi sapi yang disimpan pada database
    public TextView idSapiView,
            jenisSapiView,
            usiaSapiView,
            BBSapiView,
            TBSapiView,
            LBSapiView,
            PTSapiView,
            PJSapiView;
    public ImageView sapiView;

    public SapiViewHolder(View itemView) {
        super(itemView);

        idSapiView = (TextView) itemView.findViewById(R.id.valIdSapi);
        jenisSapiView = (TextView) itemView.findViewById(R.id.valJenisSapi);
        usiaSapiView = (TextView) itemView.findViewById(R.id.valUsiaSapi);
        BBSapiView = (TextView) itemView.findViewById(R.id.valBBSapi);
        TBSapiView = (TextView) itemView.findViewById(R.id.valTBSapi);
        LBSapiView = (TextView) itemView.findViewById(R.id.valLBSapi);
        PTSapiView = (TextView) itemView.findViewById(R.id.valPtSapi);
        PJSapiView = (TextView) itemView.findViewById(R.id.valPJSapi);
    }

    public void bindToSapi(Sapi sapi, View.OnClickListener starClickListener) {
        idSapiView.setText(sapi.sapiid);
        jenisSapiView.setText(sapi.jenissapi);
        usiaSapiView.setText(sapi.usiasapi);
        BBSapiView.setText(sapi.bb);
        TBSapiView.setText(sapi.tb);
        LBSapiView.setText(sapi.lb);
        PTSapiView.setText(sapi.ptsapi);
        PJSapiView.setText(sapi.pjsapi);

        sapiView.setOnClickListener(starClickListener);
    }
}

