package com.example.photopuzzlesproject_4.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.photopuzzlesproject_4.Adapter.First_My_Adapter;
import com.example.photopuzzlesproject_4.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity
{


    LinearLayout llayoutOpenPhotos , llayoutAppPhotos;
    RecyclerView recyclerView;

    ImageButton firstPageVolumeImage , firstPageRateImage , firstPageShareImage;
    ArrayList<String> arrayListImage;


    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerViewMain);
        llayoutOpenPhotos = findViewById(R.id.llayoutOpenPhotos);
        llayoutAppPhotos = findViewById(R.id.llayoutAppPhotos);
        firstPageRateImage = findViewById(R.id.firstPageRateImage);
        firstPageShareImage = findViewById(R.id.firstPageShareImage);
        firstPageVolumeImage = findViewById(R.id.firstPageVolumeImage);


  ///////////////////----->>   This Activity for get Image from Assets Folder     <<-----///////////////////////////////////


        try {

            String[] image = getAssets().list("BackgroundPhotos");
            arrayListImage = new ArrayList<>(Arrays.asList(image));

    /////////////---->> This is forIncrease the Images for Background    ===   7  = 14 = 28 = 56 = 112  like this    ///////////////

            arrayListImage.addAll(arrayListImage);
            arrayListImage.addAll(arrayListImage);
            arrayListImage.addAll(arrayListImage);
            arrayListImage.addAll(arrayListImage);
            arrayListImage.addAll(arrayListImage);

            Collections.shuffle(arrayListImage);

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }


        First_My_Adapter recyclerViewMain_adapter = new First_My_Adapter(this , arrayListImage);
        recyclerView.setAdapter(recyclerViewMain_adapter);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this , 7 ,RecyclerView.VERTICAL , false);
        recyclerView.setLayoutManager(gridLayoutManager);


 ////////////----->>>    Intent for Clicked in AppPhotos And Open All Photos Page Like A MainActivity-2     <<<<------////////////////////


        llayoutAppPhotos.setOnClickListener(view -> {

            Intent Inext;
            Inext = new Intent(MainActivity.this , MainActivity2.class);
            startActivity(Inext);

        });


///////////////----->>>>   Intent for Clicked in Openhotos And Open All Photos Page Like MainActivity-4    <<<------///////////

        llayoutOpenPhotos.setOnClickListener(view -> {

            Intent Inext;
            Inext = new Intent(MainActivity.this , MainActivity4.class);
            startActivity(Inext);

        });

    }
}