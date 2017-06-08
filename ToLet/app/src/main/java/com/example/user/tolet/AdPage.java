package com.example.user.tolet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.user.tolet.PostAdd.dbH;

public class AdPage extends AppCompatActivity {
    TextView textView1;
    ImageView imageView;
    TaskItem taskItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_page);

        textView1=(TextView)findViewById(R.id.details);
        imageView=(ImageView)findViewById(R.id.imageView2);
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
        //imageView.setImageBitmap(taskItem.bitmap);
       // BitmapDrawable bitmapDrawable = new BitmapDrawable(taskItem.bitmap);

       // imageView.setImageDrawable(d);
        if(taskItem.byteImage!=null) {
            Bitmap bmp = BitmapFactory.decodeByteArray(taskItem.byteImage, 0, taskItem.byteImage.length);
            imageView.setImageBitmap(Bitmap.createScaledBitmap(bmp, imageView.getWidth(),
                    imageView.getHeight(), false));
        }
            //  imageView.setImageURI(taskItem.imageArray.get(1));
      //  if(taskItem.imageArray.get(0)!=null)
         //   imageView.setImageURI(Uri.parse(taskItem.imageArray.get(0)));
    }
}
