package com.blogspot.atifsoftwares.stayfit;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

public class ProfessionalActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;
    Toolbar toolbar;
    Intent intent;

    ScrollView scrollView;
    LinearLayout lytPDay1, lytPDay2, lytPDay3, lytPDay4, lytPDay5, lytPDay6, lytPDay7,  lytIn;
    RelativeLayout ReLytInDay1, ReLytInDay2, ReLytInDay4, ReLytInDay3, ReLytInDay5;
    private boolean day1 = true;
    private boolean day2 = true;
    private boolean day3 = true;
    private boolean day4 = true;
    private boolean day5 = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professional);
        initialized();
    }
    private void initialized() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.professional));

        scrollView = findViewById(R.id.scrollView);
        lytPDay1 = findViewById(R.id.lytPDay1);
        lytPDay2 = findViewById(R.id.lytPDay2);
        lytPDay3 = findViewById(R.id.lytPDay3);
        lytPDay4 = findViewById(R.id.lytPDay4);
        lytPDay5 = findViewById(R.id.lytPDay5);
        lytPDay6 = findViewById(R.id.lytPDay6);
        lytPDay7 = findViewById(R.id.lytPDay7);
        lytIn = findViewById(R.id.lytP);
        ReLytInDay1 = findViewById(R.id.ReLytPDay1);
        ReLytInDay2 = findViewById(R.id.ReLytPDay2);
        ReLytInDay3 = findViewById(R.id.ReLytPDay3);
        ReLytInDay4 = findViewById(R.id.ReLytPDay4);
        ReLytInDay5 = findViewById(R.id.ReLytPDay5);
    }
    public void OnClickBtn(View view) {
        int id = view.getId();
        switch (id){
            case R.id.lytNt:
                startActivity(new Intent(ProfessionalActivity.this, NutritionActivity.class));
                finish();
                break;
            case R.id.lytEx:
                intent = new Intent(ProfessionalActivity.this, MainActivity.class);
                intent.putExtra("Key", "false");
                startActivity(intent);
                finish();
                break;
            case R.id.lytLog:
                startActivity(new Intent(ProfessionalActivity.this, LogActivity.class));
                finish();
                break;

            case R.id.lytPDay1:
                if (day1) {
                    ReLytInDay1.setVisibility(View.VISIBLE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay3.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day1 = false;
                } else {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay3.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day1 = true;
                }
                break;
            case R.id.lytPDay2:
                if (day2) {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.VISIBLE);
                    ReLytInDay3.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day2 = false;
                } else {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day2 = true;
                }
                break;
            case R.id.lytPDay3:
                if (day3) {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay3.setVisibility(View.VISIBLE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day3 = false;
                } else {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay3.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day3 = true;
                }
                break;
            case R.id.lytPDay4:
                if (day4) {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay3.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.VISIBLE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day4 = false;
                } else {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay3.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day4 = true;
                }
                break;
            case R.id.lytPDay5:
                if (day5) {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay3.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.VISIBLE);
                    day5 = false;
                } else {
                    ReLytInDay1.setVisibility(View.GONE);
                    ReLytInDay2.setVisibility(View.GONE);
                    ReLytInDay3.setVisibility(View.GONE);
                    ReLytInDay4.setVisibility(View.GONE);
                    ReLytInDay5.setVisibility(View.GONE);
                    day5 = true;
                }
                break;
            case R.id.lytPDay6:
                Toast.makeText(getApplicationContext(), "Off Day", Toast.LENGTH_SHORT).show();
                break;
            case R.id.lytPDay7:
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