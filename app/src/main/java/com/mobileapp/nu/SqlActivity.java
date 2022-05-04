package com.mobileapp.nu;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlActivity extends AppCompatActivity {

    Button btnhome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        TextView panelid = (TextView)findViewById(R.id.PanelAdmin);
        TextView nameid = (TextView)findViewById(R.id.NameAdmin);
        TextView desiid = (TextView)findViewById(R.id.DesignationAdmin);
        TextView timeid = (TextView)findViewById(R.id.TimingAdmin);
        TextView dateid = (TextView)findViewById(R.id.DateAdmin);
        TextView pnoid = (TextView)findViewById(R.id.PNoAdmin);
        //Onclick
        Button btninsert = (Button)findViewById(R.id.btnInsert);
        Button btnget = (Button)findViewById(R.id.btnGet);
        Button btnupdate = (Button)findViewById(R.id.btnUpdate);
        Button btndelete = (Button)findViewById(R.id.btnDelete);

        btnhome = findViewById(R.id.HomePage);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitymainhome();

            }
        });

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection connection = connectionclass();
                try {
                    if(connection !=null){
                        String sqlinsert = "Insert into AdminTable values ('"+panelid.getText().toString()+"','"+nameid.getText().toString()+"','"+desiid.getText().toString()+"','"+timeid.getText().toString()+"','"+dateid.getText().toString()+"','"+pnoid.getText().toString()+"')";
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(sqlinsert);
                    }

                }
                catch (Exception exception){
                    Log.e("Error",exception.getMessage());

                }

            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connection connection = connectionclass();
                try {
                    if(connection !=null){
                        String sqlupdate = "update AdminTable set Name = '"+nameid.getText().toString()+"', Designation = '"+desiid.getText().toString()+"',Timing = '"+timeid.getText().toString()+"', BookedDate = '"+dateid.getText().toString()+"', PanelNo = '"+pnoid.getText().toString()+"' where PanelCode = '"+panelid.getText().toString()+"'";
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(sqlupdate);
                    }

                }
                catch (Exception exception){
                    Log.e("Error",exception.getMessage());

                }
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Connection connection = connectionclass();
                try {
                    if(connection !=null){
                        String sqldelete = "delete AdminTable where PanelCode = '"+panelid.getText().toString()+"'";
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(sqldelete);
                    }

                }
                catch (Exception exception){
                    Log.e("Error",exception.getMessage());

                }

            }
        });

        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Connection connection = connectionclass();
                try {
                    if(connection !=null){
                        String sqlget = "select * from AdminTable where PanelCode = '"+panelid.getText().toString()+"'";
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(sqlget);

                        while (resultSet.next()){
                            nameid.setText(resultSet.getString(2));
                            desiid.setText(resultSet.getString(3));
                            timeid.setText(resultSet.getString(4));
                            dateid.setText(resultSet.getString(5));
                            pnoid.setText(resultSet.getString(6));
                        }
                    }

                }
                catch (Exception exception){
                    Log.e("Error",exception.getMessage());

                }

            }
        });



    }

    @SuppressLint("NewApi")
    public Connection connectionclass(){
        Connection con=null;
        String ip = "172.30.80.1",port = "1433",username = "sa",password = "3255", databasename = "AdminInput";
        StrictMode.ThreadPolicy tp = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(tp);
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            String ConnectionURL= "jdbc:jtds:sqlserver://"+ip+":"+port+";"+"databaseName="+ databasename+ ";user="+username+";password="+password+";";
            con= DriverManager.getConnection(ConnectionURL);

        }
        catch (Exception exception){
            Log.e("Error",exception.getMessage());

        }
        return con;

    }

    public void openActivitymainhome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
