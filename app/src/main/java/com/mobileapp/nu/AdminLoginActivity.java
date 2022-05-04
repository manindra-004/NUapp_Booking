package com.mobileapp.nu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminLoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText email, password;
    private Button btnLogin;
    //private TextView textRegister;
    Window window;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        btnLogin = findViewById(R.id.login);
        //textRegister = findViewById(R.id.text_register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

       // textRegister.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View view) {
              //  startActivity(new Intent(AdminLoginActivity.this, RegisterActivity.class));
           // }
        //});

        //TO SET COLOUR IN STATUS BAR
        window=this.getWindow();
        window.setStatusBarColor(this.getResources().getColor(R.color.dark_red));
    }

    private void login() {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if (pass.isEmpty())
        {
            email.setError("Email can not be empty");
        }
        if (pass.isEmpty())
        {
            password.setError("Password can not be empty");
        }
        else
        {
            mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(AdminLoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(AdminLoginActivity.this , MainActivity.class));
                    }
                    else
                    {
                        Toast.makeText(AdminLoginActivity.this, "Login Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }

    }


}
