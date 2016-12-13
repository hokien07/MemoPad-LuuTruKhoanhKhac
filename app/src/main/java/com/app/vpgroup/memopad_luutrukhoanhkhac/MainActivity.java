package com.app.vpgroup.memopad_luutrukhoanhkhac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtFind;
    ListView lv;
    Button btnAdd;
    ArrayList<MemoPad> mangMemoPad;
    MemoPadAdapter adapter = null;

    MemoPadModify memoPadModify;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControl();
        display();

    }

    public void display(){
        adapter = new MemoPadAdapter(this, memoPadModify.GetMemoPadList(), true);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    private void AddControl() {
        edtFind = (EditText) findViewById(R.id.edtFind);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        lv = (ListView) findViewById(R.id.lisView);
        memoPadModify = new MemoPadModify(this);
        mangMemoPad = new ArrayList<MemoPad>();
    }
}

