package com.example.photopuzzlesproject_4.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.photopuzzlesproject_4.Activity.MainActivity3;
import com.example.photopuzzlesproject_4.Activity.MainActivity5;
import com.example.photopuzzlesproject_4.R;
import com.example.photopuzzlesproject_4.config;

public class Third_Color_Adapter extends BaseAdapter
{

    MainActivity3 mainActivity3;

    public Third_Color_Adapter(MainActivity3 mainActivity3)
    {
        this.mainActivity3 = mainActivity3;

    }

    @Override
    public int getCount()
    {
        return config.colorArray.length;
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
        view = LayoutInflater.from(mainActivity3).inflate(R.layout.third_color_dialogbox_item , viewGroup , false);

        TextView textView = view.findViewById(R.id.colorDialogGridItemText);

        textView.setBackgroundResource(config.colorArray[i]);

        return view;
    }

}
