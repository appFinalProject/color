package com.b0921234.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class one1 extends AppCompatActivity {

    TextView question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one1);

        question=(TextView) findViewById(R.id.question);
        question.setText("手遮住螢幕、手打開遮住的螢幕、向左傾、向右傾、向左傾");
    }
    public void begin(View view){
        Intent it1=new Intent(this,second1.class);
        startActivity(it1);
    }
}