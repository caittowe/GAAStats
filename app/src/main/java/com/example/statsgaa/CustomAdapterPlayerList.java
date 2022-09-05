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
 * Receives array lists of player numbers and player names
 * Creates a view for each item in arraylists
 * Sends data to be displayed in DisplaySquad class.
 */
public class CustomAdapterPlayerList extends RecyclerView.Adapter<CustomAdapterPlayerList.MyViewHolder> {

    // vars
    public Context context;
    public Activity activity;
    public ArrayList playerNo, playerName;
    public String squadID;
    private int position;

    /**
     * default constructor
     */
    public CustomAdapterPlayerList(){

    }

    /**
     * constructor with args
     * @param context
     */
    CustomAdapterPlayerList(Activity activity, Context context, String squadID, ArrayList playerNo, ArrayList playerName) {
        this.activity = activity;
        this.context = context;
        this.squadID = squadID;
        this.playerNo = playerNo;
        this.playerName = playerName;
    }


    @NonNull
    @Override
    /**
     * inflates the view holder
     */
    public CustomAdapterPlayerList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_player_row, parent,false);
        return new CustomAdapterPlayerList.MyViewHolder(view);
    }

    @Override
    /**
     * sets textviews of player names and player numbers in list
     */
    public void onBindViewHolder(@NonNull CustomAdapterPlayerList.MyViewHolder holder, final int position) {
        this.position = position;

        holder.player_no_txt.setText(String.valueOf(playerNo.get(position)));
        holder.player_name_txt.setText(String.valueOf(playerName.get(position)));

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EditPlayer.class);
                intent.putExtra("squadID", squadID);
                intent.putExtra("playerName", String.valueOf(playerName.get(position)));
                intent.putExtra("playerNo", String.valueOf(playerNo.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });
    }


    @Override
    /**
     * returns item count
     */
    public int getItemCount() {
        return playerNo.size();
    }

    /**
     *  view holder
     */
    public class MyViewHolder extends RecyclerView.ViewHolder{

        // views
        TextView player_no_txt, player_name_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            player_no_txt = itemView.findViewById(R.id.player_no_txt);
            player_name_txt = itemView.findViewById(R.id.player_name_txt);
            mainLayout = itemView.findViewById(R.id.mainPlayerLayout);

        }
    }


}