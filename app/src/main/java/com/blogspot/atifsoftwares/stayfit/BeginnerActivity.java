package com.blogspot.atifsoftwares.stayfit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class BeginnerActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;
    Toolbar toolbar;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner);
        initialized();
    }

    private void initialized() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.beginner));

    }

    public void OnClickBtn(View view) {
        int id = view.getId();
        switch (id){
            case R.id.lytNt:
                startActivity(new Intent(BeginnerActivity.this, NutritionActivity.class));
                finish();
                break;
            case R.id.lytEx:
                intent = new Intent(BeginnerActivity.this, MainActivity.class);
                intent.putExtra("Key", "false");
                startActivity(intent);
                finish();
                break;
            case R.id.lytLog:
                startActivity(new Intent(BeginnerActivity.this, LogActivity.class));
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