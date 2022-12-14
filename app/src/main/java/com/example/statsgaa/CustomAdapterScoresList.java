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

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Receives array lists of player numbers, player names and player scores
 * Creates a view for each item in arraylists
 * Sends data to be displayed in ShowScoresDesc class.
 */
public class CustomAdapterScoresList extends RecyclerView.Adapter<CustomAdapterScoresList.MyViewHolder> {

    // vars
    public Context context;
    public Activity activity;
    public ArrayList playerNamesOrder, playerNosOrder, playerPoints, playerGoals;
    private int position;


    /**
     * default constructor
     */
   public CustomAdapterScoresList(){

    }

    /**
     * constructor with args
     * @param context
     */
    public CustomAdapterScoresList(Activity activity, Context context, ArrayList playerNamesOrder, ArrayList playerNosOrder,ArrayList playerGoals, ArrayList playerPoints, ArrayList playerScoresOrder){
        this.activity = activity;
        this.context = context;
        this.playerNamesOrder = playerNamesOrder;
        this.playerNosOrder = playerNosOrder;
        this.playerGoals = playerGoals;
        this.playerPoints = playerPoints;
    }


    @NonNull
    @Override
    /**
     * inflates the view holder
     */
    public CustomAdapterScoresList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_scores_row, parent,false);
        return new CustomAdapterScoresList.MyViewHolder(view);
    }

    @Override
    /**
     *  sets text views of player names, number, goals and points in list
     */
    public void onBindViewHolder(@NonNull CustomAdapterScoresList.MyViewHolder holder, final int position) {
        this.position = position;

        holder.player_no_txt.setText(String.valueOf(playerNosOrder.get(position)));
        holder.player_name_txt.setText(String.valueOf(playerNamesOrder.get(position)));
        holder.player_goal_txt.setText(String.valueOf(playerGoals.get(position)));
        holder.player_point_txt.setText(String.valueOf(playerPoints.get(position)));
    }

    @Override
    /**
     * returns item count
     */
    public int getItemCount() {
        return playerNamesOrder.size();
    }

    /**
     * view holder
     */
    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView player_no_txt, player_name_txt, player_goal_txt, player_point_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            player_no_txt = itemView.findViewById(R.id.playerNo);
            player_name_txt = itemView.findViewById(R.id.playerName);
            player_goal_txt = itemView.findViewById(R.id.playerGoals);
            player_point_txt = itemView.findViewById(R.id.playerPoints);
            mainLayout = itemView.findViewById(R.id.mainScoresLayout);

        }
    }
}