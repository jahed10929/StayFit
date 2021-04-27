package com.blogspot.atifsoftwares.stayfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AddNoteActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;
    Toolbar toolbar;
    Intent intent;
    String log, title, dis;
    EditText noteTitle, noteDetails;
    Calendar c;
    String todaysDate;
    String currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        intent = getIntent();
        log = intent.getStringExtra("log");
        initialized();
    }

    private void initialized() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("New " + log + " Log");

        noteDetails = findViewById(R.id.noteDetails);
        noteTitle = findViewById(R.id.noteTitle);
        noteTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0) {
                    getSupportActionBar().setTitle(s);
                }
                else
                    getSupportActionBar().setTitle("New " + log + " Log");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // set current date and time
        c = Calendar.getInstance();
        todaysDate = c.get(Calendar.DAY_OF_MONTH) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR);
        Log.d("DATE", "Date: " + todaysDate);
        currentTime = pad(c.get(Calendar.HOUR)) + ":" + pad(c.get(Calendar.MINUTE));
        Log.d("TIME", "Time: " + currentTime);
    }

    private String pad(int time) {
        if (time < 10)
            return "0" + time;
        return String.valueOf(time);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                if (!noteTitle.getText().toString().isEmpty()&&noteDetails.getText().toString().isEmpty()){
                    super.onBackPressed();
                    Toast.makeText(this, "Note not Saved.", Toast.LENGTH_SHORT).show();
                }
                else
                    super.onBackPressed();

                return true;
            case R.id.save:
                if(log.equals("Workout")){
                    if (isNotEmpty()){
                        Note note = new Note(noteTitle.getText().toString().toUpperCase(),noteDetails.getText().toString(),todaysDate,currentTime);
                        SimpleDatabase sDB = new SimpleDatabase(this);
                        long id = sDB.addWorkoutNote(note);
                        Note check = sDB.getWorkoutNote(id);
                        onBackPressed();
                    }
                }
                else {
                    if (isNotEmpty()){
                        Note note = new Note(noteTitle.getText().toString().toUpperCase(),noteDetails.getText().toString(),todaysDate,currentTime);
                        SimpleDatabase sDB = new SimpleDatabase(this);
                        long id = sDB.addMealNote(note);
                        Note check = sDB.getMealNote(id);
                        onBackPressed();
                    }
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private boolean isNotEmpty(){
        if (noteTitle.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Empty Title", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if(noteDetails.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Empty Note", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;
    }
}