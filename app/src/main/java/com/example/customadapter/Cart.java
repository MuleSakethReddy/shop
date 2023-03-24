package com.example.customadapter;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class Cart extends Activity {
    ListView simpleList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cart_layout);
        Log.d("First", "Here");

        ArrayList<String> cartItems = getIntent().getStringArrayListExtra("addedItems");
        ArrayList<Integer> cartImages = getIntent().getIntegerArrayListExtra("addedImages");
        simpleList = findViewById(R.id.cartList);
        Log.d("Second", "Here");

        CartCustomAdapter customAdapter = new CartCustomAdapter(getApplicationContext(), cartItems, cartImages);
        simpleList.setAdapter(customAdapter);
    }
}

