package com.mobileapp.nu;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionHelper {
    Connection connection;
    String ip,port,db,un,pass;

    @SuppressLint("NewApi")
    public Connection conclass(){
        ip="172.30.80.1";
        port="1433";
        db="AdminInput";
        un="sa";
        pass="3255";
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection =null;
        String ConnectionURL=null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL= "jdbc:jtds:sqlserver://"+ip+":"+port+";"+"databaseName="+ db+ ";user="+un+";password="+pass+";";
            connection= DriverManager.getConnection(ConnectionURL);
        }
        catch (Exception exception)
        {
            Log.e("Error : ", exception.getMessage());
        }
        return connection;
    }
}
