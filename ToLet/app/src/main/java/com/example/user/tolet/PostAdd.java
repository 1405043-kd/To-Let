package com.example.user.tolet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import java.io.Serializable;

import static com.example.user.tolet.R.layout.activity_main;
import static com.example.user.tolet.R.layout.task_row;

public class PostAdd extends AppCompatActivity {
    public static final int RESULT_LOAD_IMAGE=1;
    public static final String EXTRA_MESSAGE = "com.example.user.tolet";
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    TextView textView;
    Button post;
    Switch aSwitch;
    ImageButton imageButton;
    ImageView imageView;
    TaskItem taskItem=new TaskItem();

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
        post=(Button)findViewById(R.id.postButton);
        aSwitch=(Switch) findViewById(R.id.switcha);
        imageButton=(ImageButton) findViewById(R.id.imageButtonPic);
        imageView=(ImageView)findViewById(R.id.imageView);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent =new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent,RESULT_LOAD_IMAGE);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==RESULT_LOAD_IMAGE && resultCode==RESULT_OK && data!=null){
            Uri selectedImage=data.getData();
            imageView.setImageURI(selectedImage);
     //       Bitmap bitmap=(BitmapDrawable) imageView.getDrawable().getBitMap();

        }
    }


    public void sendMessage(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.houseNO);
        String message = editText.getText().toString();

        taskItem.HouseNo=message;
        editText = (EditText) findViewById(R.id.road);
        message=editText.getText().toString();
        taskItem.RoadNo=message;
        editText = (EditText) findViewById(R.id.Thana);
        message=editText.getText().toString();
        taskItem.Thana=message;
        editText = (EditText) findViewById(R.id.district);
        message=editText.getText().toString();
        taskItem.District=message;
        editText = (EditText) findViewById(R.id.postAddress);
        message=editText.getText().toString();
        taskItem.PostAddress=message;
        intent.putExtra("postObject", taskItem);
        startActivity(intent);
    }
}
