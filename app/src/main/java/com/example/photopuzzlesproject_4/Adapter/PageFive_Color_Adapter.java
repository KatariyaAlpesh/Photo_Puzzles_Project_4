package com.example.photopuzzlesproject_4.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.photopuzzlesproject_4.Activity.MainActivity5;
import com.example.photopuzzlesproject_4.R;
import com.example.photopuzzlesproject_4.config;

public class PageFive_Color_Adapter extends BaseAdapter
{

    MainActivity5 mainActivity5;
    public PageFive_Color_Adapter(MainActivity5 mainActivity5)
    {
        this.mainActivity5 = mainActivity5;
    }

    @Override
    public int getCount()
    {
        return  config.colorArray.length;
    }

    @Override
    public Object getItem(int i)
    {
        return i;
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {

        view = LayoutInflater.from(mainActivity5).inflate(R.layout.third_color_dialogbox_item , viewGroup , false);

        TextView textView = view.findViewById(R.id.colorDialogGridItemText);

        textView.setBackgroundResource(config.colorArray[i]);

        return view;
    }
}
