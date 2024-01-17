package com.liocosoft.liocoflashcontroller;

import android.graphics.Color;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class ScreenLightController {
    private View viewColorDisplay;
    private Window window;
    private Thread screenDanceThread;
    private boolean isScreenDanceRunning = false;

    public ScreenLightController(View viewColorDisplay, Window window) {
        this.viewColorDisplay = viewColorDisplay;
        this.window = window;
    }

    private void setMaxScreenBrightness() {
        if (window != null) {
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_FULL;
            window.setAttributes(layoutParams);
            window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }

    private void resetScreenBrightness() {
        if (window != null) {
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.screenBrightness = WindowManager.LayoutParams.BRIGHTNESS_OVERRIDE_NONE;
            window.setAttributes(layoutParams);
            window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }

    public void setColor(int color) {
        setMaxScreenBrightness();
        viewColorDisplay.setVisibility(View.VISIBLE);
        viewColorDisplay.setBackgroundColor(color);
    }

    public void changeColor(int color) {
        viewColorDisplay.setBackgroundColor(color);
    }

    public void resetColor() {
        viewColorDisplay.setVisibility(View.INVISIBLE);
        resetScreenBrightness();
        if (isScreenDanceRunning && screenDanceThread != null) {
            isScreenDanceRunning = false;
            try {
                screenDanceThread.join();
            } catch (InterruptedException e) {
                screenDanceThread.interrupt();
            } finally {
                screenDanceThread = null;
            }
        }
    }

    public void randomBlink() {
        if (!isScreenDanceRunning) {
            isScreenDanceRunning = true;
            setColor(Color.BLACK);
            screenDanceThread = new Thread(() -> {
                do {
                    changeColor(Color.WHITE);
                    sleep((int) (Math.random() * 500) + 100);
                    changeColor(Color.BLACK);
                    sleep((int) (Math.random() * 500) + 100);
                } while (isScreenDanceRunning);
                isScreenDanceRunning = false;
            });
            screenDanceThread.start();
        }
    }

    public void alternatingBlink() {
        if (!isScreenDanceRunning) {
            isScreenDanceRunning = true;
            setColor(Color.BLACK);
            screenDanceThread = new Thread(() -> {
                do {
                    changeColor(Color.WHITE);
                    sleep(300);
                    changeColor(Color.BLACK);
                    sleep(300);
                } while (isScreenDanceRunning);
                isScreenDanceRunning = false;
            });
            screenDanceThread.start();
        }
    }

    public void fastBlink() {
        if (!isScreenDanceRunning) {
            isScreenDanceRunning = true;
            setColor(Color.BLACK);
            screenDanceThread = new Thread(() -> {
                do {
                    changeColor(Color.WHITE);
                    sleep(100);
                    changeColor(Color.BLACK);
                    sleep(100);
                } while (isScreenDanceRunning);
                isScreenDanceRunning = false;
            });
            screenDanceThread.start();
        }
    }

    public void slowBlink() {
        if (!isScreenDanceRunning) {
            isScreenDanceRunning = true;
            setColor(Color.BLACK);
            screenDanceThread = new Thread(() -> {
                do {
                    changeColor(Color.WHITE);
                    sleep(800);
                    changeColor(Color.BLACK);
                    sleep(200);
                } while (isScreenDanceRunning);
                isScreenDanceRunning = false;
            });
            screenDanceThread.start();
        }
    }

    public void discoEffect() {
        if (!isScreenDanceRunning) {
            isScreenDanceRunning = true;
            setColor(Color.WHITE);
            screenDanceThread = new Thread(() -> {
                do {
                    changeColor(Color.CYAN);
                    sleep(100);
                    changeColor(Color.RED);
                    sleep(100);
                    changeColor(Color.GREEN);
                    sleep(100);
                    changeColor(Color.BLUE);
                    sleep(100);
                    changeColor(Color.YELLOW);
                    sleep(100);
                    changeColor(Color.MAGENTA);
                    sleep(100);
                    changeColor(Color.WHITE);
                    sleep(100);
                } while (isScreenDanceRunning);
                isScreenDanceRunning = false;
            });
            screenDanceThread.start();
        }
    }

    public void policeSiren() {
        if (!isScreenDanceRunning) {
            isScreenDanceRunning = true;
            setColor(Color.RED);
            screenDanceThread = new Thread(() -> {
                do {
                    changeColor(Color.BLUE);
                    sleep(400);
                    changeColor(Color.RED);
                    sleep(400);
                } while (isScreenDanceRunning);
                isScreenDanceRunning = false;
            });
            screenDanceThread.start();
        }
    }

    private void sleep(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}