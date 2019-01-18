package com.example.oscarrodas.cityguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationDetailActivity extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    String[] details = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_detail);
        ImageView imageView_ld = findViewById(R.id.imageView_ldimage);
        TextView textView_ldname = findViewById(R.id.textView_ldname);
        TextView textView_ldaddress = findViewById(R.id.textView_ldaddress);
        TextView textView_ldlink = findViewById(R.id.textView_ldlink);
        TextView textView_ldphone = findViewById(R.id.textView_ldphone);
        TextView textView_lddes = findViewById(R.id.textView_lddes);
        Intent i = getIntent();
        Bundle b = i.getExtras();
        if(b!=null){
            String search = (String) b.get("name");
            helper.searchLocation(search);
            details = helper.locate;
        }

        textView_ldname.setText(details[0]);
        int imageResource = getResources().getIdentifier(details[1], null, this.getPackageName());
        imageView_ld.setImageResource(imageResource);
        textView_ldaddress.setText(details[2]);
        textView_ldlink.setText(details[3]);
        textView_ldphone.setText(details[4]);
        textView_lddes.setText(details[5]);
    }
}
