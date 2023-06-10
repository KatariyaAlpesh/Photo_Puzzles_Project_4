package com.example.photopuzzlesproject_4.Adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photopuzzlesproject_4.Activity.MainActivity;
import com.example.photopuzzlesproject_4.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class First_My_Adapter extends RecyclerView.Adapter<First_My_Adapter.myclass>
{
    MainActivity mainActivity;
    List<String> arrayListImage;
    public First_My_Adapter(MainActivity mainActivity, List<String> arrayListImage)
    {
        this.arrayListImage = arrayListImage;
        this.mainActivity = mainActivity;

    }

    class myclass extends RecyclerView.ViewHolder
    {
        ImageView imageView;

        public myclass(@NonNull View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.RecyclerBackgroundImage);

        }
    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View Cview = LayoutInflater.from(mainActivity).inflate(R.layout.first_recycler_imagepage_background, parent , false);

        myclass m = new myclass(Cview);

        return m;
    }

    @Override
    public void onBindViewHolder(@NonNull First_My_Adapter.myclass holder, int position)
    {

        InputStream inputStream = null;

        try {

            inputStream = mainActivity.getAssets().open("BackgroundPhotos/" + arrayListImage.get(position));
            Drawable drawable = Drawable.createFromStream(inputStream , null);

            holder.imageView.setImageDrawable(drawable);

        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int getItemCount()
    {
        return 98;
    }
}
