package com.example.android.timetabledemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.timetabledemo.Utils.LetterImageView;

public class holiday extends AppCompatActivity {
    private Toolbar toolbar;
    private ListView listView;
    private String[] holidays;
    public static SharedPreferences holidayPreferince;
    public static String HOL_PREF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holiday);
        setupUIViews();
        initToolbar();
        setupListView();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarHoliday);
        listView = (ListView)findViewById(R.id.lvHoliday);
        holidayPreferince = getSharedPreferences("Holidays",MODE_PRIVATE);


    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Holiday");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListView() {
        holidays=getResources().getStringArray(R.array.Holidays);

        HolidayAdapter HolidayAdapter=new HolidayAdapter(this,R.layout.holiday_single_item,holidays);
        listView.setAdapter(HolidayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0: {
                        holidayPreferince.edit().putString(HOL_PREF,"Year_2019").apply();
                        Intent intent = new Intent(holiday.this,holidayDetails.class);
                        startActivity(intent);
                        break;
                    }



                }
            }
        });


    }



    public class HolidayAdapter extends ArrayAdapter {

        private int resource;
        private LayoutInflater layoutInflater;
        private String[] holiday = new String[]{};

        public HolidayAdapter(Context context, int resource, String[] objects) {
            super(context, resource, objects);
            this.resource = resource;
            this.holiday = objects;
            layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;
            if(convertView == null){
                holder = new ViewHolder();
                convertView = layoutInflater.inflate(resource, null);
                holder.ivLogo = (LetterImageView)convertView.findViewById(R.id.ivLetterHoliday);
                holder.tvHoliday = (TextView)convertView.findViewById(R.id.tvHoliday);
                convertView.setTag(holder);
            }else{
                holder = (holiday.HolidayAdapter.ViewHolder)convertView.getTag();
            }

            holder.ivLogo.setOval(true);
            holder.ivLogo.setLetter(holidays[position].charAt(0));
            holder.tvHoliday.setText(holidays[position]);

            return convertView;
        }

        class ViewHolder{
            private LetterImageView ivLogo;
            private TextView tvHoliday;
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
