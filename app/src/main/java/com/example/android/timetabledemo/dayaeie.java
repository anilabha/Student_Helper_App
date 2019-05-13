package com.example.android.timetabledemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.android.timetabledemo.Utils.LetterImageView;

public class dayaeie extends AppCompatActivity {

    private ListView listView;
    private android.support.v7.widget.Toolbar toolbar;
    public static String[] Monday__;
    public static String[] Tuesday__;
    public static String[] Wednesday__;
    public static String[] Thursday__;
    public static String[] Friday__;
    public static String[] Saturday__;
    public static String[] Sunday__;
    public static String[] Time1;
    public static String[] Time2;
    public static String[] Time3;
    public static String[] Time4;
    public static String[] Time5;
    public static String[] Time6;
    private static String[] Time7;
    private String[] PreferredDay;
    private String[] PreferredTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail);

        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews(){
        listView = (ListView)findViewById(R.id.lvDayDetail);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.ToolbarDayDetail);
    }

    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(weekaeie.sharedPreferences.getString(weekaeie.SEL_DAY, null));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupListView(){

        Monday__ = getResources().getStringArray(R.array.Monday__);
        Tuesday__ = getResources().getStringArray(R.array.Tuesday__);
        Wednesday__ = getResources().getStringArray(R.array.Wednesday__);
        Thursday__ = getResources().getStringArray(R.array.Thursday__);
        Friday__ = getResources().getStringArray(R.array.Friday__);
        Saturday__ = getResources().getStringArray(R.array.Saturday__);
        Sunday__ = getResources().getStringArray(R.array.Sunday__);

        Time1 = getResources().getStringArray(R.array.time1);
        Time2 = getResources().getStringArray(R.array.time2);
        Time3 = getResources().getStringArray(R.array.time3);
        Time4 = getResources().getStringArray(R.array.time4);
        Time5 = getResources().getStringArray(R.array.time5);
        Time6 = getResources().getStringArray(R.array.time6);
        Time7 = getResources().getStringArray(R.array.time7);

        String selected_day = weekaeie.sharedPreferences.getString(weekaeie.SEL_DAY, null);

        if(selected_day.equalsIgnoreCase("Monday__")){
            PreferredDay = Monday__;
            PreferredTime = Time1;
        }else if(selected_day.equalsIgnoreCase("Tuesday__")){
            PreferredDay = Tuesday__;
            PreferredTime = Time2;
        }else if(selected_day.equalsIgnoreCase("Wednesday__")){
            PreferredDay = Wednesday__;
            PreferredTime = Time3;
        }else if(selected_day.equalsIgnoreCase("Thursday__")){
            PreferredDay = Thursday__;
            PreferredTime = Time4;
        }else if(selected_day.equalsIgnoreCase("Friday__")){
            PreferredDay = Friday__;
            PreferredTime = Time5;
        }else if(selected_day.equalsIgnoreCase("Saturday__")){
            PreferredDay = Saturday__;
            PreferredTime = Time6;
        }else{
            PreferredDay = Sunday__;
            PreferredTime = Time7;
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(dayaeie.this, PreferredDay, PreferredTime);
        listView.setAdapter(simpleAdapter);

    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView subject, time;
        private String[] subjectArray;
        private String[] timeArray;
        private LetterImageView letterImageView;

        public SimpleAdapter(Context context, String[] subjectArray, String[] timeArray){
            mContext = context;
            this.subjectArray = subjectArray;
            this.timeArray = timeArray;
            layoutInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return subjectArray.length;
        }

        @Override
        public Object getItem(int position) {
            return subjectArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.day_detail_single_item, null);
            }

            subject = (TextView)convertView.findViewById(R.id.tvSubjectDayDetails);
            time = (TextView)convertView.findViewById(R.id.tvTimeDayDetail);
            letterImageView = (LetterImageView)convertView.findViewById(R.id.ivDayDetails);

            subject.setText(subjectArray[position]);
            time.setText(timeArray[position]);

            letterImageView.setOval(true);
            letterImageView.setLetter(subjectArray[position].charAt(0));

            return convertView;

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home : {
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
