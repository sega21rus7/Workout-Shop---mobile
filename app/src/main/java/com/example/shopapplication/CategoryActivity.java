package com.example.shopapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class CategoryActivity extends MainActivity {

    ListView listView;
    TextView textView;
    //Переменная для работы с БД
    private DBHelper dbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Bundle arguments = getIntent().getExtras();
        String categoryName = arguments.get("categoryName").toString();    // имя категории

        listView = findViewById(R.id.listView);
        textView = findViewById(R.id.textView0);
        dbHelper = new DBHelper(this);

        try {
            dbHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            db = dbHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }

        ArrayList<String> product = new ArrayList<>();
        int i = 0;
        Cursor cursor =
                db.rawQuery("SELECT * FROM [subcategories] WHERE categoryName = '" + categoryName + "'"
                        , null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            product.add(cursor.getString(1));
            cursor.moveToNext();
        }
        cursor.close();
        ListAdapter adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, product);
        listView.setAdapter(adapter);
        textView.setText(categoryName);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString(); // получаем текст нажатого элемента
                // создание объекта Intent для запуска SecondActivity
                Intent intent = new Intent(CategoryActivity.this, GoodsActivity.class);
                // передача объекта с ключом "categoryName" и значением
                intent.putExtra("categoryName", strText);
                // запуск SecondActivity
                startActivity(intent);
            }
        });
    }
}
