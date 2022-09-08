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
 *  Receives array lists of squad ids and squad names
 *  Creates a view for each item in arraylists
 *  Sends data to be displayed in SavedSquad class.
 */
public class CustomAdapterSquadList extends RecyclerView.Adapter<CustomAdapterSquadList.MyViewHolder> {

    // vars
    public Context context;
    public Activity activity;
    public ArrayList squadID, squadName;
    private int position;

    /**
     * default constructor
     */
    CustomAdapterSquadList(){

    }

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
    /**
     * inflates the view holder
     */
    public CustomAdapterSquadList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_squad_row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    /**
     * sets text view of squad id and squad name in list
     */
    public void onBindViewHolder(@NonNull CustomAdapterSquadList.MyViewHolder holder, final int position) {
        this.position = position;

        holder.squad_id_txt.setText(String.valueOf(squadID.get(position)));
        holder.squad_name_txt.setText(String.valueOf(squadName.get(position)));


        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DisplaySquad.class);
                intent.putExtra("squad_id", toString().valueOf(squadID.get(position)));
                intent.putExtra("squadName", toString().valueOf(squadName.get(position)));
                activity.startActivity(intent);
            }
        });
    }

    @Override
    /**
     * returns item count
     */
    public int getItemCount() {
        return squadID.size();
    }

    /**
     * view holder
     */
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