package com.robotemplates.cityguide.activity; /**
 * Created by oscar on 7/7/2017.
 */

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.robotemplates.cityguide.Contact;
import com.robotemplates.cityguide.R;
import com.robotemplates.cityguide.database.DatabaseHelper2;

public class SignUp extends Activity{
    DatabaseHelper2 helper2 = new DatabaseHelper2(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onButtonClick(View v) {
        if(v.getId() == R.id.Bsignupbutton)
        {
            String temp;
            EditText name = (EditText)findViewById(R.id.TFname);
            EditText email = (EditText)findViewById(R.id.TFemail);
            EditText uname = (EditText)findViewById(R.id.TFuname);
            EditText pass1 = (EditText)findViewById(R.id.TFpass1);
            EditText pass2 = (EditText)findViewById(R.id.TFpass2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

           // temp = helper2.searchPass(emailstr);

            if(!pass1str.equals(pass2str))
            {
                //popup msg
                Toast pass = Toast.makeText(SignUp.this, "Passwords don't match", Toast.LENGTH_SHORT);
                pass.show();
            }
            else if(helper2.searchUname(unamestr))
            {
                Toast pass = Toast.makeText(SignUp.this, "Username already exists", Toast.LENGTH_SHORT);
                pass.show();
            }
            else if(helper2.searchEmail(emailstr))
            {
                Toast pass = Toast.makeText(SignUp.this, "Email already exists", Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                //insert details in database
                Toast pass = Toast.makeText(SignUp.this, "Registration complete", Toast.LENGTH_SHORT);
                pass.show();
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);

                helper2.insertContact(c);
                Intent i = new Intent(SignUp.this, LoginActivity.class);
               // i.putExtra("Username",str);
                startActivity(i);
            }

        }
    }
}