package com.example.notetaking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter  extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
private List<Note> noteList=new ArrayList<>();
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item,parent,false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote=noteList.get(position);
        holder.titleTV.setText(currentNote.getTitle());
        holder.descriptionTv.setText(currentNote.getDescription());
        holder.priorityTv.setText(String.valueOf(currentNote.getPriority()));
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }
    public void setNotes(List<Note> notes){
        this.noteList=notes;
       notifyDataSetChanged();
    }



    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView  titleTV,descriptionTv,priorityTv;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            titleTV=itemView.findViewById(R.id.titleTextViewId);
            descriptionTv=itemView.findViewById(R.id.descriptionTextviewId);
            priorityTv=itemView.findViewById(R.id.priorityTextViewId);
        }
    }
}
