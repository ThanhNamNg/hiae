package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.Group;

import java.util.Timer;
import java.util.TimerTask;

public class GameInterface {
    private final SharedPreferences sharedPreferences;
    private final SharedPreferences.Editor editor;
    private final Activity activity;
    private TextView textViewScore;
    private TextView textviewTime;
    private TextView textViewHighScore;
    private Group viewGroupMenu;
    private Button buttonPlay;
    public static int iScore;
    public static int iTime;
    public static boolean bLose;
    private Timer timer;
    private final Mice mice;

    public GameInterface(Activity activity) {
        this.activity = activity;
        this.sharedPreferences = activity.getSharedPreferences("Score", Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
        this.mice = new Mice(activity);
        iTime = 0;
        iScore = 0;
        bLose = false;
        findAllViewsByID();
    }

    public void startGame() {
        mice.startAllMice();
        startTimer();
        bLose = false;
        viewGroupMenu.setVisibility(View.INVISIBLE);
    }

    public void stopGame() {
        checkAndUpdateHighScore();
        mice.stopAllMice();
        stopTimer();
        bLose = false;
        viewGroupMenu.setVisibility(View.VISIBLE);

    }

    public void findAllViewsByID() {
        this.textViewHighScore = (TextView) activity.findViewById(R.id.textViewHighScore);
        this.textViewScore = (TextView) activity.findViewById(R.id.textViewScore);
        this.textviewTime = (TextView) activity.findViewById(R.id.textViewTime);
        this.buttonPlay = (Button) activity.findViewById(R.id.buttonPlay);
        this.viewGroupMenu = (Group) activity.findViewById(R.id.viewGroupMenu);

        textViewHighScore.setText(String.valueOf(sharedPreferences.getInt("HighScore",0)));
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });
    }

    public void startTimer() {
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iTime++;
                        textViewScore.setText(String.valueOf(iScore));
                        textviewTime.setText(String.valueOf(iTime / 10));
                        if (bLose){
                            stopGame();
                        }
                    }
                });
            }
        }, 0, 100);
    }

    public void stopTimer() {
        timer.cancel();
        iTime = 0;
        iScore = 0;
    }

    public void checkAndUpdateHighScore(){
        int iHighScore = sharedPreferences.getInt("HighScore", 0);
        if (iScore > iHighScore){
            iHighScore = iScore;
            editor.putInt("HighScore", iHighScore);
            editor.apply();
        }
        textViewHighScore.setText(String.valueOf(iHighScore));
    }
}
