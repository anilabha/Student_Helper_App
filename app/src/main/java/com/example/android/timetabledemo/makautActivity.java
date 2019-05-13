package com.example.android.timetabledemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class makautActivity extends AppCompatActivity {

    WebView mywebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makaut);

        mywebView=(WebView) findViewById(R.id.webview1);
        WebSettings webSettings=mywebView.getSettings();




        webSettings.setJavaScriptEnabled(true);
        //mywebView.loadUrl("http://makautexam.net/");
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://makautexam.net/")));

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
