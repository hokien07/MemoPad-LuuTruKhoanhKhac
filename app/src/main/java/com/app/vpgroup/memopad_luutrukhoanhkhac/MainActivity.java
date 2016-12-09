package com.app.vpgroup.memopad_luutrukhoanhkhac;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    final String DATABASE_NAME = "MemoPad.sqlite";
    SQLiteDatabase databas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AddControl();
        ReadData();





    }

    private void AddControl(){
        btnNew = (Button) findViewById(R.id.btnNew);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(intent);
            }
        });

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
                intent.putExtra("ID",mangMemoPad.get(i).id);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return false;
            }
        });


        mangMemoPad = new ArrayList<>();
        adapter = new AdapterMemoPad(MainActivity.this, R.layout.dong_ghi_chu, mangMemoPad);
        listView.setAdapter(adapter);
    }

    private void ReadData(){
        databas = Database.initDatabase(MainActivity.this, DATABASE_NAME);
        Cursor cursor = databas.rawQuery("SELECT * FROM MemoPad_info", null);
        mangMemoPad.clear();

        for(int i = 0; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String content = cursor.getString(2);

            mangMemoPad.add(new MemoPad(id, title, content));
        }
        adapter.notifyDataSetChanged();
    }
}
