package com.example.hiroki.listviewproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = findViewById(R.id.list_item);
        List<String> menuList = new ArrayList<>();
        menuList.add("唐揚げ定食");
        menuList.add("チキン南蛮定食");
        menuList.add("生姜焼き定食");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,menuList);
        list.setAdapter(arrayAdapter);
        ListListener listener = new ListListener();
        list.setOnItemClickListener(listener);
    }

    private class ListListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String order = (String)parent.getItemAtPosition(position);
            TextView text = findViewById(R.id.output);
            text.setText(order + "食べたい！！");
        }
    }

}
