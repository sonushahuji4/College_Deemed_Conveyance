package com.deemedconveyance.deemconveyanceversionone.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.deemedconveyance.deemconveyanceversionone.R;

import java.util.ArrayList;

public class ShowResourceContent extends AppCompatActivity
{
    private ImageView resouce_data;
    String item;
    //ArrayList<String> obj;
    ArrayList<Integer> obj = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_resource_content);
        resouce_data = (ImageView) findViewById(R.id.resouce_data);



        obj.add(R.drawable.one);
        obj.add(R.drawable.two);
        obj.add(R.drawable.three);
        obj.add(R.drawable.four);

        obj.add(R.drawable.five);
        obj.add(R.drawable.six);
        obj.add(R.drawable.seven);
        obj.add(R.drawable.eight);

        obj.add(R.drawable.nine);
        obj.add(R.drawable.ten);
        obj.add(R.drawable.eleven);
        obj.add(R.drawable.twelve);
        obj.add(R.drawable.thirteen);




        try {
            Bundle extras = getIntent().getExtras();
            item = extras.getString("item");
            Integer result = Integer.valueOf(item);
            Integer str= obj.get(result);
            resouce_data.setImageResource(str);
        }
        catch (Exception e){

        }
    }
}
