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


public class CustomAdapterShowStats extends RecyclerView.Adapter<CustomAdapterShowStats.MyViewHolder> {

    private Context context;
    Activity activity;
    private ArrayList book_id, book_title, book_author, book_pages;

    int position;


    /**
     * constructor with args
     * @param context
     * @param book_id
     * @param book_title
     * @param book_author
     * @param book_pages
     */
    CustomAdapterShowStats(Activity activity, Context context, ArrayList book_id, ArrayList book_title, ArrayList book_author, ArrayList book_pages){
        this.activity = activity;
        this.context = context;
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_author = book_author;
        this.book_pages = book_pages;
    }

    @NonNull
    @Override
    public CustomAdapterShowStats.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterShowStats.MyViewHolder holder, final int position) {
        this.position = position;

        holder.book_id_txt.setText(String.valueOf(book_id.get(position)));
        holder.book_title_txt.setText(String.valueOf(book_title.get(position)));
        holder.book_author_txt.setText(String.valueOf(book_author.get(position)));
        holder.book_pages_txt.setText(String.valueOf(book_pages.get(position)));

//        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, EnterStat.class);
//                intent.putExtra("id", toString().valueOf(book_id.get(position)));
//                intent.putExtra("title", toString().valueOf(book_title.get(position)));
//                intent.putExtra("author", toString().valueOf(book_author.get(position)));
//                intent.putExtra("pages", toString().valueOf(book_pages.get(position)));
//                // allows changes to be seen
//                activity.startActivityForResult(intent,1);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return book_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView book_id_txt, book_title_txt, book_author_txt, book_pages_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_id_txt = itemView.findViewById(R.id.player_id_txt);
            book_title_txt = itemView.findViewById(R.id.player_name_txt);
            book_author_txt = itemView.findViewById(R.id.player_number_txt);
            book_pages_txt = itemView.findViewById(R.id.player_scores_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}