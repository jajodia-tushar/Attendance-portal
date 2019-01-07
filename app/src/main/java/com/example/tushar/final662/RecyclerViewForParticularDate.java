package com.example.tushar.final662;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewForParticularDate extends AppCompatActivity {

    android.support.v7.widget.RecyclerView recyclerView;
    AttendanceAdapterForCalendar attendanceAdapter;
    List<Lectures> attendanceDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_for_particular_date);
        attendanceDataList = new ArrayList<Lectures>();

        ArrayList<String> forIntent = getIntent().getExtras().getStringArrayList("main");

        for(int i=0; i < forIntent.size(); i++)
        {
            String lines[] = forIntent.get(i).split("\\r?\\n");
            attendanceDataList.add(new Lectures(lines[0],lines[1]));
        }

        recyclerView = (android.support.v7.widget.RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setNestedScrollingEnabled(false);
        attendanceAdapter = new AttendanceAdapterForCalendar(this,attendanceDataList);
        recyclerView.setAdapter(attendanceAdapter);




    }
}
