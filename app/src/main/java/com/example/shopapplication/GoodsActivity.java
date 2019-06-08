package com.example.shopapplication;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GoodsActivity extends MainActivity {

    ListView listView;
    TextView textView;
    String subcategoryName;
    //Переменная для работы с БД
    private DBHelper dbHelper;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);

        Bundle arguments = getIntent().getExtras();
        subcategoryName = arguments.get("categoryName").toString();    // имя категории

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

        List<Goods> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));
        textView.setText(subcategoryName);
    }

    private  List<Goods> getListData() {

        ArrayList<Goods> list = new ArrayList<>();
        int i = 0;
        Cursor cursor =
                db.rawQuery("SELECT * FROM [goods] WHERE subcategoryName = '" + subcategoryName + "'",
                        null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Goods goods = new Goods(
                    cursor.getString(1),
                 "goods_" + cursor.getString(0),
                    new Integer(cursor.getString(3)));
            //   "goods_" + cursor.getString(0),
            list.add(goods);
            cursor.moveToNext();
        }
        cursor.close();
        return list;
    }
}
