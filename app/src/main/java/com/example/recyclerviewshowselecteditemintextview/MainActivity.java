package com.example.recyclerviewshowselecteditemintextview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.RecyclerViewCallBacks {

    RecyclerView recyclerView;
    TextView tvSelectedItem;
    ArrayList<ModelClass> arrayList = new ArrayList<>();
    String[] data = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        tvSelectedItem = findViewById(R.id.tvSelectedItem);

        MyAdapter myAdapter = new MyAdapter(this, getData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(myAdapter);
    }

    private ArrayList<ModelClass> getData() {
        for (int i = 0; i < data.length; i++) {
            arrayList.add(new ModelClass(data[i]));
        }
        return arrayList;
    }

    @Override
    public void onRecyclerviewItemSelected(String item) {
        tvSelectedItem.setText("Selected Item: " + item);
        Toast.makeText(this, item, Toast.LENGTH_SHORT).show();
    }
}