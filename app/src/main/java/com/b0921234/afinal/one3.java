package com.b0921234.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class one3 extends AppCompatActivity {

    TextView question3;
int sum3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one3);

        question3=findViewById(R.id.question3);
        question3.setText("向右傾、手遮住螢幕、向左傾、手打開遮住的螢幕、輕觸螢幕");
        Intent it4=getIntent();
        int end33=it4.getIntExtra("分數2",0);
        sum3=end33;

    }
    public void begin3(View view){
        Intent it5=new Intent(this,second3.class);
        startActivity(it5);

        it5.putExtra("分數2",sum3);
        startActivity(it5);

    }
}