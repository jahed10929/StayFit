package com.blogspot.atifsoftwares.stayfit;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //todo App Global variable
    boolean doubleBackToExitPressedOnce = false;
    String showDilog;
    Menu menu;
    Toolbar toolbar;
    Intent intent;
    LinearLayout lytEx;
    RelativeLayout layoutHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }
    private void initialize(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        layoutHome = findViewById(R.id.layoutHome);
        lytEx = findViewById(R.id.lytEx);
        lytEx.setBackgroundColor(Color.parseColor("#276e8c"));
        intent = getIntent();
        showDilog = intent.getStringExtra("Key");
        if (showDilog.equals("true"))
            checkLevel();
    }

    public void OnClickBtn(View view) {
        int id = view.getId();
        switch (id){
            case R.id.lytNt:
                startActivity(new Intent(MainActivity.this, NutritionActivity.class));
                finish();
                break;
            case R.id.lytEx:
                break;
            case R.id.lytLog:
                startActivity(new Intent(MainActivity.this, LogActivity.class));
                finish();
                break;
            case R.id.lytBeginner:
                startActivity(new Intent(MainActivity.this, BeginnerActivity.class));
                break;
            case R.id.lytIntermediate:
                startActivity(new Intent(MainActivity.this, IntermediateActivity.class));
                break;
            case R.id.lytProfessional:
                startActivity(new Intent(MainActivity.this, ProfessionalActivity.class));
                break;
        }
    }

    private void checkLevel() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.fitness_dialog_title);
        builder.setMessage(R.string.fitness_dialog_message);
        builder.setPositiveButton(R.string.dialog_yes_button, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://quiz.quizbound.io/hLI39CreNSqs3SaJAPZ8"));
                startActivity(intent);

            }
        });
        builder.setNegativeButton(R.string.dialog_no_button, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
//        showDilog = "false";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.workoutMenu) {
            intent = new Intent(MainActivity.this, AddNoteActivity.class);
            intent.putExtra("log", "Workout");
            startActivity(intent);
            return true;
        }
        else if (id == R.id.mealMenu) {
            intent = new Intent(MainActivity.this, AddNoteActivity.class);
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