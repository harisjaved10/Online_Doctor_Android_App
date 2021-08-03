package com.example.online_doctor_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {

        private ArrayList<All_doctors_data> doctors;
        ItemClicked activity;

        public interface ItemClicked
        {
            void onItemClicked(int index);
        }

        public DoctorAdapter (Context context, ArrayList<All_doctors_data> list)
        {
            doctors = list;
            activity = (ItemClicked) context;
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {

            ImageView doc_pic;
            TextView doc_name, doc_degree;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                doc_pic = itemView.findViewById(R.id.doc_pic);
                doc_name = itemView.findViewById(R.id.doc_name);
                doc_degree = itemView.findViewById(R.id.doc_degree);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        activity.onItemClicked(doctors.indexOf((All_doctors_data) view.getTag()));

                    }
                });
            }
        }

    @NonNull
    @Override
    public DoctorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

            viewHolder.itemView.setTag(doctors.get(i));

            viewHolder.doc_name.setText(doctors.get(i).getName());
            viewHolder.doc_degree.setText(doctors.get(i).getDegree());
            viewHolder.doc_pic.setImageResource(R.drawable.doc);

    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }
}
