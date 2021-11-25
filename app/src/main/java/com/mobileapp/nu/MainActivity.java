package com.mobileapp.nu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    TextView name;
    ImageView photo;
    FirebaseAuth mAuth;
    private Button button ,button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    }
    public void openActivityMain(){
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    public void openActivityMain1(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}