package com.example.statsgaa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 *
 */


public class CustomAdapterSquadList extends RecyclerView.Adapter<CustomAdapterSquadList.MyViewHolder> {


    private Context context;
    Activity activity;
    private ArrayList squadID, squadName;
    int position;


    /**
     * constructor with args
     * @param context
     * @param squadID
     * @param squadName

     */
    CustomAdapterSquadList(Activity activity, Context context, ArrayList squadID, ArrayList squadName) {
        this.activity = activity;
        this.context = context;
        this.squadID = squadID;
        this.squadName = squadName;
    }


    @NonNull
    @Override
    public CustomAdapterSquadList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_squad_row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterSquadList.MyViewHolder holder, final int position) {
        this.position = position;

        holder.squad_id_txt.setText(String.valueOf(squadID.get(position)));
        holder.squad_name_txt.setText(String.valueOf(squadName.get(position)));


        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DisplaySquad.class);
                intent.putExtra("squad_id", toString().valueOf(squadID.get(position)));
                activity.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return squadID.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView squad_id_txt, squad_name_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            squad_id_txt = itemView.findViewById(R.id.squad_id_txt);
            squad_name_txt = itemView.findViewById(R.id.squad_name_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}