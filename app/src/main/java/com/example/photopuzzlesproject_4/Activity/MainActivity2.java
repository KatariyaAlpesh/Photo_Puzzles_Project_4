package com.example.photopuzzlesproject_4.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.photopuzzlesproject_4.R;
import com.example.photopuzzlesproject_4.Adapter.Second_My_Adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity
{

    RecyclerView recyclerView;

    ArrayList<String> imageArrayList;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.SecondPageRecyclerView);


   ///////////////////----->>   This Activity for get Image from Assets Folder     <<-----///////////////////////////////////

        try {

            String[] imagePosition = getAssets().list("Photos");
            imageArrayList = new ArrayList<>(Arrays.asList(imagePosition));

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }



        Second_My_Adapter second_my_adapter = new Second_My_Adapter(this , imageArrayList );

        recyclerView.setAdapter(second_my_adapter);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this , 3 ,RecyclerView.VERTICAL , false);

        recyclerView.setLayoutManager(gridLayoutManager);


    }
}