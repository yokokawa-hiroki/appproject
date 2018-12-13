package com.example.hiroki.listviewproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnBack = findViewById(R.id.back);
        Button btnOk = findViewById(R.id.ok);
        ClickListener clickListener = new ClickListener();
        btnBack.setOnClickListener(clickListener);
        btnOk.setOnClickListener(clickListener);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String price = intent.getStringExtra("price");

        TextView nameText = findViewById(R.id.menu);
        TextView priceText = findViewById(R.id.price);

        nameText.setText(name);
        priceText.setText(price);

    }

    private class ClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            int id = v.getId();
            switch (id){
                case R.id.ok:
                    Toast.makeText(SecondActivity.this,"注文承りました。", Toast.LENGTH_SHORT).show();

                case R.id.back:
                    finish();
                    break;
            }
        }
    }
}
