package com.blogspot.atifsoftwares.stayfit;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterMeal extends RecyclerView.Adapter<AdapterMeal.ViewHolder>{
    private LayoutInflater inflater;
    private List<Note> notes;

    AdapterMeal(Context context, List<Note> notes){
        this.inflater = LayoutInflater.from(context);
        this.notes = notes;
    }
    @NonNull
    @Override
    public AdapterMeal.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lyt_log_meal_view,parent,false);
        return new AdapterMeal.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMeal.ViewHolder holder, int position) {
        String  title    = notes.get(position).getTitle();
        String  date     = notes.get(position).getDate();
        String  time     = notes.get(position).getTime();
        long    id       = notes.get(position).getId();
        Log.d("date on ", "Date on: "+date);

        holder.nTitle.setText(title);
        holder.nDate.setText(date);
        holder.nTime.setText(time);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nTitle,nDate,nTime,nID;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nTitle  = itemView.findViewById(R.id.noteTitelView);
            nDate   = itemView.findViewById(R.id.noteDateView);
            nTime   = itemView.findViewById(R.id.noteTimeView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),DetailActivity.class);
                    i.putExtra("ID",notes.get(getAdapterPosition()).getId());
                    i.putExtra("from","meal");
                    v.getContext().startActivity(i);
                    Log.d("TESt", "MEal clockrd");
                }
            });
        }
    }
}
