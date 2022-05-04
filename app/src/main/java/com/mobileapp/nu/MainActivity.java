package com.mobileapp.nu;

import static com.mobileapp.nu.CalendarUtils.daysInMonthArray;
import static com.mobileapp.nu.CalendarUtils.monthYearFromDate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView name;
    ImageView photo;
    FirebaseAuth mAuth;
    private Button button, button1;
    private TextView monthYearText;

    BottomNavigationView bottomNavigationView;
    Window window;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarUtils.selectedDate = LocalDate.now();


        //bottom navigation view
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.Menu_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.Menu_home:
                        return true;

                    case R.id.Menu_booked:
                        startActivity(new Intent(getApplicationContext(),BookedHomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.Menu_logout:
                        startActivity(new Intent(getApplicationContext(),AccountActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        ///button
        button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMain();

            }
        });



        ///button
        button1 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMain1();

            }
        });


        //profile
        photo = findViewById(R.id.img_user);
        name = findViewById(R.id.NUadmin);
        //logout = findViewById(R.id.);
        mAuth = FirebaseAuth.getInstance();

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (signInAccount != null) {

            FirebaseUser user = mAuth.getCurrentUser();

            assert user != null;
            Glide.with(this)
                    .load(user.getPhotoUrl())
                    .into(photo);

            name.setText(user.getDisplayName());
        }

        //TO SET COLOUR IN STATUS BAR
        window=this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.dark_red));

    }
    public void openActivityMain(){
        Intent intent = new Intent(this, weekViewActivity.class);
        startActivity(intent);
    }

    public void openActivityMain1(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

}