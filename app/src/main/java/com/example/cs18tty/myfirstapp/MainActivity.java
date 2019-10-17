package com.example.cs18tty.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void on_button_click(View view){


        TextView tv = (TextView) this.findViewById(R.id.numberTextView); //(import class)
        Random r = new Random();
        int number = r.nextInt(6);

        tv.setText(Integer.toString(number)); //(change onClick to on_button_click)
        //(change to roll the dice) -> start (change to Integer.toString(number))
    }
}
