package com.app.vpgroup.memopad_luutrukhoanhkhac;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class NewActivity extends AppCompatActivity {
    final String DATABASE_NAME = "MemoPad.sqlite";
    EditText edtTitle, edtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        AddControl();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.btnSaveNew){
            MemoPad memoPad = new MemoPad(0, edtTitle.getText().toString(), edtContent.getText().toString());
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("ID", memoPad.id);
            setResult(100, intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void AddControl(){
        edtTitle = (EditText) findViewById(R.id.edtTitleNew);
        edtContent = (EditText) findViewById(R.id.edtNewContent);
    }
}
