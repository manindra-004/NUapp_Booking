package com.mobileapp.nu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.List;
import java.util.Map;

public class teacher_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher2);
    }

    SimpleAdapter ad;

    public void GetData2(View view)
    {
        ListView listview = (ListView) findViewById(R.id.listviewsimpe2);

        List<Map<String,String>> MyDataList=null;
        ListItem2 MyData = new ListItem2();
        MyDataList = MyData.getlist2();

        String[] Fromw = {"PanelID","NameID","DesiID","TimeID","DateID"};
        int[] Tow = {R.id.PanelID,R.id.NameID,R.id.DesiID,R.id.TimeID,R.id.DateID};
        ad = new SimpleAdapter(teacher_2.this,MyDataList,R.layout.listlayouttemplate,Fromw,Tow);
        listview.setAdapter(ad);
    }
}