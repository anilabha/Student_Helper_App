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


public class facaeie extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        setupUIViews();
        initToolbar();
        setupListView();
    }





    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarMain);
        listView = (ListView)findViewById(R.id.lvMain);
    }



    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Faculty Of AEIE Dept.");
    }

    private void setupListView(){

        String[] title = getResources().getStringArray(R.array.facaeie);
        String[] description = getResources().getStringArray(R.array.aeiefacdetails);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title, description);
        listView.setAdapter(simpleAdapter);



    }

    public class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, description;
        private String[] titleArray;
        private String[] descriptionArray;
        private ImageView imageView;


        public SimpleAdapter(Context context, String[] title, String[] description) {
            mContext = context;
            titleArray = title;
            descriptionArray = description;
            layoutInflater = LayoutInflater.from(mContext);
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
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.teacher_details_single_item, null);
            }

            title = (TextView) convertView.findViewById(R.id.tvMain);
            description = (TextView) convertView.findViewById(R.id.tvDescription);
            imageView = (ImageView) convertView.findViewById(R.id.ivMain);

            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);

            if (titleArray[position].equalsIgnoreCase("Mr. Jyotirmoy Gupta")) {
                imageView.setImageResource(R.drawable.jg);
            } else if (titleArray[position].equalsIgnoreCase("Mr. Swapan Das")) {
                imageView.setImageResource(R.drawable.swapan);
            } else if (titleArray[position].equalsIgnoreCase("Dr. Samik Marick")) {
                imageView.setImageResource(R.drawable.smmm);
            } else if (titleArray[position].equalsIgnoreCase("Mr. Dipankar Mandal")) {
                imageView.setImageResource(R.drawable.dm);
            } else if (titleArray[position].equalsIgnoreCase("Mr. Milan Dhara")) {
                imageView.setImageResource(R.drawable.milan);

            }
            else {
                imageView.setImageResource(R.drawable.sb);
            }


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
