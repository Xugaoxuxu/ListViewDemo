package com.example.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ListView lv;
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化数据
        initFruits();
        lv = (ListView) findViewById(R.id.lv);
        //第一个参数为上下文，第二个参数为一个包含TextView，用来填充ListView的每一行的布局资源ID。第三个参数为ListView的内容。
        // 其中第二个参数可以自定义一个layout，但是这个layout必须要有TextView控件。
        // 通常我们使用Android提供的资源，除了例子中所用的，常用的还有如下几种，可实现带RadioButton和CheckBox的ListView。
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fruitList);
        // lv.setAdapter(adapter);
        FruitAdapter adapter = new FruitAdapter(this, R.layout.fruit_item, fruitList);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        for (int i = 0; i < 20; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.ic_launcher);
            fruitList.add(apple);
        }
    }
}
