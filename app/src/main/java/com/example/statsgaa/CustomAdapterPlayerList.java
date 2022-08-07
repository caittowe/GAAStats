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


public class CustomAdapterPlayerList extends RecyclerView.Adapter<CustomAdapterPlayerList.MyViewHolder> {


    private Context context;
    Activity activity;
    private ArrayList squad_table_id, squad_id, squad_name, player_name, player_no;

    int position;


    /**
     * constructor with args
     * @param context
     * @param squad_id
     * @param squad_name
     * @param player_name
     * @param player_no
     */
    CustomAdapterPlayerList(Activity activity, Context context, ArrayList squad_id, ArrayList squad_name, ArrayList player_name, ArrayList player_no) {
        this.activity = activity;
        this.context = context;
        this.squad_id = squad_id;
        this.squad_name = squad_name;
        this.player_name = player_name;
        this.player_no = player_no;
    }


    @NonNull
    @Override
    public CustomAdapterPlayerList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_player_row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterPlayerList.MyViewHolder holder, final int position) {
        this.position = position;

        holder.player_id_txt.setText(String.valueOf(squad_id.get(position)));
        holder.player_name_txt.setText(String.valueOf(squad_name.get(position)));
        holder.player_number_txt.setText(String.valueOf(player_name.get(position)));
        holder.player_scores_txt.setText(String.valueOf(player_no.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditPlayer.class);
                intent.putExtra("squad_table_id", toString().valueOf(squad_table_id.get(position)));
                intent.putExtra("squad_id", toString().valueOf(squad_id.get(position)));
                intent.putExtra("squad_name", toString().valueOf(squad_name.get(position)));
                intent.putExtra("player_name", toString().valueOf(player_name.get(position)));
                intent.putExtra("player_no", toString().valueOf(player_no.get(position)));
                // allows changes to be seen
                activity.startActivityForResult(intent,1);
            }
        });
    }
    @Override
    public int getItemCount() {
        return squad_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView player_id_txt, player_name_txt, player_number_txt, player_scores_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            player_id_txt = itemView.findViewById(R.id.player_id_txt);
            player_name_txt = itemView.findViewById(R.id.squad_name_txt);
            player_number_txt = itemView.findViewById(R.id.squad_id_txt);
            player_scores_txt = itemView.findViewById(R.id.player_scores_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}