package com.mobileapp.nu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    private FirebaseAuth mAuth;
    private Button btnLogout;
    Window window;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //Logout
        mAuth = FirebaseAuth.getInstance();
        btnLogout = findViewById(R.id.finallogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        //bottom navigation view
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.Menu_logout);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.Menu_home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Menu_booked:
                        startActivity(new Intent(getApplicationContext(),BookedHomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Menu_logout:
                        return true;
                }
                return false;
            }
        });

        //TO SET COLOUR IN STATUS BAR
        window=this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.dark_red));

    }
    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser==null)
        {
            startActivity(new Intent(AccountActivity.this, LoginActivity.class));
        }
    }
    public void logout() {

        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(AccountActivity.this, LoginActivity.class));
    }
}
