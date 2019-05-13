package com.example.android.timetabledemo;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class contact extends AppCompatActivity {

    WebView mywebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        mywebView = (WebView) findViewById(R.id.CContact);
        WebSettings webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://anilabha91.wixsite.com/mysite")));



    }
}

