package com.example.photopuzzlesproject_4.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photopuzzlesproject_4.Activity.MainActivity5;
import com.example.photopuzzlesproject_4.R;

public class PageFive_Recycler_Adapter extends RecyclerView.Adapter<PageFive_Recycler_Adapter.myclass>
{

    MainActivity5 mainActivity5;

    String ClickImage;
//    Drawable drawable;

    public PageFive_Recycler_Adapter(MainActivity5 mainActivity5 , String ClickImage  )// Drawable drawable)
    {
        this.mainActivity5 = mainActivity5;
        this.ClickImage = ClickImage;

//        this.drawable = drawable;
    }

    class myclass extends RecyclerView.ViewHolder
    {

        ImageView imageView;

        public myclass(@NonNull View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.FivePageShafulImage);

        }
    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View Cview = LayoutInflater.from(mainActivity5).inflate(R.layout.page_five_image_item , parent , false);

        myclass m = new myclass(Cview);

        return m;
    }

    @Override
    public void onBindViewHolder(@NonNull myclass holder, int position)
    {
        for (int i = 0; i < 9; i++)
        {

            if (position == i)
            {

                holder.imageView.setImageURI(Uri.parse(ClickImage));
            }
        }

    }

    @Override
    public int getItemCount()
    {
        return 9;
    }



}
