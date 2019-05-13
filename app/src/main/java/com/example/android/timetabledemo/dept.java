package com.example.android.timetabledemo;

import android.content.Context;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class dept extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept);

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
        getSupportActionBar().setTitle("Department");
    }



   private void setupListView() {

       String[] title = getResources().getStringArray(R.array.dept);
       String[] description = getResources().getStringArray(R.array.desc);

       SimpleAdapter simpleAdapter = new SimpleAdapter(this, title, description);
       listView.setAdapter(simpleAdapter);

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               switch(position){
                   case 0: {
                       Intent intent = new Intent(dept.this, WeekActivity.class);
                       startActivity(intent);
                       break;
                   }
                   case 1: {
                       Intent intent = new Intent(dept.this, weekmech.class);
                       startActivity(intent);
                       break;
                   }
                   case 2: {
                       Intent intent = new Intent(dept.this, weekaeie.class);
                       startActivity(intent);
                       break;
                   }






               }
           }
       });


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
                convertView = layoutInflater.inflate(R.layout.dept_single_item, null);
            }

            title = (TextView) convertView.findViewById(R.id.tvMain);
            description = (TextView) convertView.findViewById(R.id.tvDescription);
            imageView = (ImageView) convertView.findViewById(R.id.ivMain);

            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);

            if (titleArray[position].equalsIgnoreCase("Electrical")) {
                imageView.setImageResource(R.drawable.ee);
            }
            else if (titleArray[position].equalsIgnoreCase("AEIE")) {
                imageView.setImageResource(R.drawable.aeie);
            }

            else {
                imageView.setImageResource(R.drawable.mech);
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
