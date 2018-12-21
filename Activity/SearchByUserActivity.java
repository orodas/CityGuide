package com.robotemplates.cityguide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.stmt.query.In;
import com.robotemplates.cityguide.database.DatabaseHelper2;
import com.robotemplates.cityguide.database.DatabaseHelper3;

public class SearchByUserActivity extends Activity {
    DatabaseHelper2 helper2 = new DatabaseHelper2(this);
    DatabaseHelper3 helper3 = new DatabaseHelper3(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_user);
    }

    public static Intent newIntent(Context context){
        return  new Intent(context, SearchByUserActivity.class);
    }

    public void onSearchByUClick(View view) {
        if(view.getId() == R.id.BSearchbyU){
            EditText editText = (EditText)findViewById(R.id.editText_Ureview);
            String ustr = editText.getText().toString();
            helper3.usr = ustr;
            if(ustr.equals("")){
                Toast toast = Toast.makeText(SearchByUserActivity.this, "Username can't be empty", Toast.LENGTH_SHORT);
                toast.show();
            }
            else if(!helper2.searchUname(ustr)){
                Toast toast = Toast.makeText(SearchByUserActivity.this, "Username doesn't exist", Toast.LENGTH_SHORT);
                toast.show();
            }
            else{
                Toast toast = Toast.makeText(SearchByUserActivity.this, "Success", Toast.LENGTH_SHORT);
                toast.show();
                Intent i = new Intent(SearchByUserActivity.this, UReviewsListActivity.class);
                startActivity(i);
            }
        }
    }
}
