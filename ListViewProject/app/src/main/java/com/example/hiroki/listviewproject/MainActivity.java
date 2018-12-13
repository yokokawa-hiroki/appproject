package com.example.hiroki.listviewproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    ListView list;
    List<Map<String, Object>> menuList;
    String[] from = new String[]{"name", "price", "desc"};
    int[] to = new int[]{R.id.menu, R.id.price, R.id.desc};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.list_item);
        menuList = createList();

        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this, menuList,R.layout.row_list,from, to);
        list.setAdapter(simpleAdapter);

        ListListener listener = new ListListener();
        list.setOnItemClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.common:
                menuList = createList();
                break;

            case R.id.secret:
                menuList = createSecretList();
                break;
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this,menuList,R.layout.row_list, from, to);
        list.setAdapter(simpleAdapter);

        return super.onOptionsItemSelected(item);
    }

    private List<Map<String,Object>> createList(){
        List<Map<String,Object>> menuList = new ArrayList<>();
        Map<String, Object> menu = new HashMap<>();
        menu.put("name" , "カレーライス");
        menu.put("price", 600);
        menu.put("desc", "じっくりコトコト");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name" , "オムライス");
        menu.put("price", 450);
        menu.put("desc", "ふわふわ玉子");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name" , "肉まん");
        menu.put("price", 250);
        menu.put("desc", "ジューシー肉汁");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name" , "唐揚げ");
        menu.put("price", 300);
        menu.put("desc", "カリカリ衣");
        menuList.add(menu);

        return menuList;
    }


    private List<Map<String,Object>> createSecretList(){
        List<Map<String,Object>> menuList = new ArrayList<>();
        Map<String, Object> menu = new HashMap<>();
        menu.put("name" , "カレーチャーハン");
        menu.put("price", 600);
        menu.put("desc", "本格秘伝のタレ使用");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("name" , "イクラまん");
        menu.put("price", 350);
        menu.put("desc", "新触感！外ふわふわ中プチプチ");
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
