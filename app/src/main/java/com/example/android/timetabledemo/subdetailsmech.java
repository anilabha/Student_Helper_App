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

public class subdetailsmech extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_detail);
        setupUIViews();
        initToolbar();
        setupUIViews();
        setupListView();
    }

    private void setupUIViews(){
        toolbar = (Toolbar)findViewById(R.id.ToolbarSubjectDetail);
        listView = (ListView)findViewById(R.id.lvSubjectDetail);

    }
    private void initToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Syllabus");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setupListView() {
        String subject_selected = submech.subjectPreferince.getString(submech.SUB_PREF,null);
        String[] syllabus = new String[]{};

        String[] title = getResources().getStringArray(R.array.title);


        if (subject_selected.equalsIgnoreCase("Numerical_Methods")) {
            syllabus=getResources().getStringArray(R.array.Numerical_Methods);
        }


        else if (subject_selected.equalsIgnoreCase("Fluid_Machanics_and_Hydraulic_Machines")) {
            syllabus=getResources().getStringArray(R.array.Fluid_Machanics_and_Hydraulic_Machines);

        }
        else if (subject_selected.equalsIgnoreCase("Mechanisms")) {
            syllabus=getResources().getStringArray(R.array.Mechanisms);

        }

        else if (subject_selected.equalsIgnoreCase("Primary_Manufacturing_Processes")) {
            syllabus=getResources().getStringArray(R.array.Primary_Manufacturing_Processes);

        }
        else {
            syllabus=getResources().getStringArray(R.array.Mathematics_III);
        }

        SubjectDetailAdapter subjectDetailAdapter=new SubjectDetailAdapter(this, title, syllabus);
        listView.setAdapter(subjectDetailAdapter);

    }

    public class SubjectDetailAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, syllabus;
        private String[] titleArray;
        private String[] syllabusArray;


        public SubjectDetailAdapter(Context context, String[] title, String[] syllabus){
            mContext = context;
            titleArray = title;
            syllabusArray=syllabus;
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
                convertView = layoutInflater.inflate(R.layout.subject_detail_single_item,null);
            }

            title = (TextView)convertView.findViewById(R.id.tvSubjectTitle);
            syllabus = (TextView)convertView.findViewById(R.id.tvSyllabus);


            title.setText(titleArray[position]);
            syllabus.setText(syllabusArray[position]);




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
