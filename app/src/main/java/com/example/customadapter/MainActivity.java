package com.example.customadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView simpleList;
    String[] countryList = {"India", "China", "australia"};
    int[] flags = {R.drawable.india, R.drawable.china, R.drawable.australia};
    CustomAdapter globalCustomAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_main);
        simpleList = (ListView) findViewById(R.id.itemsList);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), countryList, flags);
        simpleList.setAdapter(customAdapter);
        globalCustomAdapter = customAdapter;
    }

    public void cart(View view)
    {
        Log.d("Added+++++++", globalCustomAdapter.getAddedItems().toString());
        ArrayList<String> addedItems = globalCustomAdapter.getAddedItems();
        ArrayList<Integer> addedImages = globalCustomAdapter.getAddedImages();
        Intent intent = new Intent(MainActivity.this, Cart.class);
        intent.putStringArrayListExtra("addedItems", addedItems);
        intent.putIntegerArrayListExtra("addedImages", addedImages);
        startActivity(intent);
    }
}
