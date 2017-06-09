package com.example.user.tolet;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.user.tolet";
    TextView textView;
    ImageButton imageButton;
  //  EditText editText1,editText2;
    ListView listView;
    TaskItem taskItem;
   // public static final AD ad=new AD();
    public static DatabaseHelper dbH;
    static final AD ad=new AD();
    static int firstDone=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbH=new DatabaseHelper(getApplicationContext());
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        //String message = intent.getStringExtra(PostAdd.EXTRA_MESSAGE);
       // taskItem=intent.getSerializableExtra("postObject");
        taskItem=(TaskItem)intent.getSerializableExtra("postObject");
     //   dbH.insertData(taskItem);
        // / System.out.println(taskItem.getHouseNo());
      //  if(taskItem!=null)
        //    ad.items.add(taskItem);
        listView=(ListView) findViewById(R.id.listV);
        textView=(TextView) findViewById(R.id.textView8);
       // editText1=(EditText)findViewById(R.id.editText4);
      //  editText2=(EditText) findViewById(R.id.editText5);
      //  imageButton=(ImageButton)findViewById(R.id.imageButton);
        // imgB=(ImageButton)findViewById(R.id.imageButton2);
       // ad.items=new ArrayList<TaskItem>(); //item initialize hoilo



        // final ArrayAdapter<TaskItem> adapter=new ArrayAdapter<TaskItem>(this,android.R.layout.task_row,items);
        // final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        ArrayAdapter adapter=new Addap();
        listView.setAdapter(adapter);
        if(taskItem!=null)
            ad.items.add(taskItem);
        adapter.notifyDataSetChanged();
       // }
      //  ad.items.add(taskItem);
    //    adapter.notifyDataSetChanged();
    //    editText1.setText(items.get(1).getHouseNo());
    /*    imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=editText2.getText().toString();
                String q=editText1.getText().toString();
                ad.items.add(new TaskItem(s,q,"","","",""));
                adapter.notifyDataSetChanged();
                editText1.setText("");
                editText2.setText("");
                //      setContentView(R.layout.activity_main2);
            }
        }); */


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             //   textView.setText(ad.items.get(i).getHouseNo());
             //   System.out.println(ad.items.get(i).getHouseNo());
                taskItem=ad.items.get(i);
                sendMessageToAdPage(view);
            }
        });


        // Capture the layout's TextView and set the string as its text
        //  TextView textView = (TextView) findViewById(R.id.textView);
        //textView.setText(message)


    }
    public void sendMessage(View view) {

        //setContentView(R.layout.activity_post_add);
        Intent intent=new Intent(this,PostAdd.class);
        startActivity(intent);
        //   adapter.notifyDataSetChanged();
    }
    public void sendMessageToAdPage(View view) {

        //setContentView(R.layout.activity_post_add);
        Intent intent=new Intent(this,AdPage.class);
        TextView textView;
     //   textView = (TextView) findViewById(R.id.baa);
      //  String message =textView.getText().toString();

        intent.putExtra("postObject", taskItem);
        startActivity(intent);
        //   adapter.notifyDataSetChanged();
    }


///arrayAdapter listView
    public class Addap extends ArrayAdapter<TaskItem>{
        public Addap() {
            super(getApplicationContext(), R.layout.task_row,ad.items);

         //   tItem.ContactNo="3";
        //    dbH.insertData(tItem);
        //    ad.items.add(tItem);
          //  ad.items.add(tItem);
          //  ad.items.add(tItem);
            //ad.items.add(taskItem);
            //Cursor nia basically ekhane kisu code thaka uchit
            TextView texView=(TextView) findViewById(R.id.textView8);
            if(firstDone==0) {
                ad.items.clear();
                Cursor cursor = dbH.getAsRequested("SELECT * FROM ads_info");
                cursor.moveToFirst();
              //  cursor.moveToNext();
                //    String x="";
                while (!cursor.isAfterLast()) {
                    TaskItem tItem=new TaskItem();
                    tItem.HouseNo = cursor.getString(cursor.getColumnIndex("HOUSE"));
                    tItem.RoadNo = cursor.getString(cursor.getColumnIndex("ROAD"));
                    tItem.Thana = cursor.getString(cursor.getColumnIndex("THANA"));
                    tItem.District = cursor.getString(cursor.getColumnIndex("DISTRICT"));
                    tItem.PostAddress = cursor.getString(cursor.getColumnIndex("POSTADRS"));
                    tItem.isBachelor = cursor.getString(cursor.getColumnIndex("ISBACHELOR"));
                    tItem.ContactNo = cursor.getString(cursor.getColumnIndex("CONTACT"));
                    tItem.ImageUri=cursor.getString(cursor.getColumnIndex("IMAGE"));
                    ad.items.add(tItem);
                    cursor.moveToNext();

                }
                cursor.close();
                firstDone=33;
            }
         //   String x= String.valueOf(cursor.getColumnIndex("CONTACT"));

          //  texView.setText(x);
        }

        @NonNull
        @Override
        public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v=convertView;
            if(v==null){
                v=getLayoutInflater().inflate(R.layout.task_row,parent,false);
            }
            TextView t1,t2;
            ImageView imageBun;
            t1=(TextView)v.findViewById(R.id.ba);
            t2=(TextView)v.findViewById(R.id.baa);
            imageBun=(ImageView) v.findViewById(R.id.xxx);
            t2.setText(ad.items.get(position).getHouseNo()+"\n"+ad.items.get(position).getRoadNo()+"\n"+ad.items.get(position).getDistrict());
            t1.setText(ad.items.get(position).getContactNo());


           // ad.items.get(position).getHouseNo();
          //  if(ad.items.get(position).getHouseNo()!=null)
               // t1.setText(ad.items.get(position).toString());
            // t1.setText(ad.items.get(position).HouseNo);
            // t2.setText(ad.items.get(position).RoadNo);
            imageBun.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    ad.items.remove(position);
                    notifyDataSetChanged();
                }
            });
            return v;
        }
    }
}
