package com.example.oscarrodas.cityguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddLocation extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);
    }

    public void onAddLocationClick(View v){
        if(v.getId() == R.id.Bsubmitlocation){
            EditText name = (EditText)findViewById(R.id.editText_lname);
            EditText category = (EditText)findViewById(R.id.editText_lcat);
            EditText intro = (EditText)findViewById(R.id.editText_lintro);
            EditText image = (EditText)findViewById(R.id.editText_limage);
            EditText link = (EditText)findViewById(R.id.editText_llink);
            EditText address = (EditText)findViewById(R.id.editText_laddress);
            EditText phone = (EditText)findViewById(R.id.editText_lphone);
            EditText description = (EditText)findViewById(R.id.editText_ldes);

            String namestr = name.getText().toString();
            String catstr = category.getText().toString();
            String introstr = intro.getText().toString();
            String imagestr = image.getText().toString();
            String linkstr = link.getText().toString();
            String addstr = address.getText().toString();
            String phonestr = phone.getText().toString();
            String desstr = description.getText().toString();

            Toast pass = Toast.makeText(AddLocation.this, "submitted " + namestr, Toast.LENGTH_SHORT);
            pass.show();
            Location l = new Location();
            l.setName(namestr);
            l.setCategory(catstr);
            l.setIntro(introstr);
            l.setImage(imagestr);
            l.setLink(linkstr);
            l.setAddress(addstr);
            l.setPhone(phonestr);
            l.setDescription(desstr);

            helper.insertLocation(l);
            Intent i = new Intent(AddLocation.this, LoginActivity.class);
            startActivity(i);
        }
    }
}
