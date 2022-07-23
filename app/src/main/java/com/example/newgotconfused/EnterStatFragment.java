package com.example.newgotconfused;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class EnterStatFragment extends Fragment {

    // vars
    View view;
    private Button playerStat1, exitButton;

    // constructors
    public EnterStatFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_enter_stat, container, false);

        playerStat1 = view.findViewById(R.id.playerStat1);
        exitButton = view.findViewById(R.id.exitButton);

        /**
         * click listener for enter stat button - displays toast and exits fragment
         */
        playerStat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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