package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public static List<ShoppingItem> items = new ArrayList<ShoppingItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        System.out.println(items.size());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.shopping_list);
        ShoppingItemAdapter adapter = new ShoppingItemAdapter(this ,items);
        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        Intent intent = new Intent(this, AddItemActivity.class);
        findViewById(R.id.add_item).setOnClickListener(view -> startActivity(intent));

    }
}