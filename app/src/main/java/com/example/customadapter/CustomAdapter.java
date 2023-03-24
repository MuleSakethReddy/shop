package com.example.customadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String namesList[];
    int imageList[];
    ArrayList<String> addedItems = new ArrayList<>();
    ArrayList<Integer> addedImages = new ArrayList<>();
    LayoutInflater inflater;

    public CustomAdapter(Context applicationContext, String[] names, int[] images) {
        this.context = applicationContext;
        this.namesList = names;
        this.imageList = images;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return namesList.length;
    }

    @Override
    public Object getItem(int i) {
        return namesList[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public ArrayList<String> getAddedItems() {
        return addedItems;
    }

    public ArrayList<Integer> getAddedImages() {
        return addedImages;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.customlist_elements, null);
        TextView title = (TextView) view.findViewById(R.id.textView);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        Button b = view.findViewById(R.id.addbutton);

        title.setText(namesList[i]);
        icon.setImageResource(imageList[i]);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addedItems.add(namesList[i]);
                addedImages.add(imageList[i]);
            }
        });
        return view;
    }
}
