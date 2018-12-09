package com.example.hiroki.listviewproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = findViewById(R.id.list_item);
        List<Map<String, Object>> menuList = createList();

        String[] from = new String[]{"name", "price", "desc"};
        int[] to = new int[]{R.id.menu, R.id.price, R.id.desc};

        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this, menuList,R.layout.row_list,from, to);
        list.setAdapter(simpleAdapter);

        ListListener listener = new ListListener();
        list.setOnItemClickListener(listener);
    }

    private List<Map<String,Object>> createList(){
        List<Map<String,Object>> menuList = new ArrayList<>();
        Map<String, Object> menu = new HashMap<>();
        menu.put("name" , "Ice");
        menu.put("price", 600);
        menu.put("desc", "It is so cool");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name" , "Milk tea");
        menu.put("price", 450);
        menu.put("desc", "It is so mild");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name" , "Bred");
        menu.put("price", 550);
        menu.put("desc", "It is so delicious");
        menuList.add(menu);

        return menuList;
    }

    private class ListListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Map<String, Object> item = (Map<String, Object>) parent.getItemAtPosition(position);

            String name = (String)item.get("name");
            Integer price = (Integer) item.get("price");
            String desc = (String) item.get("desc");

            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            intent.putExtra("price", price + "円");
            intent.putExtra("name",name);
            intent.putExtra("desc",desc);

            startActivity(intent);
        }
    }

}
