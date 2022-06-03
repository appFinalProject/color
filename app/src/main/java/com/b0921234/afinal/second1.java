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
import android.widget.TextView;

public class second1 extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    EditText answer;
    Sensor psr, gsr;
    View layout;
    Button confirm,next;
    TextView txv,end;
    int count = 0;

    String correct="紅綠藍黃藍";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second1);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        layout = findViewById(R.id.layout);
        txv =findViewById(R.id.txv);
        end=findViewById(R.id.end);
        confirm=findViewById(R.id.confirm);
        next=findViewById(R.id.next);
        answer=findViewById(R.id.answer);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        psr = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);  //接近感測器

        gsr = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);  //陀螺儀




        new CountDownTimer(5000, 3000) {

            public void onTick(long millisUntilFinished) {
                txv.setText("倒數 " + millisUntilFinished / 3000 + "秒");
            }

            public void onFinish() {
                txv.setText("時間到");
                count++;
                confirm.setVisibility(View.VISIBLE);
                answer.setVisibility(View.VISIBLE);
                end.setVisibility(View.VISIBLE);
                layout.setBackgroundResource((R.drawable.bgr));

            }
        }.start();
    }

    SensorEventListener gyroscopeSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {

            if (event.values[2] > 0.5f) {
                if (count == 0) {
                    layout.setBackgroundColor(Color.BLUE);   //左
                } else if (count == 1) {
                    layout.setBackgroundColor(Color.WHITE);

                }
            } else if (event.values[2] < -0.5f) {
                if (count == 0) {
                    layout.setBackgroundColor(Color.YELLOW);   //右
                } else if (count == 1) {
                    layout.setBackgroundColor(Color.WHITE);

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
            if (event.values[0] < psr.getMaximumRange()) {
                if (count == 0) {
                    layout.setBackgroundColor(Color.RED);  //遮
                } else if (count == 1) {
                    layout.setBackgroundColor(Color.WHITE);

                }
            } else {
                if (count == 0) {
                    layout.setBackgroundColor(Color.GREEN);   //放
                }
                else if (count == 1) {
                    layout.setBackgroundColor(Color.WHITE);

                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
    protected void onResume() {
        second1.super.onResume();
        sm.registerListener(gyroscopeSensorListener, gsr, SensorManager
                .SENSOR_DELAY_NORMAL);
        sm.registerListener(proximitySensorListener, psr, 2 * 1000 * 1000);

    }

    protected void onPause() {
        second1.super.onPause();
        sm.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    public void next(View view){
        Intent it2=new Intent(this,one2.class);
        startActivity(it2);
    }

    public void confirm(View view){
        String input=answer.getText().toString().trim();
        if(input.equals(correct)){
            end.setText("答案正確!!!!!");
            next.setVisibility(View.VISIBLE);
            layout.setBackgroundResource((R.drawable.bgr));

        }else{
            end.setText("答案錯誤\n返回上一頁再試一次");
            layout.setBackgroundResource((R.drawable.bgr));
        }
    }

}