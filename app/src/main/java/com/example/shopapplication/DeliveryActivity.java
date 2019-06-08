package com.example.shopapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class DeliveryActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        TextView TV1 = (TextView)findViewById(R.id.textView2);
        TV1.setText(Html.fromHtml(getString(R.string.delivery_terms)));
        TextView TV2 = (TextView)findViewById(R.id.textView5);
        TV2.setText(Html.fromHtml(getString(R.string.delivery_by_messenger)));
        TextView TV3 = (TextView)findViewById(R.id.textView7);
        TV3.setText(Html.fromHtml(getString(R.string.customer_collection_point)));
        TextView TV4 = (TextView)findViewById(R.id.textView9);
        TV4.setText(Html.fromHtml(getString(R.string.delivery_by_post_office)));
        TextView TV5 = (TextView)findViewById(R.id.textView11);
        TV5.setText(Html.fromHtml(getString(R.string.delivery_by_transport_company)));
        TextView TV6 = (TextView)findViewById(R.id.textView13);
        TV6.setText(Html.fromHtml(getString(R.string.delivery_to_other_countries)));
        TextView TV7 = (TextView)findViewById(R.id.textView15);
        TV7.setText(Html.fromHtml(getString(R.string.carry_by_yourself)));
        TextView TV8 = (TextView)findViewById(R.id.textView17);
        TV8.setText(Html.fromHtml(getString(R.string.shop_in_moscow)));
    }
}
