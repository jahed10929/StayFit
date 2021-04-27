package com.blogspot.atifsoftwares.stayfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    long id;
    String from;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView details = findViewById(R.id.noteDesc);
        Intent i = getIntent();
        id = i.getLongExtra("ID",0);
        from = i.getStringExtra("from");
        SimpleDatabase db = new SimpleDatabase(this);
        if (from.equals("meal")){
            Note noteMeal = db.getMealNote(id);
            getSupportActionBar().setTitle(noteMeal.getTitle());
            details.setText(noteMeal.getContent());
        }
        else if (from.equals("workout")){
            Note noteWorkout = db.getWorkoutNote(id);
            getSupportActionBar().setTitle(noteWorkout.getTitle());
            details.setText(noteWorkout.getContent());
        }
        details.setMovementMethod(new ScrollingMovementMethod());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                    super.onBackPressed();
        }
        if(item.getItemId() == R.id.delete){
            if (from.equals("workout")){
                SimpleDatabase db = new SimpleDatabase(getApplicationContext());
                db.deleteWorkoutNote(id);
                Toast.makeText(getApplicationContext(),"Note Deleted",Toast.LENGTH_SHORT).show();
            }
            else if (from.equals("meal")){
                SimpleDatabase db = new SimpleDatabase(getApplicationContext());
                db.deleteMealNote(id);
                Toast.makeText(getApplicationContext(),"Note Deleted",Toast.LENGTH_SHORT).show();
            }
            goToMain();
        }
        return super.onOptionsItemSelected(item);
    }

    private void goToMain() {
        Intent i = new Intent(this,LogActivity.class);
        startActivity(i);
        finish();
    }
}