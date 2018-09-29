package com.example.footballscoreclicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int MIN_BTN_PRESS_DELAY = 1500;
    private Integer tag_first_counter = 0;
    private Integer tag_second_counter = 0;
    private long lastPressTime = 0;
    private static final String TAG = "StartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
        redrawNumber();
    }

    @Override
    public void onClick(View v) {
        //counter++;
        //if (System.currentTimeMillis() - lastPressTime > MIN_BTN_PRESS_DELAY) {
            switch (v.getId()) {
                case R.id.add_tag1_btn:
                    tag_first_counter++;
                    break;
                case R.id.add_tag2_btn:
                    tag_second_counter++;
                    break;
                case R.id.reset_button:
                    tag_first_counter = 0;
                    tag_second_counter = 0;
                    break;
            }
            lastPressTime = System.currentTimeMillis();
       //} else {
            /*findViewById(R.id.add_tag1_btn).setEnabled(false);
            findViewById(R.id.add_tag2_btn).setEnabled(false);
            findViewById(R.id.reset_button).setEnabled(false);*/

            //Toast.makeText(this, getString(R.string.too_fast_notify), Toast.LENGTH_SHORT).show();
        //}
        redrawNumber();
    }

    private void redrawNumber() {
        TextView tag1View = findViewById(R.id.tag_first_txt);
        TextView tag2View = findViewById(R.id.tag_second_txt);
        tag1View.setText(tag_first_counter.toString());
        tag2View.setText(tag_second_counter.toString());
    }

    private float dpFromPx(float px) {
        return px / getApplicationContext().getResources().getDisplayMetrics().density;
    }

    private float pxFromDp(float dp) {
        return dp * getApplicationContext().getResources().getDisplayMetrics().density;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tag1_counter", tag_first_counter);
        outState.putInt("tag2_counter", tag_second_counter);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("tag1_counter") && savedInstanceState.containsKey("tag2_counter")) {
           // counter = savedInstanceState.getInt("counter");
            tag_first_counter = savedInstanceState.getInt("tag1_counter");
            tag_second_counter = savedInstanceState.getInt("tag2_counter");
            redrawNumber();
        }
        Log.d(TAG, "onRestoreInstanceState");
    }


}
