package com.blogspot.atifsoftwares.stayfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class IntermediateActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;
    Toolbar toolbar;
    Intent intent;
    ScrollView scrollView;
    LinearLayout lytInDay1, lytInDay2, lytInDay4, lytInDay5,lytInDay6, lytInDay3,lytInDay7,  lytIn;
    RelativeLayout ReLytInDay1, ReLytInDay2, ReLytInDay4, ReLytInDay5;
    private boolean day1 = true;
    private boolean day2 = true;
    private boolean day4 = true;
    private boolean day5 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate);
        initialized();
    }

    private void initialized() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.intermediate));

        scrollView = findViewById(R.id.scrollView);
        lytInDay1 = findViewById(R.id.lytInDay1);
        lytInDay2 = findViewById(R.id.lytInDay2);
        lytInDay4 = findViewById(R.id.lytInDay4);
        lytInDay5 = findViewById(R.id.lytInDay5);
        lytInDay3 = findViewById(R.id.lytInDay3);
        lytInDay6 = findViewById(R.id.lytInDay6);
        lytInDay7 = findViewById(R.id.lytInDay7);
        lytIn = findViewById(R.id.lytIn);
        ReLytInDay1 = findViewById(R.id.ReLytInDay1);
        ReLytInDay2 = findViewById(R.id.ReLytInDay2);
        ReLytInDay4 = findViewById(R.id.ReLytInDay4);
        ReLytInDay5 = findViewById(R.id.ReLytInDay5);
    }

    public void OnClickBtn(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.lytNt:
                startActivity(new Intent(IntermediateActivity.this, NutritionActivity.class));
                finish();
                break;
            case R.id.lytEx:
                intent = new Intent(IntermediateActivity.this, MainActivity.class);
                intent.putExtra("Key", "false");
                startActivity(intent);
                finish();
                break;
            case R.id.lytLog:
                startActivity(new Intent(IntermediateActivity.this, LogActivity.class));
                finish();
                break;
            case R.id.lytInDay1:
                if (day1) {
                    ReLytInDay1.setVisibility(View.VISIBLE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day1 = false;
                } else {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day1 = true;
                }
                break;
            case R.id.lytInDay2:
                if (day2) {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.VISIBLE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day2 = false;
                } else {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day2 = true;
                }
                break;
            case R.id.lytInDay4:
                if (day4) {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.VISIBLE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day4 = false;
                } else {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day4 = true;
                }
                break;
            case R.id.lytInDay5:
                if (day5) {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.VISIBLE);
                    day5 = false;
                } else {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day5 = true;
                }
                break;
            case R.id.lytInDay3:
                Toast.makeText(getApplicationContext(), "Off Day", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lytInDay6:
                Toast.makeText(getApplicationContext(), "Off Day", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lytInDay7:
                Toast.makeText(getApplicationContext(), "Off Day", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}