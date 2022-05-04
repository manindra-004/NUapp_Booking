package com.mobileapp.nu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListItem3 {


    Connection connect;
    String ConnectionResult = "";
    Boolean isSuccess=false;

    public List<Map<String,String>> getlist3() {
        List<Map<String, String>> data = null;
        data = new ArrayList<Map<String, String>>();
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connect = connectionHelper.conclass();
            if (connect != null) {
                String qu = "select * from AdminTable WHERE Name='Priya Kumari'";
                Statement statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery(qu);
                while (resultSet.next()) {
                    Map<String, String> dtname = new HashMap<String, String>();
                    dtname.put("PanelID", resultSet.getString("PanelCode"));
                    dtname.put("NameID", resultSet.getString("Name"));
                    dtname.put("DesiID", resultSet.getString("Designation"));
                    dtname.put("TimeID", resultSet.getString("Timing"));
                    dtname.put("DateID", resultSet.getString("BookedDate"));

                    data.add(dtname);

                }
                ConnectionResult = "Success";
                isSuccess = true;
                connect.close();

            } else {
                ConnectionResult = "Failed";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

}
