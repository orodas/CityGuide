package com.robotemplates.cityguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.robotemplates.cityguide.database.DatabaseHelper3;

/**
 * Created by oscar on 7/27/2017.
 */

public class UReviewsListActivity extends AppCompatActivity {
    DatabaseHelper3 helper3 = new DatabaseHelper3(this);
    String[] items = new String[20];
    String n = helper3.usr;

   // public static Intent newIntent(Context context)
   // {
    //return new Intent(context, ListActivity.class);
    //}

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listView = (ListView) findViewById(R.id.listView);
        CustomAdapter3 customAdapter3 = new CustomAdapter3();
        listView.setAdapter(customAdapter3);
    }

    class CustomAdapter3 extends BaseAdapter {

        @Override
        public int getCount() {
            return helper3.searchAll(n);
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
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.user_reviews_layout, null);
            TextView textView_plname = (TextView)view.findViewById(R.id.textView_plname);
            TextView textView_usr = (TextView)view.findViewById(R.id.textView_usr);
            TextView textView_rating2 = (TextView)view.findViewById(R.id.textView_rating2);
            TextView textView_review2 = (TextView)view.findViewById(R.id.textView_review2);
            items = helper3.data2;
            textView_usr.setText(items[i*4]);
            textView_plname.setText(items[i*4+1]);
            textView_rating2.setText("Rating: " + items[i*4+2] + "/5");
            textView_review2.setText(items[i*4+3]);
            return view;
        }
    }
}
