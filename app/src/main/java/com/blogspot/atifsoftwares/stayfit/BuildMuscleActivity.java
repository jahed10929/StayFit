package com.blogspot.atifsoftwares.stayfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class BuildMuscleActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;
    Toolbar toolbar;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_muscle);
        initialized();
    }
    private void initialized() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.build_muscle));

    }
    public void OnClickBtn(View view) {
        int id = view.getId();
        switch (id){
            case R.id.lytNt:
                startActivity(new Intent(BuildMuscleActivity.this, NutritionActivity.class));
                finish();
                break;
            case R.id.lytEx:
                intent = new Intent(BuildMuscleActivity.this, MainActivity.class);
                intent.putExtra("Key", "false");
                startActivity(intent);
                finish();
                break;
            case R.id.lytLog:
                startActivity(new Intent(BuildMuscleActivity.this, LogActivity.class));
                finish();
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