package com.robotemplates.cityguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.robotemplates.cityguide.activity.LoginActivity;
import com.robotemplates.cityguide.database.DatabaseHelper2;
import com.robotemplates.cityguide.database.DatabaseHelper4;

public class FriendListActivity extends AppCompatActivity {
    private static LoginActivity la = new LoginActivity();
    DatabaseHelper2 helper2 = new DatabaseHelper2(this);
    DatabaseHelper4 helper4 = new DatabaseHelper4(this);
    String a = la.e;
    String n = "a";

    String items[] = new String[20];
    public static Intent newIntent(Context context)
    {
        return new Intent(context, FriendListActivity.class);
    }

    public void onFofClick(View view) {
        if(view.getId() == R.id.textView_frname){
            TextView textView = (TextView)view.findViewById(R.id.textView_frname) ;
            helper4.searchFru((String)textView.getText());
          //  Toast pass = Toast.makeText(FriendListActivity.this, textView.getText(), Toast.LENGTH_SHORT);
          //  pass.show();
            Intent intent = new Intent(FriendListActivity.this,FofList.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        ListView frlistView = (ListView) findViewById(R.id.frlistView);
        n = helper2.searchName(a);
        CustomAdapter2 customAdapter2 = new CustomAdapter2();
        frlistView.setAdapter(customAdapter2);
    }

    class CustomAdapter2 extends BaseAdapter {

        @Override   //returns number of data items
        public int getCount() {
            return helper4.searchData(n);
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
            items = helper4.data;
            textView_frname.setText(items[i]);

            return view;
        }
    }

}
