package com.example.project3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btnPopuler,btnTrending;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPopuler = (Button)findViewById(R.id.btnPopuler);
        btnTrending = (Button)findViewById(R.id.btnTrending);
        btnPopuler.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPopuler :
                Intent intent = new Intent(MainActivity.this, PopulerActivity.class);
                startActivity(intent);
                break;
            case R.id.btnTrending :
                Intent intent2 = new Intent(MainActivity.this, TrendingActivity.class);
                startActivity(intent2);
                break;
        }

    }
}
