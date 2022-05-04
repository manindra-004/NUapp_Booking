package com.mobileapp.nu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class teacher_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher1);
    }

    SimpleAdapter ad;

    public void GetData1(View view)
    {
        ListView listview = (ListView) findViewById(R.id.listviewsimpe1);

        List<Map<String,String>> MyDataList=null;
        ListItem1 MyData = new ListItem1();
        MyDataList = MyData.getlist1();

        String[] Fromw = {"PanelID","NameID","DesiID","TimeID","DateID"};
        int[] Tow = {R.id.PanelID,R.id.NameID,R.id.DesiID,R.id.TimeID,R.id.DateID};
        ad = new SimpleAdapter(teacher_1.this,MyDataList,R.layout.listlayouttemplate,Fromw,Tow);
        listview.setAdapter(ad);
    }
}