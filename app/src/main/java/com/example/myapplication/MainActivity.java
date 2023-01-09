package com.example.myapplication;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private int check = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        Log.d("debg", "1");
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        Log.d("debg", "2");
        setContentView(binding.getRoot());
        Log.d("debg", "3");
        setSupportActionBar(binding.toolbar);
        Log.d("debg", "8");
        findViewById(R.id.Wrong_layout).setVisibility(View.INVISIBLE);
        findViewById(R.id.Correct_Layout).setVisibility(View.INVISIBLE);
        findViewById(R.id.Q_Layout).setVisibility(View.INVISIBLE);
        findViewById(R.id.txt_fråga1).setVisibility(View.INVISIBLE);
        findViewById(R.id.txt_fråga2).setVisibility(View.INVISIBLE);
        findViewById(R.id.txt_fråga3).setVisibility(View.INVISIBLE);
        findViewById(R.id.txt_fråga4).setVisibility(View.INVISIBLE);
        findViewById(R.id.txt_fråga5).setVisibility(View.INVISIBLE);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void btnTrue_onClick(View v) {

        findViewById(R.id.Correct_Layout).setVisibility(View.VISIBLE);

        findViewById(R.id.Q_Layout).setVisibility(View.INVISIBLE);

        disable();

    }

    public void btnFalse_onClick(View v) {

        findViewById(R.id.Wrong_layout).setVisibility(View.VISIBLE);

        findViewById(R.id.Q_Layout).setVisibility(View.INVISIBLE);

        disable();

    }


    public void btnStart_onClick(View v) {

        findViewById(R.id.Main_layout).setVisibility(View.INVISIBLE);

        findViewById(R.id.Q_Layout).setVisibility(View.VISIBLE);

        double r = Math.random();

        if(r > 0 && r < 0.2 && check != 1) {
            findViewById(R.id.txt_fråga1).setVisibility(View.VISIBLE);
            findViewById(R.id.btn_sant).setOnClickListener(this::btnTrue_onClick);
            findViewById(R.id.btn_falskt).setOnClickListener(this::btnFalse_onClick);
            check = 1;
        }

        else if (r > 0.2 && r < 0.4 && check != 2) {
            findViewById(R.id.txt_fråga2).setVisibility(View.VISIBLE);
            findViewById(R.id.btn_sant).setOnClickListener(this::btnTrue_onClick);
            findViewById(R.id.btn_falskt).setOnClickListener(this::btnFalse_onClick);
            check = 2;
        }

        else if (r > 0.4 && r < 0.6 && check != 3) {
            findViewById(R.id.txt_fråga3).setVisibility(View.VISIBLE);
            findViewById(R.id.btn_sant).setOnClickListener(this::btnTrue_onClick);
            findViewById(R.id.btn_falskt).setOnClickListener(this::btnFalse_onClick);
            check = 3;
        }

        else if (r > 0.6 && r < 0.8 && check != 4) {
            findViewById(R.id.txt_fråga4).setVisibility(View.VISIBLE);
            findViewById(R.id.btn_sant).setOnClickListener(this::btnFalse_onClick);
            findViewById(R.id.btn_falskt).setOnClickListener(this::btnTrue_onClick);
            check = 4;
        }

        else  {
            findViewById(R.id.txt_fråga5).setVisibility(View.VISIBLE);
            findViewById(R.id.btn_sant).setOnClickListener(this::btnFalse_onClick);
            findViewById(R.id.btn_falskt).setOnClickListener(this::btnTrue_onClick);
            check = 5;
        }



    }

    public void btnBack_onClick(View v) {

        findViewById(R.id.Main_layout).setVisibility(View.VISIBLE);
        findViewById(R.id.Correct_Layout).setVisibility(View.INVISIBLE);
        findViewById(R.id.Wrong_layout).setVisibility(View.INVISIBLE);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void disable() {
        findViewById(R.id.txt_fråga1).setVisibility(View.INVISIBLE);
        findViewById(R.id.txt_fråga2).setVisibility(View.INVISIBLE);
        findViewById(R.id.txt_fråga3).setVisibility(View.INVISIBLE);
        findViewById(R.id.txt_fråga4).setVisibility(View.INVISIBLE);
        findViewById(R.id.txt_fråga5).setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}