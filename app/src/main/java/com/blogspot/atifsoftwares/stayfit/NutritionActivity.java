package com.blogspot.atifsoftwares.stayfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class NutritionActivity extends AppCompatActivity {
    //todo App Global variable
    boolean doubleBackToExitPressedOnce = false;
    Menu menu;
    Toolbar toolbar;
    Intent intent;
    LinearLayout lytNt;
    RelativeLayout layoutNutrition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
        initialize();
    }
    private void initialize(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        layoutNutrition = findViewById(R.id.layoutNutrition);
        lytNt = findViewById(R.id.lytNt);
        lytNt.setBackgroundColor(Color.parseColor("#276e8c"));
    }

    public void OnClickBtn(View view) {
        int id = view.getId();
        switch (id){
            case R.id.lytNt:
                break;
            case R.id.lytEx:
                intent = new Intent(NutritionActivity.this, MainActivity.class);
                intent.putExtra("Key", "false");
                startActivity(intent);
                finish();
                break;
            case R.id.lytLog:
                startActivity(new Intent(NutritionActivity.this, LogActivity.class));
                finish();
                break;
            case R.id.lytWeightLoss:
            startActivity(new Intent(NutritionActivity.this, WeightLossActivity.class));
                break;
            case R.id.lytBuildMuscle:
                startActivity(new Intent(NutritionActivity.this, BuildMuscleActivity.class));

                break;
            case R.id.lytGrtLean:
                startActivity(new Intent(NutritionActivity.this, GetLeanActivity.class));

                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.workoutMenu) {
            intent = new Intent(NutritionActivity.this, AddNoteActivity.class);
            intent.putExtra("log", "Workout");
            startActivity(intent);
            return true;
        }
        else if (id == R.id.mealMenu) {
            intent = new Intent(NutritionActivity.this, AddNoteActivity.class);
            intent.putExtra("log", "Meal");
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getString(R.string.exit_msg), Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}