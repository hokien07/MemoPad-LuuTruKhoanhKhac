package com.app.vpgroup.memopad_luutrukhoanhkhac;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        // nếu btnAdd được click
        if (id == R.id.btnAdd) {
            //đến màng hình ProductActivity
            Intent intent = new Intent(this, NewActivity.class);
            //tham số -1 tức ta không truyền 1 position của item nào cả
            //ta mở ProductActivity để thêm sp mới
//            intent.putExtra(NewActivity.EXTRA_POSITION, -1);
            startActivityForResult(intent, 0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void AddControl(){
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

                AlertDialog.Builder alerDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                alerDialogBuilder.setMessage("Bạn có muốn xóa ghi chú này?");
                alerDialogBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mangMemoPad.remove(i);
                        adapter.notifyDataSetChanged();
                    }
                });
                alerDialogBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alerDialogBuilder.show();
                return true;
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
