package com.app.vpgroup.memopad_luutrukhoanhkhac;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnNew;
    ListView listView;
    ArrayList<MemoPad> mangMemoPad;
    AdapterMemoPad adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddControl();

        mangMemoPad.add(new MemoPad("Noi nho mua dong", "anh nho em mot mua dong lanh guia"));
        mangMemoPad.add(new MemoPad("Noi nho mua dong", "anh nho em mot mua dong lanh guia"));
        mangMemoPad.add(new MemoPad("Noi nho mua dong", "anh nho em mot mua dong lanh guia"));
        mangMemoPad.add(new MemoPad("Noi nho mua dong", "anh nho em mot mua dong lanh guia"));
        mangMemoPad.add(new MemoPad("Noi nho mua dong", "anh nho em mot mua dong lanh guia"));
        mangMemoPad.add(new MemoPad("Noi nho mua dong", "anh nho em mot mua dong lanh guia"));
        mangMemoPad.add(new MemoPad("Noi nho mua dong", "anh nho em mot mua dong lanh guia"));
        mangMemoPad.add(new MemoPad("Noi nho mua dong", "anh nho em mot mua dong lanh guia"));
        mangMemoPad.add(new MemoPad("Noi nho mua dong", "anh nho em mot mua dong lanh guia"));
        mangMemoPad.add(new MemoPad("Noi nho mua dong", "anh nho em mot mua dong lanh guia"));
        mangMemoPad.add(new MemoPad("Noi nho mua dong", "anh nho em mot mua dong lanh guia"));
        mangMemoPad.add(new MemoPad("Noi nho mua dong", "anh nho em mot mua dong lanh guia"));
        mangMemoPad.add(new MemoPad("Noi nho mua dong", "anh nho em mot mua dong lanh guia"));
        mangMemoPad.add(new MemoPad("Noi nho mua dong", "anh nho em mot mua dong lanh guia"));
        mangMemoPad.add(new MemoPad("Noi nho mua dong", "anh nho em mot mua dong lanh guia"));

        adapter = new AdapterMemoPad(MainActivity.this, R.layout.dong_ghi_chu, mangMemoPad);
        listView.setAdapter(adapter);

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return false;
            }
        });
    }

    private void AddControl(){
        btnNew = (Button) findViewById(R.id.btnNew);
        listView = (ListView) findViewById(R.id.listView);
        mangMemoPad = new ArrayList<>();
    }
}
