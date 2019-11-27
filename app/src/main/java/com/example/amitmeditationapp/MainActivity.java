package com.example.amitmeditationapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amitmeditationapp.model.MeditationTypeModel;
import com.example.amitmeditationapp.view.MeditationAdadpter;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<MeditationTypeModel> meditationTypeList;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meditation_recycler_view);
        int[] backgroundColor = {getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimaryDark),
                getResources().getColor(R.color.last_card_color)};
        String[] meditationTypes = {getString(R.string.meditation),
                getString(R.string.calm_down), getString(R.string.destress),
                getString(R.string.relax)};

        meditationTypeList = new ArrayList<>();
        for(int i = 0; i<4; i++){
            meditationTypeList.add(new MeditationTypeModel(meditationTypes[i], backgroundColor[i]));
        }

        RecyclerView medTypes = (RecyclerView) findViewById(R.id.recycler_view);
        MeditationAdadpter adadpter = new MeditationAdadpter(meditationTypeList, getApplicationContext());

        medTypes.setAdapter(adadpter);
        medTypes.setLayoutManager(new LinearLayoutManager(this));

//        db = FirebaseFirestore.getInstance();
//        db.collection("meditation").get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                if(!queryDocumentSnapshots.isEmpty()){
//                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
//
//                }
//            }
//        });
    }
}
