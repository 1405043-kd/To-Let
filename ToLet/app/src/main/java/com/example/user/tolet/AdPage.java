package com.example.user.tolet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AdPage extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TaskItem taskItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_page);

        textView1=(TextView)findViewById(R.id.details);

        //textView2=(TextView)findViewById(R.id.textView4);

        Intent intent = getIntent();
        taskItem=(TaskItem)intent.getSerializableExtra("postObject");
        //textView2.setText("eijonnoi");
        String whatToShow="";
        if(taskItem.getHouseNo()!=null)
            whatToShow+=taskItem.getHouseNo()+"\n";
        if(taskItem.getRoadNo()!=null)
            whatToShow+=taskItem.getRoadNo()+"\n";
        if(taskItem.getThana()!=null)
            whatToShow+=taskItem.getThana()+"\n";
        if(taskItem.getDistrict()!=null)
            whatToShow+=taskItem.getDistrict()+"\n";
        if(taskItem.getPostAddress()!=null)
            whatToShow+=taskItem.getPostAddress()+"\n";
        if(taskItem.getContactNo()!=null)
            whatToShow+=taskItem.getContactNo()+"\n";
        if(taskItem.getIsBachelor()!=null)
            whatToShow+=taskItem.getIsBachelor();
        textView1.setText(whatToShow);
    }
}
