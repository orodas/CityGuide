package com.example.oscarrodas.cityguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.oscarrodas.cityguide.R.layout.maincustomlayout;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    String[] items = new String[20];
    String pack;
    //private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pack = this.getPackageName();
        //new code
        final ListView listView = findViewById(R.id.listview1);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String selected = ( (TextView)view.findViewById(R.id.textView_location) ).getText().toString();
                //Toast.makeText(MainActivity.this, selected, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, LocationDetailActivity.class);
                i.putExtra("name", selected);
                startActivity(i);
            }
        });
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return helper.searchData();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(maincustomlayout,null);
            TextView textView_location = convertView.findViewById(R.id.textView_location);
            items = helper.searchLocation();
            items = helper.data;
            ImageView imageView_location = (ImageView) convertView.findViewById(R.id.imageView_location);
            int imageResource = getResources().getIdentifier(items[position*2+1], null, pack);
            imageView_location.setImageResource(imageResource);
            textView_location.setText(items[position*2]);
            return convertView;
        }
    }

}

