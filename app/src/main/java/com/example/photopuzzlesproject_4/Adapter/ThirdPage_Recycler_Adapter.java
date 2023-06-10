package com.example.photopuzzlesproject_4.Adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photopuzzlesproject_4.Activity.MainActivity3;
import com.example.photopuzzlesproject_4.R;

public class ThirdPage_Recycler_Adapter extends RecyclerView.Adapter<ThirdPage_Recycler_Adapter.myclass>
{

    MainActivity3 mainActivity3;
    Drawable drawable;

    public ThirdPage_Recycler_Adapter(MainActivity3 mainActivity3, Drawable drawable)
    {
        this.mainActivity3 = mainActivity3;
        this.drawable = drawable;

    }

    class myclass extends RecyclerView.ViewHolder
    {
        ImageView imageView;

        public myclass(@NonNull View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.ThirdPageShafulImage);

        }
    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View Cview = LayoutInflater.from(mainActivity3).inflate(R.layout.page_third_image_item, parent , false);

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

                holder.imageView.setImageDrawable(drawable);
            }

        }
    }

    @Override
    public int getItemCount()
    {
        return 9;
    }
}
