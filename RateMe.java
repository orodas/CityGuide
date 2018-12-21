package com.robotemplates.cityguide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import com.robotemplates.cityguide.activity.LoginActivity;
import com.robotemplates.cityguide.activity.MainActivity;
import com.robotemplates.cityguide.database.DatabaseHelper2;
import com.robotemplates.cityguide.database.DatabaseHelper3;
import com.robotemplates.cityguide.fragment.PoiDetailFragment;

public class RateMe extends AppCompatActivity {
    private static PoiDetailFragment poidf = new PoiDetailFragment();
    private static LoginActivity la = new LoginActivity();
    DatabaseHelper2 helper2 = new DatabaseHelper2(this);
    DatabaseHelper3 helper3 = new DatabaseHelper3(this);


    public static Intent newIntent(Context context)
    {
        return new Intent(context, RateMe.class);
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_me);
    }

    public void onRateClick(View v){
        if(v.getId() == R.id.BReview){
            EditText editText = (EditText) findViewById(R.id.editText_myreview);
            final RatingBar rateBar = (RatingBar) findViewById(R.id.ratingBar);
            String reviewstr = editText.getText().toString();
            if(!reviewstr.equals("")) {
                Review rev = new Review();
                Integer r = ((int)rateBar.getRating());
                String rstr = r.toString();
                String n = poidf.pname;
                String m = la.e;
                String s = helper2.searchName(m);
                rev.setUname(s);
                rev.setPoiname(n);
                rev.setReview(reviewstr);
                rev.setRating(rstr);
                helper3.insertReview(rev);
                Toast pass = Toast.makeText(RateMe.this, "Review Submitted", Toast.LENGTH_SHORT);
                pass.show();
                Intent i = new Intent(RateMe.this, MainActivity.class);
                startActivity(i);
            }
            else{
                Toast pass = Toast.makeText(RateMe.this, "Field cannot be empty", Toast.LENGTH_SHORT);
                pass.show();
            }
        }
    }
}
