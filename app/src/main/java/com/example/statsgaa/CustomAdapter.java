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
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList player_id, player_name;

    int position;

    /**
     * constructor with args
     * @param context
     * @param player_id
     * @param player_name
     */
    CustomAdapter(Activity activity, Context context, ArrayList player_id, ArrayList player_name){
        this.activity = activity;
        this.context = context;
        this.player_id = player_id;
        this.player_name = player_name;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent,false);
        return new MyViewHolder(view);
    }

    /**
     * updates the data with the given values
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        this.position = position;

        holder.player_id_txt.setText(String.valueOf(player_id.get(position)));
        holder.player_name_txt.setText(String.valueOf(player_name.get(position)));

        holder.playersLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SquadSetup.class);
                intent.putExtra("id", toString().valueOf(player_id.get(position)));
                intent.putExtra("name", toString().valueOf(player_name.get(position)));
                // allows changes to be seen
                activity.startActivityForResult(intent,1);
            }
        });

    }

    /**
     * returns number of players in the table by counting the ids
     * @return
     */
    @Override
    public int getItemCount() {
        return player_id.size();
    }


    /**
     * identifies the ids in the recycler view
     */
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView player_id_txt, player_name_txt;
        LinearLayout playersLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            player_id_txt = itemView.findViewById(R.id.player_id_txt);
            player_name_txt = itemView.findViewById(R.id.player_name_txt);
            playersLayout = itemView.findViewById(R.id.rowLayout);
        }
    }
}
