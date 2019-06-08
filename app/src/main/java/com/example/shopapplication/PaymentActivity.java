package com.example.shopapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class PaymentActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        TextView TV1 = (TextView)findViewById(R.id.textView2);
        TV1.setText(Html.fromHtml(getString(R.string.pay_cash)));
        TextView TV2 = (TextView)findViewById(R.id.textView4);
        TV2.setText(Html.fromHtml(getString(R.string.pay_bank_card)));
        TextView TV3 = (TextView)findViewById(R.id.textView6);
        TV3.setText(Html.fromHtml(getString(R.string.pay_bank_transfer)));
    }
}
