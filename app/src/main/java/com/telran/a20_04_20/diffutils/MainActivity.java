package com.telran.a20_04_20.diffutils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.telran.a20_04_20.Contact;
import com.telran.a20_04_20.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.myRv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter = new MyAdapter();
        rv.setAdapter(adapter);

        findViewById(R.id.getBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Contact> list = new ArrayList<>();
                list.add(new Contact("1","Vasya","55555"));
                list.add(new Contact("2","Petya","12345"));
                list.add(new Contact("3","Sima","12345"));
                list.add(new Contact("4","David","12345"));
                list.add(new Contact("5","Anna","12345"));
                adapter.changeData(list);
            }
        });
    }
}
