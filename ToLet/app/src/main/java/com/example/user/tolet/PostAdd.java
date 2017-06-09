package com.example.user.tolet;

import android.content.Intent;
import android.database.Cursor;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import static com.example.user.tolet.MainActivity.dbH;


public class PostAdd extends AppCompatActivity {
    public static final int SELECTED_PICTURE=9000;
    public static final String EXTRA_MESSAGE = "com.example.user.tolet";
    Bitmap selectedImage;
    EditText editText1;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    TextView textView;
    Button post;
    CheckBox aSwitch;
    ImageButton imageButton;
    ImageView imageView;
    TaskItem taskItem;
    Bitmap byP;
    String strURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        taskItem=new TaskItem();
        setContentView(R.layout.activity_post_add);
        editText1=(EditText) findViewById(R.id.houseNO);
        editText2=(EditText) findViewById(R.id.road);
        editText3=(EditText) findViewById(R.id.Thana);
        editText4=(EditText) findViewById(R.id.district);
        editText5=(EditText) findViewById(R.id.postAddress);
        editText6=(EditText) findViewById(R.id.contactNo);
        textView=(TextView) findViewById(R.id.currState);
        post=(Button)findViewById(R.id.postButton);
        aSwitch=(CheckBox) findViewById(R.id.switcha);
        imageButton=(ImageButton) findViewById(R.id.imageButtonPic);
        imageView=(ImageView) findViewById(R.id.imageV);



        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, SELECTED_PICTURE);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SELECTED_PICTURE && resultCode == RESULT_OK && data != null){
        //    System.out.println("111111111111111111111111111111111111111111111111");
     /*////////////////////////////////////       Uri uri = data.getData();
        //    String[] projection = {MediaStore.Images.Media.DATA};

          //  Cursor cursor = getContentResolver().query(uri,projection,null,null,null);
            //cursor.moveToFirst();

//            int column_index = cursor.getColumnIndex(projection[0]);
  //          String filePath = cursor.getString(column_index);
    //        cursor.close();

      //      selectedImage  = BitmapFactory.decodeFile(filePath);

        //    Drawable d = new BitmapDrawable(selectedImage);
            imageView.setImageURI(null);
            imageView.setImageURI(uri);
            byteArr=null;
            byteArr=imageViewToByte(imageView);     ////////////////////////////*/

            Uri selectedImage = data.getData();
            strURI = selectedImage.toString();
         //   Uri imageUri = Uri.parse(strURI);
          //  imageView.setImageURI(imageUri);
       //     String[] filePathColumn = {MediaStore.Images.Media.DATA};

       //     Cursor cursor = getContentResolver().query(selectedImage,
      //              filePathColumn, null, null, null);
         //   cursor.moveToFirst();

       //     int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
       //     String picturePath = cursor.getString(columnIndex);
       //     cursor.close();
       //     byP = BitmapFactory.decodeFile(picturePath);
        //    taskItem.byteImage=bm;
       //     imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

   //      Bitmap bmp = BitmapFactory.decodeByteArray(byteArr, 0, byteArr.length);
     //       imageView.setImageBitmap(Bitmap.createScaledBitmap(bmp, imageView.getWidth(),
       //             imageView.getHeight(), false));
       //     imageView.setImageDrawable(d);
         //   imageButton.setImageDrawable(d);
        }
        else {
        }
    }
    private byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
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
        editText = (EditText) findViewById(R.id.contactNo);
        message=editText.getText().toString();
        taskItem.ContactNo=message;
        editText = (EditText) findViewById(R.id.postAddress);
        message=editText.getText().toString();
        taskItem.PostAddress=message;
        aSwitch=(CheckBox) findViewById(R.id.switcha);
        if(aSwitch.isChecked()) taskItem.isBachelor="Bachelor allowed";
        else taskItem.isBachelor="Bachelor not allowed";
        taskItem.ImageUri=strURI;
   //     System.arraycopy(byteArr, 0, taskItem.byteImage, 0, byteArr.length);
        System.out.println("ahehe");
        dbH.insertData(taskItem);

        intent.putExtra("postObject", taskItem);
        startActivity(intent);
    }
}
