package com.mobileapp.nu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class BookedHomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Window window;

    TextInputLayout name, contact, email, date;
    FloatingActionButton fb;
    Button sbmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_home);

        name = (TextInputLayout) findViewById(R.id.nametext);
        contact = (TextInputLayout) findViewById(R.id.contacttext);
        email = (TextInputLayout) findViewById(R.id.emailtext);
        date = (TextInputLayout) findViewById(R.id.datetext);
        fb = (FloatingActionButton) findViewById(R.id.fbtn);
        sbmt = (Button) findViewById(R.id.sbmt_add);

        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                processinsert(name.getEditText().getText().toString(),contact.getEditText().getText().toString(),email.getEditText().getText().toString(),date.getEditText().getText().toString());
                //crate a method called process insert
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),fetchdata.class));
            }
        });





        //bottom navigation view
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.Menu_booked);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.Menu_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Menu_booked:
                        return true;

                    case R.id.Menu_logout:
                        startActivity(new Intent(getApplicationContext(),AccountActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        //TO SET COLOUR IN STATUS BAR
        window=this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.dark_red));

    }

    private void processinsert(String n, String c, String e, String d)
    {
        String res=new dbmanager(this).addrecord(n,c,e,d);
        name.getEditText().setText("");
        contact.getEditText().setText("");
        email.getEditText().setText("");
        date.getEditText().setText("");
        Toast.makeText(getApplicationContext(),res,Toast.LENGTH_SHORT).show();
    }
}
