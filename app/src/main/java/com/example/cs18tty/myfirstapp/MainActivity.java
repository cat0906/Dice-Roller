package com.example.cs18tty.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int score = 0;
    public static final int DICE_REQUEST_CODE = 1337;
    private List<String> questions = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arrQuestions = {
                "If you could go anywhere in the world, where would you go?",
                "If you were stranded on a desert island, what three things would you take with you?",
                "If you could eat only one food for the rest of your life, what would that be?",
                "If you won a million dollars, what is the first thing you would buy?",
                "If you could spend a day with one fictional character, who would it be?",
                "If you found a magic lantern and a genie gave you three wishes, what would you wish?"
        };
        for(String question : arrQuestions) {
            questions.add(question);
        }
    }

    public void on_button_click(View view){
        EditText guessInput = (EditText) this.findViewById(R.id.guessInput);
        TextView tv = (TextView) this.findViewById(R.id.numberTextView); //(import class)

        int randomNum = roll_the_dice();

        String guessString = guessInput.getText().toString();
        int guess = guessString.equals("") ? 0 : Integer.valueOf(guessString);

        if(randomNum == guess) {
            correctGuess();
        }

        tv.setText(Integer.toString(randomNum)); //(change onClick to on_button_click)
        //(change to roll the dice) -> start (change to Integer.toString(number))
    }

    public void dIcebreaker(View view) {
        int randomIndex = (int) Math.floor(Math.random() * questions.size());
        String question = questions.get(randomIndex);
        popup("Question", question);
    }

    public void addDIce(View view) {
        Intent intent = new Intent(this, RuleActivity.class);
        startActivityForResult(intent, DICE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == DICE_REQUEST_CODE) {
            if(resultCode == RESULT_OK) {

                String question = data.getStringExtra("question");
                questions.add(question);
            }
        }
    }

    private void correctGuess() {
        TextView scoreTV = (TextView) this.findViewById(R.id.score);

        score++;

        popup("Congratulations", "You guessed correctly! Score: " + score);

        scoreTV.setText("Score: " + score);
    }

    private void popup(String title, String msg) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(title);
        dialog.setMessage(msg);
        dialog.show();
    }

    private int roll_the_dice() {
        int randomNum = (int)Math.ceil(Math.random() * 6);
        return randomNum;
    }

    public void finishGame(View view) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
    }
}
