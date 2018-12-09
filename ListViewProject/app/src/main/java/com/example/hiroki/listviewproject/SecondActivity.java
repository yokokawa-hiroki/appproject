package com.example.hiroki.listviewproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button = findViewById(R.id.back);
        ClickListener clickListener = new ClickListener();
        button.setOnClickListener(clickListener);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");
        String desc = intent.getStringExtra("desc");

        TextView nameText = findViewById(R.id.menu);
        TextView priceText = findViewById(R.id.price);
        TextView descText = findViewById(R.id.desc);

        nameText.setText(name);
        priceText.setText(price);
        descText.setText(desc);


    }

    private class ClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            finish();
        }
    }
}
