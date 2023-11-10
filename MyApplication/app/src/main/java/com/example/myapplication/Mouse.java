package com.example.myapplication;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import java.util.Random;

public class Mouse {
    private final Button mouse;
    private ValueAnimator animator;

    public Mouse(Button mouse) {
        this.mouse = mouse;
        mouse.setVisibility(View.INVISIBLE);
        mouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleOnKilled();
            }
        });
    }

    public void startRunning() {
        mouse.setVisibility(View.VISIBLE);
        Random random = new Random();
        int iRandomValue = random.nextInt(ScreenDimensions.width - 160);
        mouse.setX(iRandomValue);
        iRandomValue = random.nextInt(3000);
        animator = ValueAnimator.ofFloat(-iRandomValue - 500, ScreenDimensions.height - iRandomValue + 5000);
        animator.setDuration(15000 + iRandomValue);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(@NonNull ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                mouse.setY(value);
                if (value > ScreenDimensions.height - 200) {
                    GameInterface.bLose = true;
                }
            }
        });
        animator.start();
    }


    public void stopRunning() {
        mouse.setVisibility(View.INVISIBLE);
        animator.cancel();

    }

    public void handleOnKilled() {
        GameInterface.iScore++;
        animator.cancel();
        startRunning();
    }
}
