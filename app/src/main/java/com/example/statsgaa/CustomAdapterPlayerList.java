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
    private ArrayList player_id, player_name, player_number, player_scores;

    int position;


    /**
     * constructor with args
     * @param context
     * @param player_id
     * @param player_name
     * @param player_number
     * @param player_scores
     */
    CustomAdapterPlayerList(Activity activity, Context context, ArrayList player_id, ArrayList player_name, ArrayList player_number, ArrayList player_scores) {
        this.activity = activity;
        this.context = context;
        this.player_id = player_id;
        this.player_name = player_name;
        this.player_number = player_number;
        this.player_scores = player_scores;
    }


    @NonNull
    @Override
    public CustomAdapterPlayerList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterPlayerList.MyViewHolder holder, final int position) {
        this.position = position;

        holder.player_id_txt.setText(String.valueOf(player_id.get(position)));
        holder.player_name_txt.setText(String.valueOf(player_name.get(position)));
        holder.player_number_txt.setText(String.valueOf(player_number.get(position)));
        holder.player_scores_txt.setText(String.valueOf(player_scores.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditPlayer.class);
                intent.putExtra("id", toString().valueOf(player_id.get(position)));
                intent.putExtra("name", toString().valueOf(player_name.get(position)));
                intent.putExtra("number", toString().valueOf(player_number.get(position)));
                intent.putExtra("scores", toString().valueOf(player_scores.get(position)));
                // allows changes to be seen
                activity.startActivityForResult(intent,1);
            }
        });
    }
    @Override
    public int getItemCount() {
        return player_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView player_id_txt, player_name_txt, player_number_txt, player_scores_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            player_id_txt = itemView.findViewById(R.id.player_id_txt);
            player_name_txt = itemView.findViewById(R.id.player_name_txt);
            player_number_txt = itemView.findViewById(R.id.player_number_txt);
            player_scores_txt = itemView.findViewById(R.id.player_scores_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}