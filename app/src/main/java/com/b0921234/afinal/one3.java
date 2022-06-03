package com.b0921234.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class one3 extends AppCompatActivity {

    TextView question3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one3);

        question3=findViewById(R.id.question3);
        question3.setText("輕觸螢幕、向右傾、手遮住螢幕、向左傾、手打開遮住的螢幕");
    }
    public void begin3(View view){
        Intent it5=new Intent(this,second3.class);
        startActivity(it5);
    }
}