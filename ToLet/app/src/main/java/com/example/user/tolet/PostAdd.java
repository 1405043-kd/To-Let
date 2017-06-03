package com.example.user.tolet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import static com.example.user.tolet.R.layout.activity_main;

public class PostAdd extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.user.tolet";
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    TextView textView;
    Button imb;
    Switch aSwitch;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_add);
        editText1=(EditText) findViewById(R.id.houseNO);
        editText2=(EditText) findViewById(R.id.road);
        editText3=(EditText) findViewById(R.id.Thana);
        editText4=(EditText) findViewById(R.id.district);
        editText5=(EditText) findViewById(R.id.postAddress);
        editText6=(EditText) findViewById(R.id.contactNo);
        textView=(TextView) findViewById(R.id.currState);
        imb=(Button)findViewById(R.id.postButton);
        aSwitch=(Switch) findViewById(R.id.switcha);

    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.houseNO);
        String message = editText.getText().toString();
        editText = (EditText) findViewById(R.id.road);
        message+=", "+editText.getText().toString();
        editText = (EditText) findViewById(R.id.Thana);
        message+=" "+editText.getText().toString();
        editText = (EditText) findViewById(R.id.district);
        message+=", "+editText.getText().toString();
        editText = (EditText) findViewById(R.id.postAddress);
        message+="- "+editText.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}
