package com.b0921234.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class finalscore extends AppCompatActivity {

    int score=0;
int fin3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalscore);
        TextView final_score=(TextView)findViewById(R.id.final_score);

       // Intent fin2=getIntent();
        //int final1=fin2.getIntExtra("分數1",0);

        //Intent fin4=getIntent();
        //int final2=fin4.getIntExtra("分數2",0);

       Intent it6=getIntent();
        fin3=it6.getIntExtra("分數3",0);
//
//       score=final3;

        final_score.setText("總分為 :"+fin3);


    }
}