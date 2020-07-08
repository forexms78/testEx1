package com.example.mtouch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.text);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int act, index, id;
        act = event.getAction() & 0xff;
        index = (event.getAction() & 0xff00 ) >> 8;

        switch (act){
            case MotionEvent.ACTION_DOWN:
            s = String.format("DOWN id=%d index=%d x=%4.0f y=%4.0f", event.getPointerId(index),index,
                    event.getX(index), event.getY(index));
            tv.setText(s);
                break;
            case MotionEvent.ACTION_UP:
                s = String.format("UP id=%d index=%d x=%4.0f y=%4.0f", event.getPointerId(index),index,
                        event.getX(index), event.getY(index));
                tv.setText(s);
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                s = String.format("POINTER DOWN id=%d index=%d x=%4.0f y=%4.0f", event.getPointerId(index),index,
                        event.getX(index), event.getY(index));
                tv.setText(s);
                break;
            case MotionEvent.ACTION_POINTER_UP:
                s = String.format("POINTER UP id=%d index=%d x=%4.0f y=%4.0f", event.getPointerId(index),index,
                        event.getX(index), event.getY(index));
                tv.setText(s);
                break;
        }
        return super.onTouchEvent(event);
    }
}
