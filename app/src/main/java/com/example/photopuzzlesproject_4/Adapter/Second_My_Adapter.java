package com.example.photopuzzlesproject_4.Adapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photopuzzlesproject_4.Activity.MainActivity2;
import com.example.photopuzzlesproject_4.Activity.MainActivity3;
import com.example.photopuzzlesproject_4.R;
import com.example.photopuzzlesproject_4.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Second_My_Adapter extends RecyclerView.Adapter<Second_My_Adapter.myclass>
{

    MainActivity2 mainActivity2;
   ArrayList<String> imageArrayList;

    public Second_My_Adapter(MainActivity2 mainActivity2 , ArrayList<String> imageArrayList)
    {

        this.mainActivity2 = mainActivity2;
        this.imageArrayList = imageArrayList;

    }

    class myclass extends RecyclerView.ViewHolder
    {
        TextView textView;
        ImageView imageView;

        public myclass(@NonNull View itemView)
        {
            super(itemView);

            textView = itemView.findViewById(R.id.TextData);
            imageView = itemView.findViewById(R.id.ImageData);

        }
    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View Cview = LayoutInflater.from(mainActivity2).inflate(R.layout.secondpage_recyclerview_image_page, parent , false);

        myclass m = new myclass(Cview);

        return m;
    }

    @Override
    public void onBindViewHolder(@NonNull myclass holder, int position)
    {

        InputStream inputStream;

        try {

            inputStream = mainActivity2.getAssets().open("Photos/" + imageArrayList.get(position));
            Drawable drawable = Drawable.createFromStream(inputStream , null);
            holder.imageView.setImageDrawable(drawable);

            holder.textView.setText(config.namePositionArray[position]);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        holder.itemView.setOnClickListener(v -> {

            Intent Inext;
            Inext = new Intent(mainActivity2 , MainActivity3.class);
            Inext.putExtra("clickedImagePosition" , position);
            Inext.putExtra("arrayListNameImage" , imageArrayList);
            mainActivity2.startActivity(Inext);

        });


//
//        String url = String.valueOf(imageArray[position]);
//
//        Glide.with(mainActivity2)
//                .load(url)
//                .centerCrop()
//                .placeholder(R.mipmap.ic_launcher)
//                .into(holder.imageView);

    }

    @Override
    public int getItemCount()
    {
        return config.namePositionArray.length;
    }
}
