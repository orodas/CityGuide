package com.robotemplates.cityguide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.robotemplates.cityguide.activity.LoginActivity;
import com.robotemplates.cityguide.database.DatabaseHelper2;
import com.robotemplates.cityguide.database.DatabaseHelper3;
import com.robotemplates.cityguide.database.DatabaseHelper4;
import com.robotemplates.cityguide.fragment.PoiDetailFragment;

public class ListActivity extends AppCompatActivity {

    String[] NAMES = {"BIG B", "Gandhi"};
    String[] DESCRIPTIONS = {"Actor", "Freedom Fighter"};
    String n = poidf.pname;
    String[] items = new String[20];
    public static Intent newIntent(Context context)
    {
        return new Intent(context, ListActivity.class);
    }
    private static PoiDetailFragment poidf = new PoiDetailFragment();
    private static LoginActivity la = new LoginActivity();
    DatabaseHelper2 helper2 = new DatabaseHelper2(this);
    DatabaseHelper3 helper3 = new DatabaseHelper3(this);
    DatabaseHelper4 helper4 = new DatabaseHelper4(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView listView = (ListView) findViewById(R.id.listView);
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    public void onAddFriendClick(View view) {
        if(view.getId() == R.id.textView_name){
            String a = la.e;
            String u = helper2.searchName(a);
            TextView textView_name = (TextView)view.findViewById(R.id.textView_name);
            String fru = (String) textView_name.getText();
            if(u.equals(fru)){
                Toast pass = Toast.makeText(ListActivity.this, "You can't friend yourself!" , Toast.LENGTH_SHORT);
                pass.show();
            }
            else if(!helper4.searchFriends(u,fru)){
                Friend friend = new Friend();
                friend.setUname(u);
                friend.setFruname(fru);
                helper4.insertFriend(friend);
                Toast pass = Toast.makeText(ListActivity.this, fru + " is now your friend" , Toast.LENGTH_SHORT);
                pass.show();
            }
            else{
                Toast pass = Toast.makeText(ListActivity.this, fru + " is already your friend" , Toast.LENGTH_SHORT);
                pass.show();
            }
        }
    }


    class CustomAdapter extends BaseAdapter {

        @Override   //returns number of data items
        public int getCount() {
            return helper3.searchData(n);
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
            view = getLayoutInflater().inflate(R.layout.customlayout, null);
            TextView textView_name = (TextView)view.findViewById(R.id.textView_name);
            TextView textView_review = (TextView)view.findViewById(R.id.textView_review);
            TextView textView_rating = (TextView)view.findViewById(R.id.textView_rating);
            items = helper3.data;
            textView_name.setText(items[3*i]);
            textView_rating.setText("Rating: " + items[3*i+1] + "/5");
            textView_review.setText(items[3*i+2]);
            return view;
        }

    }

}