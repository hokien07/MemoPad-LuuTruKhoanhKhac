package com.app.vpgroup.memopad_luutrukhoanhkhac;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    final String DATABASE_NAME = "MemoPad.sqlite";
    EditText edtTitle, edtContent;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        AddControls();
        initUI();


    }
    //lay thong tin cua memopad
    private void initUI() {
        Intent intent = getIntent();
        int id = intent.getIntExtra("ID", -1);
        SQLiteDatabase databas = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = databas.rawQuery("SELECT * FROM MemoPad_info id = ?", new String[]{id + ""});
        cursor.moveToFirst();

        String title = cursor.getString(1);
        String content = cursor.getString(2);

        edtTitle.setText(title);
        edtContent.setText(content);

    }

    private void AddControls(){
        edtTitle = (EditText) findViewById(R.id.edtTitleUpdate);
        edtContent = (EditText) findViewById(R.id.edtContentUpdate);
        btnSave = (Button) findViewById(R.id.btnSaveUpdate);
    }
}
