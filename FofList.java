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

import com.robotemplates.cityguide.database.DatabaseHelper4;

/**
 * Created by oscar on 7/26/2017.
 */

public class FofList extends AppCompatActivity{
    DatabaseHelper4 helper4 = new DatabaseHelper4(this);
    String items[] = new String[20];
    String items2[] = new String[20];
    String n = "a";
    public static Intent newIntent(Context context)
    {
        return new Intent(context, FofList.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        ListView frlistView = (ListView) findViewById(R.id.frlistView);
        n = helper4.current;
        CustomAdapter3 customAdapter3 = new CustomAdapter3();
        frlistView.setAdapter(customAdapter3);
    }



    class CustomAdapter3 extends BaseAdapter {

        @Override   //returns number of data items
        public int getCount() {
            return helper4.count2;
            //return 1;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.frcustomlayout, null);
            TextView textView_frname = (TextView)view.findViewById(R.id.textView_frname);
            //ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
            items2 = helper4.data2;
            textView_frname.setText(items2[i]);

            return view;
        }
    }

}
