package com.example.user.tolet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AdPage extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_page);

        textView1=(TextView)findViewById(R.id.textView3);
        textView2=(TextView)findViewById(R.id.textView4);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView2.setText(message);
    }
}
