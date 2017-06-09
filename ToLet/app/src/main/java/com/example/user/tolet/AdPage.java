package com.example.user.tolet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

import static com.example.user.tolet.MainActivity.dbH;

public class AdPage extends AppCompatActivity {
    TextView textView1;
    ImageView imageView;
    TaskItem taskItem;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_page);
        button=(Button)findViewById(R.id.btn);
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
         //   if(taskItem.getByteImage()!=null)
          //      Bitmap bmp = BitmapFactory.decodeByteArray(taskItem.byteImage, 0, taskItem.byteImage.length);
         //    imageView.setImageBitmap(Bitmap.createScaledBitmap(taskItem.byteImage, imageView.getWidth(),
          //      imageView.getHeight(), false));
//
            //  imageView.setImageURI(taskItem.imageArray.get(1));
      //  if(taskItem.imageArray.get(0)!=null)
        Uri imageUri;
        if(taskItem.getImageUri()!=null){
            imageUri=Uri.parse(taskItem.getImageUri());
            imageView.setImageURI(imageUri);
        }

    }
    public void sendPage(View view) {

        //setContentView(R.layout.activity_post_add);
       // Toast.makeText(getApplicationContext(),"বাড়িওয়ালাকে জানানো হল",Toast.LENGTH_LONG);
        Intent intent=new Intent(this,MainActivity.class);
        TextView textView;
        startActivity(intent);
        Toast.makeText(getApplicationContext(),"বাড়িওয়ালাকে জানানো হল",Toast.LENGTH_LONG).show();
        //   adapter.notifyDataSetChanged();
    }
}
