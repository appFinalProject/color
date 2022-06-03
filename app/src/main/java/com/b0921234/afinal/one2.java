package com.b0921234.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class one2 extends AppCompatActivity {

    TextView question2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one2);

        question2=(TextView) findViewById(R.id.question2);
        question2.setText("請利用手遮住螢幕、手打開遮住的螢幕、向左傾、向右傾...等動作\n找出毛怪在哪一個顏色的背景中?");
    }
    public void begin2(View view){
        Intent it3=new Intent(this,second2.class);
        startActivity(it3);
    }
}