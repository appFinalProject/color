package com.b0921234.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txv=findViewById(R.id.line);
        txv.setText("按照螢幕上的手勢順序做出相對應的動作，再將出現的顏色逐一填至空格中");


    }
    public void start(View view){
        Intent it0=new Intent(this,one1.class);
        startActivity(it0);}
}