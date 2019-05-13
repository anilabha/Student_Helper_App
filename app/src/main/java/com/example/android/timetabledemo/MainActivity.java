package com.example.android.timetabledemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();
        initToolbar();
        setupListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);



        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        int id=item.getItemId();
        switch (id){
            case R.id.info:{ Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
                break;

            }
            case R.id.contact:{
                Intent intent = new Intent(MainActivity.this, contact.class);
                startActivity(intent);
                break;
            }

            case R.id.wp:{
                Intent intent = new Intent(MainActivity.this, whatsapp.class);
                startActivity(intent);
                break;
            }

            case R.id.googleform:{
                Intent intent = new Intent(MainActivity.this, googlefrom.class);
                startActivity(intent);
                break;
            }


        }
        return true;
    }

    private void getOverflowMenu() {

        try {

            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarMain);
        listView = (ListView)findViewById(R.id.lvMain);
    }



    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Student Helper");
    }

    private void setupListView(){

        String[] title = getResources().getStringArray(R.array.Main);
        String[] description = getResources().getStringArray(R.array.Description);

        SimpleAdapter simpleAdapter = new SimpleAdapter(this, title, description);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0: {
                        Intent intent = new Intent(MainActivity.this, dept.class);
                        startActivity(intent);
                        break;
                    }
                    case 1: { Intent intent = new Intent(MainActivity.this, subdept.class);
                        startActivity(intent);
                        break;
                    }
                    case 2: { Intent intent = new Intent(MainActivity.this, facultydept.class);
                        startActivity(intent);
                        break;
                    }


                    case 3: { Intent intent = new Intent(MainActivity.this, web.class);
                        startActivity(intent);
                        break;
                    }

                    case 4: { Intent intent = new Intent(MainActivity.this, holiday.class);
                        startActivity(intent);
                        break;
                    }
                    case 5: { Intent intent = new Intent(MainActivity.this, makautActivity.class);
                        startActivity(intent);
                        break;
                    }
                    case 6: { Intent intent = new Intent(MainActivity.this, nptel.class);
                        startActivity(intent);
                        break;
                    }
                    case 7: { Intent intent = new Intent(MainActivity.this, youtube.class);
                        startActivity(intent);
                        break;
                    }
                    case 8: { Intent intent = new Intent(MainActivity.this, mywbut.class);
                        startActivity(intent);
                        break;
                    }

                    case 9: { Intent intent = new Intent(MainActivity.this, calculator.class);
                        startActivity(intent);
                        break;
                    }

                    case 10: { Intent intent = new Intent(MainActivity.this, steamtable.class);
                        startActivity(intent);
                        break;
                    }


                }
            }
        });
    }

    public class SimpleAdapter extends BaseAdapter{

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, description;
        private String[] titleArray;
        private String[] descriptionArray;
        private ImageView imageView;
        private WebView webView;

        public SimpleAdapter(Context context, String[] title, String[] description){
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
            if(convertView == null){
                convertView = layoutInflater.inflate(R.layout.main_activity_single_item,null);
            }

            title = (TextView)convertView.findViewById(R.id.tvMain);
            description = (TextView)convertView.findViewById(R.id.tvDescription);
            imageView = (ImageView)convertView.findViewById(R.id.ivMain);

            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);

            if(titleArray[position].equalsIgnoreCase("Timetable")){
                imageView.setImageResource(R.drawable.timetable);
            }else if (titleArray[position].equalsIgnoreCase("Subjects")){
                imageView.setImageResource(R.drawable.book);
            }

            else if (titleArray[position].equalsIgnoreCase("Learn Programming")){
                imageView.setImageResource(R.drawable.play_i);
            }

            else if (titleArray[position].equalsIgnoreCase("Holidays")){
                imageView.setImageResource(R.drawable.download);
            }
            else if (titleArray[position].equalsIgnoreCase("MAKAUT Website")){
                imageView.setImageResource(R.drawable.wbutlogo);
            }
            else if (titleArray[position].equalsIgnoreCase("NPTEL Online Courses")){
                imageView.setImageResource(R.drawable.nlogo);

            }
            else if(titleArray[position].equalsIgnoreCase("Link To My Youtube Channel")) {
                imageView.setImageResource(R.drawable.link);

            }
            else if (titleArray[position].equalsIgnoreCase("Learn Onine")) {
                imageView.setImageResource(R.drawable.mywbutlogo);

            }

            else if (titleArray[position].equalsIgnoreCase("Scientific Calculator")) {
                imageView.setImageResource(R.drawable.sintificcalc);

            }

            else if (titleArray[position].equalsIgnoreCase("Steam-Table")) {
                imageView.setImageResource(R.drawable.steam);

            }

            else {
                imageView.setImageResource(R.drawable.fac);
            }

            return convertView;

        }
    }

}
