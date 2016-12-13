package com.app.vpgroup.memopad_luutrukhoanhkhac;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtFind;
    ListView lv;
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
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.btnAdd){
            final Dialog dialog = new Dialog(this);
            dialog.setTitle("Ghi Chú Mới");
            dialog.setContentView(R.layout.show_dialog);
            final EditText edtTitle, edtContent;
            Button btnThem, btnHuy;

            edtTitle = (EditText) dialog.findViewById(R.id.edtTitleNew);
            edtContent = (EditText) dialog.findViewById(R.id.edtContentNew);
            btnThem = (Button) dialog.findViewById(R.id.btnThemNew);
            btnHuy = (Button) dialog.findViewById(R.id.btnCapNhatNew);

           btnHuy.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   dialog.dismiss();
               }
           });

            btnThem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MemoPad memoPad = new MemoPad(edtTitle.getText().toString(), edtContent.getText().toString());
                    memoPadModify.insert(memoPad);
                    display();
                    dialog.dismiss();
                }
            });
            dialog.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void AddControl() {
        edtFind = (EditText) findViewById(R.id.edtFind);
        lv = (ListView) findViewById(R.id.lisView);
        memoPadModify = new MemoPadModify(this);
        mangMemoPad = new ArrayList<MemoPad>();
    }
}

