package com.example.practicalexam127;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import Database.DatabaseHelper;
import Database.model.Info;

public class Display extends AppCompatActivity {

    TextView ans;

    private DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_display );

        ans = findViewById( R.id.textView );

        long idd = getIntent().getExtras().getLong("idd");
        Info t = db.getInfo( idd );

        ans.setText(t.gId());


    }
}
