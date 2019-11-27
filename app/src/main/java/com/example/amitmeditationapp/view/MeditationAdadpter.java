package com.example.amitmeditationapp.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amitmeditationapp.MeditationActivity;
import com.example.amitmeditationapp.model.MeditationTypeModel;
import com.example.amitmeditationapp.R;

import java.util.List;

public class MeditationAdadpter extends RecyclerView.Adapter<MeditationAdadpter.MViewHolder> {

    public AppCompatTextView appCompatTextView;
    public CardView mcardView;
    List<MeditationTypeModel> meditationTypeList;
    Context context;
    private String[] mediTypes;
    private int[] backgroundColor;

    public MeditationAdadpter(List<MeditationTypeModel> meditationTypeList, Context context) {
        this.meditationTypeList = meditationTypeList;
        this.context = context;
    }

    @NonNull
    @Override
    public MViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View meditationView = inflater.inflate(R.layout.activity_main, parent, false);

        MViewHolder viewHolder = new MViewHolder(meditationView);
        return viewHolder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final MViewHolder viewHolder, int position) {

        MeditationTypeModel model = meditationTypeList.get(position);
//        String medTypes = mediTypes[position];
//        int backColor = backgroundColor[position];


        appCompatTextView.setText(model.getMeditationTypes());
        mcardView.setBackgroundColor(model.getBackgroundColor());
        mcardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewHolder.itemView.getContext(), MeditationActivity.class);
                viewHolder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return meditationTypeList.size();
    }


    public class MViewHolder extends RecyclerView.ViewHolder{

        public MViewHolder(@NonNull View itemView) {
            super(itemView);

            appCompatTextView = (AppCompatTextView) itemView.findViewById(R.id.text_view);
            mcardView = (CardView) itemView.findViewById(R.id.card_view);


        }
    }
}
