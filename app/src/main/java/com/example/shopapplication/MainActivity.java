package com.example.shopapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton logoButton = findViewById(R.id.logoButton);
        ImageButton phoneNumberButton = findViewById(R.id.phoneNumberButton);
        ImageButton yandexButton = findViewById(R.id.yandexButton);
        ImageButton vkButton = findViewById(R.id.vkButton);
        ImageButton facebookButton = findViewById(R.id.facebookButton);
        ImageButton instagramButton = findViewById(R.id.instagramButton);
        ImageButton youtubeButton = findViewById(R.id.youtubeButton);

        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://workoutshop.ru")));
            }
        });

        phoneNumberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:+74997030585")));
            }
        });

        yandexButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(
                        Uri.parse("https://market.yandex.ru/shop--magazin-workout/136051/reviews")));
            }
        });

        vkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("https://vk.com/workoutshop")));
            }
        });

        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(
                        Uri.parse("https://www.facebook.com/workoutshop.ru")));
            }
        });

        instagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(
                        Uri.parse("https://www.instagram.com/workoutshop.ru/")));
            }
        });

        youtubeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW).setData(
                        Uri.parse("https://www.youtube.com/channel/UCYMk3REfguhlEUZH_cnAjSQ")));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;
        switch(id){
            case R.id.action_main_page:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.action_katalog:
                intent = new Intent(this, CatalogActivity.class);
                startActivity(intent);
                break;
            case R.id.action_delivery:
                intent = new Intent(this, DeliveryActivity.class);
                startActivity(intent);
                break;
            case R.id.action_payment:
                intent = new Intent(this, PaymentActivity.class);
                startActivity(intent);
                break;
            case R.id.action_shop_in_moscow:
                intent = new Intent(this, ShopInMoscowActivity.class);
                startActivity(intent);
                break;
            case R.id.action_contacts:
                intent = new Intent(this, ContactsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}
