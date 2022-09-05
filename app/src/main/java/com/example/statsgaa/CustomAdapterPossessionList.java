package com.example.statsgaa;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Receives array lists of player numbers, player names and player possessions
 * Creates a view for each item in arraylists
 * Sends data to be displayed in ShowPossessions class.
 */
public class CustomAdapterPossessionList extends RecyclerView.Adapter<CustomAdapterPossessionList.MyViewHolder> {

    // vars
    public Context context;
    public Activity activity;
    public ArrayList playerNamesOrder, playerNosOrder, playerPossessionsOrder;
    private int position;


    /**
     * default constructor
     */
    public CustomAdapterPossessionList() {

    }

    /**
     * constructor with args
     *
     * @param context
     */
    CustomAdapterPossessionList(Activity activity, Context context, ArrayList playerNamesOrder, ArrayList playerNosOrder, ArrayList playerPossessionsOrder) {
        this.activity = activity;
        this.context = context;
        this.playerNamesOrder = playerNamesOrder;
        this.playerNosOrder = playerNosOrder;
        this.playerPossessionsOrder = playerPossessionsOrder;
    }


    @NonNull
    @Override
    /**
     *  inflates the view holder
     */
    public CustomAdapterPossessionList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_possessions_row, parent, false);
        return new CustomAdapterPossessionList.MyViewHolder(view);
    }

    @Override
    /**
     * sets textviews of player names, numbers and possession counts in list
     */
    public void onBindViewHolder(@NonNull CustomAdapterPossessionList.MyViewHolder holder, final int position) {
        this.position = position;

        holder.playerNo.setText(String.valueOf(playerNosOrder.get(position)));
        holder.playerName.setText(String.valueOf(playerNamesOrder.get(position)));
        holder.playerPossessions.setText(String.valueOf(playerPossessionsOrder.get(position)));
    }

    @Override
    /**
     * returns item counts
     */
    public int getItemCount() {
        return playerNamesOrder.size();
    }

    /**
     * view holder
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView playerNo, playerName, playerPossessions;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            playerNo = itemView.findViewById(R.id.playerNo);
            playerName = itemView.findViewById(R.id.playerName);
            playerPossessions = itemView.findViewById(R.id.playerPossessions);
            mainLayout = itemView.findViewById(R.id.mainPossessionsLayout);

        }
    }
}