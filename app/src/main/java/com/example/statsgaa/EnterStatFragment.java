package com.example.statsgaa;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class EnterStatFragment extends Fragment {

    // vars
    View view;
    TextView playerName;
    private Button point, exitButton;
    int points = 0;

    // constructors
    public EnterStatFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_enter_stat, container, false);

        View name1 = getActivity().findViewById(R.id.playerName1);

        exitButton = view.findViewById(R.id.exitButton);
        playerName = view.findViewById(R.id.playerName);

        // NEED TO PASS ARRAYLIST TO FRAGMENT HERE
        Bundle bundle = this.getArguments();
        ArrayList<Player> players = bundle.getParcelableArrayList("message");
        playerName.setText(players.get(0).toString());


        point = view.findViewById(R.id.point);


        /**
         * click listener for point button - displays toast and exits fragment
         */
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // here we need to enter SQL statement - increment the point where player name = button clicked
                Toast.makeText(getActivity(), "Stat Entered", Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction().remove(EnterStatFragment.this).commit();
            }
        });

        /**
         * Click listener for the exit button - exits out of fragment
         */
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().beginTransaction().remove(EnterStatFragment.this).commit();
            }
        });
        return view;
    }

}