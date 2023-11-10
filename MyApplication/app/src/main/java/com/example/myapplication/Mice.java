package com.example.myapplication;

import android.app.Activity;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Mice {
    private final List<Mouse> mice;
    private final Activity activity;

    public Mice(Activity activity) {
        this.activity = activity;
        this.mice = new ArrayList<>();
        findAllMice();
    }

    public void findAllMice() {
        Button buttonMouse = (Button) activity.findViewById(R.id.buttonMouse);
        mice.add(new Mouse(buttonMouse));
        buttonMouse = (Button) activity.findViewById(R.id.buttonMouse2);
        mice.add(new Mouse(buttonMouse));
        buttonMouse = (Button) activity.findViewById(R.id.buttonMouse3);
        mice.add(new Mouse(buttonMouse));
        buttonMouse = (Button) activity.findViewById(R.id.buttonMouse4);
        mice.add(new Mouse(buttonMouse));
        buttonMouse = (Button) activity.findViewById(R.id.buttonMouse5);
        mice.add(new Mouse(buttonMouse));
        buttonMouse = (Button) activity.findViewById(R.id.buttonMouse6);
        mice.add(new Mouse(buttonMouse));
        buttonMouse = (Button) activity.findViewById(R.id.buttonMouse7);
        mice.add(new Mouse(buttonMouse));
        buttonMouse = (Button) activity.findViewById(R.id.buttonMouse8);
        mice.add(new Mouse(buttonMouse));
        buttonMouse = (Button) activity.findViewById(R.id.buttonMouse9);
        mice.add(new Mouse(buttonMouse));
        buttonMouse = (Button) activity.findViewById(R.id.buttonMouse10);
        mice.add(new Mouse(buttonMouse));
    }

        public void startAllMice() {
        for (Mouse mouse : mice) {
            mouse.startRunning();
        }
    }

    public void stopAllMice() {
        for (Mouse mouse : mice) {
            mouse.stopRunning();
        }
    }
}
