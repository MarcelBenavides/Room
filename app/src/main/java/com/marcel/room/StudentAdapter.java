package com.marcel.room;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Marcel Benavides on 14/4/18.
 */

class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {


    List<Student> students;
    public StudentAdapter(List<Student> students) {
        this.students = students;

    }

    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StudentAdapter.ViewHolder holder, int position) {
        holder.firstname.setText(students.get(position).getNombre());
        holder.lastname.setText(students.get(position).getApellido());
        holder.carnet.setText(students.get(position).getCarnet());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         TextView firstname;
         TextView lastname;
         TextView carnet;


        public ViewHolder(View itemView) {
            super(itemView);

            firstname = itemView.findViewById(R.id.first_name);
            lastname = itemView.findViewById(R.id.last_name);
            carnet = itemView.findViewById(R.id.carnet);
        }
    }
}
