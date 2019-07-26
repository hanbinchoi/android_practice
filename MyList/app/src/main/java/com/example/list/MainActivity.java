package com.example.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SingerAdapter adapter;
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);


        ListView listView =(ListView)findViewById(R.id.listView);

        adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("이지석","010-9909-2541",R.drawable.ljs));
        adapter.addItem(new SingerItem("이종윤","010-4511-2069",R.drawable.ljy));
        adapter.addItem(new SingerItem("설진석","010-6607-2558",R.drawable.sjs));
        adapter.addItem(new SingerItem("전원석","010-5718-4393",R.drawable.jws));
        adapter.addItem(new SingerItem("정민호","010-8906-4743",R.drawable.jmh));
        adapter.addItem(new SingerItem("박현태","010-3239-3947",R.drawable.pht));
        adapter.addItem(new SingerItem("정태웅","010-2203-5949",R.drawable.jtw));


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SingerItem item = (SingerItem)adapter.getItem(i);
                Toast.makeText(getApplicationContext(),"선택: "+item.getName(),Toast.LENGTH_LONG).show();
            }
        });

        Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name = editText.getText().toString();
                String mobile = editText2.getText().toString();

                adapter.addItem(new SingerItem(name,mobile,R.drawable.ljy));
                adapter.notifyDataSetChanged();
            }

        });



    }

    class SingerAdapter extends BaseAdapter{

        ArrayList<SingerItem> items =new ArrayList<SingerItem>();


        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {
            SingerItemView view = new SingerItemView(getApplicationContext());

            SingerItem item = items.get(i);
            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResID());
            return view;
        }
    }


}
