package com.example.cs18tty.myfirstapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void on_button_click(View view){
        EditText guessInput = (EditText) this.findViewById(R.id.guessInput);
        TextView tv = (TextView) this.findViewById(R.id.numberTextView); //(import class)

        int randomNum = (int)Math.ceil(Math.random() * 6);
        int guess = Integer.valueOf(guessInput.getText().toString());

        if(randomNum == guess) {
            correctGuess();
        }

        tv.setText(Integer.toString(randomNum)); //(change onClick to on_button_click)
        //(change to roll the dice) -> start (change to Integer.toString(number))
    }

    private void correctGuess() {
        TextView scoreTV = (TextView) this.findViewById(R.id.score);

        score++;

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Congratulations");
        dialog.setMessage("You guessed correctly! Score: " + score);
        dialog.show();

        scoreTV.setText("Score: " + String.valueOf(score));
    }
}
