package com.example.android.timetabledemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class holidayDetails extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday_details);
        setupUIViews();
        initToolbar();
        setupUIViews();
        setupListView();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarHolidayDetail);
        listView = (ListView)findViewById(R.id.lvHolidayDetail);

    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Holiday");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListView() {
        String holiday_selected = holiday.holidayPreferince.getString(holiday.HOL_PREF,null);
        String[] holiday = new String[]{};

        String[] title = getResources().getStringArray(R.array.holtitle);


        if (holiday_selected.equalsIgnoreCase("Year_2019")) {
            holiday=getResources().getStringArray(R.array.Year_2019);
        }


        HolidayDetailAdapter HolidaydetailAdapter=new HolidayDetailAdapter(this, title, holiday);
        listView.setAdapter(HolidaydetailAdapter);



    }

    public class HolidayDetailAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, holiday;
        private String[] titleArray;
        private String[] holidayArray;


        public HolidayDetailAdapter(Context context, String[] title, String[] holiday){
            mContext = context;
            titleArray = title;
            holidayArray=holiday;
            layoutInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.holiday_detais_single_activity,null);
            }

            title = (TextView)convertView.findViewById(R.id.tvHolidayTitle);
            holiday = (TextView)convertView.findViewById(R.id.tvHoliday);


            title.setText(titleArray[position]);
            holiday.setText(holidayArray[position]);




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
