package com.example.cs18tty.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RuleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);
    }

    public void saveQuestion(View view) {
        Intent data = new Intent();

        EditText questionInput = (EditText) findViewById(R.id.questionInput);
        String question = questionInput.getText().toString();
        data.putExtra("question", question);

        setResult(RESULT_OK, data);
        finish();
    }

    public void cancelQuestion(View view) {
        finish();
    }
}
