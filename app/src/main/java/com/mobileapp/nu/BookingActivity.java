package com.mobileapp.nu;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookingActivity extends AppCompatActivity {

    RecyclerView recyclerCricketers;
    ArrayList<booker> cricketersList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        recyclerCricketers = findViewById(R.id.recycler_cricketers);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerCricketers.setLayoutManager(layoutManager);

        cricketersList = (ArrayList<booker>) getIntent().getExtras().getSerializable("list");

        recyclerCricketers.setAdapter(new BookerAdapter(cricketersList));

    }
}