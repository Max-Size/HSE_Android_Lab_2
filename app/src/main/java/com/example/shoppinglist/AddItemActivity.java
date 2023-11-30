package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item_activity);
        EditText editText = findViewById(R.id.edit_text);
        findViewById(R.id.add_item).setOnClickListener(view -> {
            MainActivity.items.add(new ShoppingItem(editText.getText().toString()));
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}