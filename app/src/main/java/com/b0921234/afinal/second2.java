package com.b0921234.afinal;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class second2 extends AppCompatActivity implements SensorEventListener {
    SensorManager sm2;
    EditText answer2;
    Sensor psr2, gsr2;
    View layout2;
    Button confirm2,next2;
    TextView txv2,end2;
    int count2 = 0;
    String correct2="藍";
    ImageView imageView,imageView2,imageView3,imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        layout2 = findViewById(R.id.layout2);
        txv2 =findViewById(R.id.txv2);
        end2=findViewById(R.id.end2);
        confirm2=findViewById(R.id.confirm2);
        next2=findViewById(R.id.next2);
        answer2=findViewById(R.id.answer2);

        sm2 = (SensorManager) getSystemService(SENSOR_SERVICE);
        psr2 = sm2.getDefaultSensor(Sensor.TYPE_PROXIMITY);  //接近感測器

        gsr2 = sm2.getDefaultSensor(Sensor.TYPE_GYROSCOPE);  //陀螺儀


        new CountDownTimer(5000, 4000) {

            public void onTick(long millisUntilFinished) {
                txv2.setText("倒數 " + millisUntilFinished / 3000 + "秒");
            }

            public void onFinish() {
                txv2.setText("時間到");
                count2++;
                confirm2.setVisibility(View.VISIBLE);
                answer2.setVisibility(View.VISIBLE);
                end2.setVisibility(View.VISIBLE);
                layout2.setBackgroundResource((R.drawable.bgr));

            }
        }.start();
    }

    SensorEventListener gyroscopeSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {

            if (event.values[2] > 0.5f) {
                if (count2 == 0) {
                   // layout2.setBackgroundColor(Color.BLUE);   //左
                    imageView.setVisibility(View.VISIBLE);
                    imageView2.setVisibility(View.GONE);
                    imageView3.setVisibility(View.GONE);
                    imageView4.setVisibility(View.GONE);
                }
                else if (count2 == 1) {
                ///    layout2.setBackgroundColor(Color.WHITE);

                }
            } else if (event.values[2] < -0.5f) {
                if (count2 == 0) {
                 // layout2.setBackgroundColor(Color.YELLOW);   //右
                    imageView2.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.GONE);
                    imageView3.setVisibility(View.GONE);
                    imageView4.setVisibility(View.GONE);
                }
                else if (count2 == 1) {
                  layout2.setBackgroundColor(Color.WHITE);

                }
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };


    SensorEventListener proximitySensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.values[0] < psr2.getMaximumRange()) {
                if (count2 == 0) {
                  //  layout2.setBackgroundColor(Color.RED);  //遮
                    imageView3.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.GONE);
                    imageView2.setVisibility(View.GONE);
                    imageView4.setVisibility(View.GONE);
                } else if (count2 == 1) {
                    layout2.setBackgroundColor(Color.WHITE);
                }
            } else {
                if (count2 == 0) {
                 //  layout2.setBackgroundColor(Color.GREEN);   //放
                    imageView4.setVisibility(View.VISIBLE);
                    imageView.setVisibility(View.GONE);
                    imageView2.setVisibility(View.GONE);
                    imageView3.setVisibility(View.GONE);
                }
                else if (count2 == 1) {
                  //  layout2.setBackgroundColor(Color.WHITE);

                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    protected void onResume() {
        second2.super.onResume();
        sm2.registerListener(gyroscopeSensorListener, gsr2, SensorManager
                .SENSOR_DELAY_NORMAL);
        sm2.registerListener(proximitySensorListener, psr2, 2 * 1000 * 1000);

    }

    protected void onPause() {
        second2.super.onPause();
        sm2.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public void confirm2(View view){
        String input=answer2.getText().toString().trim();
        if(input.equals(correct2)){
            end2.setText("答案正確!!!!");
            next2.setVisibility(View.VISIBLE);
            layout2.setBackgroundResource((R.drawable.bgr));

        }else{
            end2.setText("答案錯誤\n返回上一頁再試一次");
            layout2.setBackgroundResource((R.drawable.bgr));
        }
    }
    public void next2(View view){
        Intent it4=new Intent(this,one3.class);
        startActivity(it4);
    }
}