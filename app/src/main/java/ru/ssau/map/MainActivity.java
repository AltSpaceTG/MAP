package ru.ssau.map;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.First);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openMap();
                setContentView(R.layout.study1);

            }
        });
    }

    private void openMap() {
        String url = "https://yandex.ru/maps/-/CCUKAHTgSC";
        Intent intentYandex = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intentYandex.setPackage("ru.yandex.yandexmaps");

        String uriGoogle = "https://goo.gl/maps/3NQCj3NxgYujDtso6";
        Intent intentGoogle = new Intent(Intent.ACTION_VIEW, Uri.parse(uriGoogle));
        intentGoogle.setPackage("com.google.android.apps.maps");

        String title = "Select";
        Intent chooserIntent = Intent.createChooser(intentGoogle, title);
        Intent[] arr = new Intent[1];
        arr[0] = intentYandex;
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, arr);
        startActivity(chooserIntent);
    }
}