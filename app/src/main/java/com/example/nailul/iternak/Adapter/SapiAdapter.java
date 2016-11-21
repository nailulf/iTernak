package com.example.nailul.iternak.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nailul.iternak.R;

import java.util.List;

/**
 * Created by Nailul on 11/18/2016.
 */

public class SapiAdapter extends RecyclerView.Adapter<SapiAdapter.MyViewHolder> {

    private List<SapiAda> sapisList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView IDSapi, BB, TB, LB;

        public MyViewHolder(View view){
            super(view);
            IDSapi =(TextView)view.findViewById(R.id.IDSapi);
            BB=(TextView)view.findViewById(R.id.BB);
            TB=(TextView)view.findViewById(R.id.TB);
            LB=(TextView)view.findViewById(R.id.LB);
        }
    }

    public SapiAdapter(List<SapiAda> sapisList){
        this.sapisList = sapisList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sapi_list_row, parent, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SapiAda sapiAda = sapisList.get(position);
        holder.IDSapi.setText(sapiAda.getIDSapi());
        holder.BB.setText(sapiAda.getBB());
        holder.TB.setText(sapiAda.getTB());
        holder.LB.setText(sapiAda.getLB());
    }

    @Override
    public int getItemCount() {
        return sapisList.size();
    }
}
