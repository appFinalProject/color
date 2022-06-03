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
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class second3 extends AppCompatActivity implements SensorEventListener,View.OnTouchListener {
    SensorManager sm3;
    EditText answer3;
    Sensor psr3, gsr3;
    View layout3;
    Button confirm3, next3;
    TextView txv3, end3;
    int count3 = 0;
    String correct3 = "粉黃紅藍綠";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second3);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        layout3 = findViewById(R.id.layout3);
        txv3 = findViewById(R.id.txv3);
        end3 = findViewById(R.id.end3);
        confirm3 = findViewById(R.id.confirm3);
        next3 = findViewById(R.id.next3);
        answer3 = findViewById(R.id.answer3);

        sm3 = (SensorManager) getSystemService(SENSOR_SERVICE);
        psr3 = sm3.getDefaultSensor(Sensor.TYPE_PROXIMITY);  //接近感測器

        gsr3 = sm3.getDefaultSensor(Sensor.TYPE_GYROSCOPE);  //陀螺儀
        layout3.setOnTouchListener(this);



        new CountDownTimer(5000, 4000) {

            public void onTick(long millisUntilFinished) {
                txv3.setText("倒數 " + millisUntilFinished / 3000 + "秒");
            }

            public void onFinish() {
                txv3.setText("時間到");
                count3++;
                confirm3.setVisibility(View.VISIBLE);
                answer3.setVisibility(View.VISIBLE);
                end3.setVisibility(View.VISIBLE);
                layout3.setBackgroundResource((R.drawable.bgr));

            }
        }.start();
    }

    SensorEventListener gyroscopeSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {

            if (event.values[2] > 0.5f) {
                if (count3 == 0) {
                    layout3.setBackgroundColor(Color.BLUE);   //左
                } else if (count3 == 1) {
                    layout3.setBackgroundColor(Color.WHITE);

                }
            } else if (event.values[2] < -0.5f) {
                if (count3 == 0) {
                    layout3.setBackgroundColor(Color.YELLOW);   //右
                } else if (count3 == 1) {
                    layout3.setBackgroundColor(Color.WHITE);

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
            if (event.values[0] < psr3.getMaximumRange()) {
                if (count3 == 0) {
                    layout3.setBackgroundColor(Color.RED);  //遮
                } else if (count3 == 1) {
                    layout3.setBackgroundColor(Color.WHITE);
                }
            } else {
                if (count3 == 0) {
                    layout3.setBackgroundColor(Color.GREEN);   //放
                } else if (count3 == 1) {
                    layout3.setBackgroundColor(Color.WHITE);

                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    protected void onResume() {
        second3.super.onResume();
        sm3.registerListener(gyroscopeSensorListener, gsr3, SensorManager
                .SENSOR_DELAY_NORMAL);
        sm3.registerListener(proximitySensorListener, psr3, 2 * 1000 * 1000);

    }

    protected void onPause() {
        second3.super.onPause();
        sm3.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void confirm3(View view) {
        String input = answer3.getText().toString().trim();
        if (input.equals(correct3)) {
            end3.setText("答案正確!!!!");
            next3.setVisibility(View.VISIBLE);
            layout3.setBackgroundResource((R.drawable.bgr));

        } else {
            end3.setText("答案錯誤\n返回上一頁再試一次");
            layout3.setBackgroundResource((R.drawable.bgr));
        }
    }

    public void next3(View view) {
        finish();
    }



    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            layout3.setBackgroundColor(Color.parseColor("#FF00FF"));

        }
        else if (event.getAction() == MotionEvent.ACTION_MOVE) {
            layout3.setBackgroundColor(Color.parseColor("#FF00FF"));
        }
        else if (event.getAction() == MotionEvent.ACTION_UP) {
            layout3.setBackgroundColor(Color.WHITE);
        }
            return false;

    }
}
