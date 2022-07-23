package com.example.newgotconfused;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    MaterialButton btnPlayer1,btnPlayer2;
    TextView player1Info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlayer1 = findViewById(R.id.btnPlayer1);
        btnPlayer1.setOnClickListener(this);

        btnPlayer2 = findViewById(R.id.btnPlayer2);
        btnPlayer2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        replaceFragment(new EnterStatFragment());
    }

    /**
     * makes the back button exit out of the fragment
     * @param enterStatFragment
     */
    private void replaceFragment(EnterStatFragment enterStatFragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.enterStatFrame, enterStatFragment);
        ft.commit();

    }
}