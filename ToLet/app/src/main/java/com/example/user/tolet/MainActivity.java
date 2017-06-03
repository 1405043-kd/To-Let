package com.example.user.tolet;

import android.content.Context;
import android.content.Intent;
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

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.user.tolet";
    TextView textView;
    ImageButton imageButton;
    EditText editText1,editText2;
    ListView listView;
    public static final AD ad=new AD();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String message = intent.getStringExtra(PostAdd.EXTRA_MESSAGE);


        listView=(ListView) findViewById(R.id.listV);
        textView=(TextView) findViewById(R.id.textView8);
        editText1=(EditText)findViewById(R.id.editText4);
        editText2=(EditText) findViewById(R.id.editText5);
        imageButton=(ImageButton)findViewById(R.id.imageButton);
        //   imgB=(ImageButton)findViewById(R.id.imageButton2);
        // items=new ArrayList<TaskItem>();


        //  final ArrayAdapter<TaskItem> adapter=new ArrayAdapter<TaskItem>(this,android.R.layout.task_row,items);
        //  final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
        final ArrayAdapter adapter=new Addap();
        listView.setAdapter(adapter);

        ad.items.add(new TaskItem(message,"Apmas"));
        adapter.notifyDataSetChanged();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=editText2.getText().toString();
                String q=editText1.getText().toString();
                ad.items.add(new TaskItem(s,q));
                adapter.notifyDataSetChanged();
                editText1.setText("");
                editText2.setText("");
                //      setContentView(R.layout.activity_main2);
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(ad.items.get(i).csu.toString());
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
        textView = (TextView) findViewById(R.id.baa);
        String message =textView.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        //   adapter.notifyDataSetChanged();
    }

    public class Addap extends ArrayAdapter<TaskItem>{
        public Addap() {
            super(getApplicationContext(), R.layout.task_row,ad.items);
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

            t1.setText(ad.items.get(position).tsk);
            t2.setText(ad.items.get(position).csu);

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
