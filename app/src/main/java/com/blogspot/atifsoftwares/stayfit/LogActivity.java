package com.blogspot.atifsoftwares.stayfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class LogActivity extends AppCompatActivity {
    //todo App Global variable
    boolean doubleBackToExitPressedOnce = false;
    Menu menu;
    Toolbar toolbar;
    Intent intent;
    LinearLayout lytLog;
    RelativeLayout lytWorkout, lytMeal;
    RecyclerView recyclerView1, recyclerView2;
    Button btnWorkout,btnMeal;
    boolean workout = true;
    Adapter adapter;
    AdapterMeal adapterMeal;
    TextView empty_meal, empty_workout;
    SimpleDatabase simpleDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        initialize();
    }
    private void initialize(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        lytWorkout = findViewById(R.id.lytWorkout);
        lytMeal = findViewById(R.id.lytMeal);
        btnWorkout = findViewById(R.id.btnWorkout);
        btnMeal = findViewById(R.id.btnMeal);
        lytLog = findViewById(R.id.lytLog);
        lytLog.setBackgroundColor(Color.parseColor("#276e8c"));
        setBtnClr();



        empty_meal = findViewById(R.id.empty_meal);
        empty_workout = findViewById(R.id.empty_workout);
        recyclerView1 = findViewById(R.id.workoutRecyclerView);
        recyclerView2 = findViewById(R.id.mealRecyclerView);
        simpleDatabase = new SimpleDatabase(this);
        List<Note> allWorkoutNotes = simpleDatabase.getAllWorkoutNotes();
        List<Note> allMealNotes = simpleDatabase.getAllMealNotes();

        if(allWorkoutNotes.isEmpty()){
            empty_workout.setVisibility(View.VISIBLE);
        }else {
            empty_workout.setVisibility(View.GONE);
            displayWorkoutList(allWorkoutNotes);
        }
        if(allMealNotes.isEmpty()){
            empty_meal.setVisibility(View.VISIBLE);
        }else {
            empty_meal.setVisibility(View.GONE);
            displayMealList(allMealNotes);
        }
    }

    private void displayMealList(List<Note> allMealNotes) {
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        adapterMeal = new AdapterMeal(this,allMealNotes);
        recyclerView2.setAdapter(adapterMeal);
        //adapter.notifyDataSetChanged();
    }

    private void displayWorkoutList(List<Note> allWorkoutNotes) {
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,allWorkoutNotes);
        recyclerView1.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void setBtnClr() {
        if (workout){
            btnWorkout.setBackgroundColor(Color.parseColor("#276e8c"));
            btnMeal.setBackgroundColor(Color.parseColor("#015478"));
            lytWorkout.setVisibility(View.VISIBLE);
            lytMeal.setVisibility(View.GONE);
        }

        else{
            btnMeal.setBackgroundColor(Color.parseColor("#276e8c"));
            btnWorkout.setBackgroundColor(Color.parseColor("#015478"));
            lytWorkout.setVisibility(View.GONE);
            lytMeal.setVisibility(View.VISIBLE);
        }

    }

    public void OnClickBtn(View view) {
        int id = view.getId();
        switch (id){
            case R.id.lytNt:
                startActivity(new Intent(LogActivity.this, NutritionActivity.class));
                finish();
                break;
            case R.id.lytEx:
                intent = new Intent(LogActivity.this, MainActivity.class);
                intent.putExtra("Key", "false");
                startActivity(intent);
                finish();
                break;
            case R.id.lytLog:
                break;
            case R.id.btnWorkout:
                workout = true;
                setBtnClr();
                break;
            case R.id.btnMeal:
                workout = false;
                setBtnClr();
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
            intent = new Intent(LogActivity.this, AddNoteActivity.class);
            intent.putExtra("log", "Workout");
            startActivity(intent);
            return true;
        }
        else if (id == R.id.mealMenu) {
            intent = new Intent(LogActivity.this, AddNoteActivity.class);
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

    @Override
    protected void onResume() {
        super.onResume();
        List<Note> getallWorkoutNotes = simpleDatabase.getAllWorkoutNotes();
        List<Note> getallMealNotes = simpleDatabase.getAllMealNotes();
        if(getallWorkoutNotes.isEmpty()){
            empty_workout.setVisibility(View.VISIBLE);
        }else {
            empty_workout.setVisibility(View.GONE);
            displayWorkoutList(getallWorkoutNotes);
        }
        if(getallMealNotes.isEmpty()){
            empty_meal.setVisibility(View.VISIBLE);
        }else {
            empty_meal.setVisibility(View.GONE);
            displayMealList(getallMealNotes);
        }


    }
}