package com.harun.swipetorefreshlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Random;

// https://harun.xyz/
public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener  {

    private TextView sayiBelirle;

    private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sayiBelirle = findViewById(R.id.sayiBelirle);
        swipeRefresh = findViewById(R.id.swipeRefresh);

        swipeRefresh.setOnRefreshListener(this);
        swipeRefresh.setColorSchemeResources(R.color.colorAccent,
                android.R.color.holo_green_dark,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_dark);

    }


    @Override
    public void onRefresh() {

        new CountDownTimer(2000,1000){

            @Override
            public void onTick(long millisUntilFinished) {}

            @Override
            public void onFinish() {

                sayiBelirle.setText(String.valueOf(new Random().nextInt(50)));
                swipeRefresh.setRefreshing(false);

            }

        }.start();

    }

}
