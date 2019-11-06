package com.example.cs18tty.myfirstapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import allbegray.slack.SlackClientFactory;
import allbegray.slack.webapi.SlackWebApiClient;

public class ResultActivity extends AppCompatActivity {

    private int score = 0;
    private static final String SLACK_TOKEN = "xoxp-763082602722-810189652230-810176879426-3bdcdfd389062952df561dfbf7486951";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent store = getIntent();
        score = store.getIntExtra("score", 0);
    }

    public void shareToSlack(View view) {
        new PostToSlackTask().execute();
    }

    private class PostToSlackTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                SlackWebApiClient webApiClient = SlackClientFactory.createWebApiClient(SLACK_TOKEN);
                webApiClient.postMessage("#test", "Your score is: " + score, "Anthony", true);
            } catch(Error error) {
                Log.e("Slack Error", error.getMessage());
            }
            return null;
        }
    }
}
