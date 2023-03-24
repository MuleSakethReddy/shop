package com.example.customadapter;

import static android.support.v4.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CartCustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> namesList;
    ArrayList<Integer> imageList;
    ArrayList<String> addedItems = new ArrayList<>();
    ArrayList<Integer> addedImages = new ArrayList<>();
    LayoutInflater inflater;

    public CartCustomAdapter(Context applicationContext, ArrayList<String> names, ArrayList<Integer> images) {
        this.context = applicationContext;
        this.namesList = names;
        this.imageList = images;
        inflater = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return namesList.size();
    }

    @Override
    public Object getItem(int i) {
        return namesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.cart_elements, null);
        TextView title = (TextView) view.findViewById(R.id.textView);
        ImageView icon = (ImageView) view.findViewById(R.id.imageView);
        Button b = view.findViewById(R.id.addbutton);

        title.setText(namesList.get(i));
        icon.setImageResource(imageList.get(i));
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                namesList.remove(i);
                imageList.remove(i);
                Intent intent = new Intent(viewGroup.getContext(), Cart.class);
                intent.putStringArrayListExtra("addedItems", namesList);
                intent.putIntegerArrayListExtra("addedImages", imageList);
                viewGroup.getContext().startActivity(intent);
            }
        });
        return view;
    }
}

