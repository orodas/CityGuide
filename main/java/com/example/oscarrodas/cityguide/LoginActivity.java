package com.example.oscarrodas.cityguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import static android.Manifest.permission.READ_CONTACTS;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper2 helper2 = new DatabaseHelper2(this);

    public static String e = "empty";
    public String getInfo(String s){
        e = s;
        return e;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.Blogin) {
            EditText a = (EditText) findViewById(R.id.TFemail);
            String str = a.getText().toString();
            EditText b = (EditText) findViewById(R.id.TFpwd);
            String pass = b.getText().toString();

            String pwd = helper2.searchPass(str);
            if (pwd.equals(pass)) {
                e = getInfo(str);
                Toast yay = Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT);
                yay.show();
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                //i.putExtra("Username",str);
                startActivity(i);
            } else if (!helper2.searchEmail(str)) {
                Toast wemail = Toast.makeText(LoginActivity.this, "Email not found", Toast.LENGTH_SHORT);
                wemail.show();
            } else {
                Toast wpass = Toast.makeText(LoginActivity.this, "Password is incorrect", Toast.LENGTH_SHORT);
                wpass.show();
            }
        }
        if(v.getId() == R.id.Bsignup){
            Intent i = new Intent(LoginActivity.this, SignUp.class);
            startActivity(i);
        }
        if(v.getId() == R.id.Baddlocation){
            Intent i = new Intent(LoginActivity.this, AddLocation.class);
            startActivity(i);
        }

    }
}