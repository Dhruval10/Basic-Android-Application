package com.example.practicalexam127;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Database.DatabaseHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText idv,namev,semv,branchv;

    Button savee;

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        idv = (EditText)findViewById(R.id.id);
        namev = (EditText)findViewById(R.id.name);
        semv = (EditText)findViewById(R.id.sem);
        branchv = (EditText)findViewById(R.id.branch);

        savee = (Button)findViewById(R.id.save);

        db = new DatabaseHelper(this);

        savee.setOnClickListener(this);

    }

    public void onClick(View v) {



        String idval = idv.getText().toString();
        String nameval = namev.getText().toString();
        String semval = semv.getText().toString();
        String branchval = branchv.getText().toString();

        long idd = db.insertInfo(idval, nameval, semval, branchval);


        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT ).show();

        final Intent j = new Intent(this, Display.class);
        j.putExtra( "idd",idd );
        startActivity(j);

    }
}
