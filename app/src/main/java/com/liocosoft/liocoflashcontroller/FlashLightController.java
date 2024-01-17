package com.liocosoft.liocoflashcontroller;

import static android.content.Context.CAMERA_SERVICE;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;

public class FlashLightController {
    private final CameraManager cameraManager;
    private String cameraId;
    private Thread lightDanceThread;
    private boolean isLightDanceRunning = false;

    public FlashLightController(Context context) {
        cameraManager = (CameraManager) context.getSystemService(CAMERA_SERVICE);

        try {
            cameraId = cameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public void stopLightDance() {
        if (isLightDanceRunning && lightDanceThread != null) {
            isLightDanceRunning = false;
            try {
                lightDanceThread.join();
            } catch (InterruptedException e) {
                lightDanceThread.interrupt();
            } finally {
                lightDanceThread = null;
            }
        }
    }

    public void flashlightOn() {
        try {
            cameraManager.setTorchMode(cameraId, true);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public void flashlightOff() {
        try {
            cameraManager.setTorchMode(cameraId, false);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public void sosSignal() {
        String sosMorseCode = "... --- ...";

        for (char c : sosMorseCode.toCharArray()) {
            if (c == '.') {
                flashlightOn();
                sleep(100); // Adjust the duration for dot (.)
            } else if (c == '-') {
                flashlightOn();
                sleep(300); // Adjust the duration for dash (-)
            } else if (c == ' ') {
                // Pause between words
                sleep(300);
            }

            flashlightOff();
            sleep(100); // Pause between dots and dashes
        }
    }

    public void randomBlink() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                do {
                    flashlightOn();
                    sleep((int) (Math.random() * 500) + 100);
                    flashlightOff();
                    sleep((int) (Math.random() * 500) + 100);
                } while (isLightDanceRunning);
                isLightDanceRunning = false;
            });
            lightDanceThread.start();
        }
    }

    public void alternatingBlink() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                do {
                    flashlightOn();
                    sleep(300);
                    flashlightOff();
                    sleep(300);
                } while (isLightDanceRunning);
                isLightDanceRunning = false;
            });
            lightDanceThread.start();
        }
    }

    public void doubleBlink() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                do {
                    flashlightOn();
                    sleep(100);
                    flashlightOff();
                    sleep(100);
                    flashlightOn();
                    sleep(100);
                    flashlightOff();
                    sleep(400);
                } while (isLightDanceRunning);
                isLightDanceRunning = false;
            });
            lightDanceThread.start();
        }
    }

    public void fastBlink() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                do {
                    flashlightOn();
                    sleep(100);
                    flashlightOff();
                    sleep(100);
                } while (isLightDanceRunning);
                isLightDanceRunning = false;
            });
            lightDanceThread.start();
        }
    }

    public void slowBlink() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                do {
                    flashlightOn();
                    sleep(800);
                    flashlightOff();
                    sleep(200);
                } while (isLightDanceRunning);
                isLightDanceRunning = false;
            });
            lightDanceThread.start();
        }
    }

    public void heartbeatEffect() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                do {
                    flashlightOn();
                    sleep(100);
                    flashlightOff();
                    sleep(100);
                    flashlightOn();
                    sleep(100);
                    flashlightOff();
                    sleep(800);
                } while (isLightDanceRunning);
                isLightDanceRunning = false;
            });
            lightDanceThread.start();
        }
    }

    public void waterfallEffect() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                do {
                    for (int i = 0; i < 10; i++) {
                        if (!isLightDanceRunning)
                            break;
                        flashlightOn();
                        sleep(50);
                        flashlightOff();
                        sleep(50 * (i + 1));
                    }
                } while (isLightDanceRunning);
                isLightDanceRunning = false;
            });
            lightDanceThread.start();
        }
    }

    public void discoEffect() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                do {
                    flashlightOn();
                    sleep(300);
                    flashlightOff();
                    sleep(100);
                } while (isLightDanceRunning);
                isLightDanceRunning = false;
            });
            lightDanceThread.start();
        }
    }

    public void zigzagEffect() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                do {
                    for (int i = 0; i < 5; i++) {
                        if (!isLightDanceRunning)
                            break;
                        flashlightOn();
                        sleep(100);
                        flashlightOff();
                        sleep(50 * (i + 1));
                    }
                } while (isLightDanceRunning);
                isLightDanceRunning = false;
            });
            lightDanceThread.start();
        }
    }

    public void starWarsTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {200, 200, 200, 600, 200, 200, 200, 600, 200, 200, 200, 1200};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;
            });
            lightDanceThread.start();
        }
    }

    public void tetrisTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {300, 200, 300, 200, 300, 300, 200, 100, 200, 300, 200, 100, 300, 200, 300, 300, 100, 300, 200, 100};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;
            });
            lightDanceThread.start();
        }
    }

    public void harryPotterTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {400, 200, 400, 200, 400, 200, 400, 800, 200, 400, 200, 400, 200, 400, 800, 400, 400};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;
            });
            lightDanceThread.start();
        }
    }

    public void starTrekTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {200, 200, 200, 600, 200, 200, 200, 600, 200, 800, 200, 200, 200, 800};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;

            });
            lightDanceThread.start();
        }
    }

    public void jamesBondTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {400, 200, 400, 200, 400, 200, 400, 400, 400, 400, 200, 200, 200, 200, 400, 200};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;

            });
            lightDanceThread.start();
        }
    }

    public void indianaJonesTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {200, 400, 200, 400, 200, 400, 200, 400, 800, 200, 200, 200, 400, 200, 400, 200};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;

            });
            lightDanceThread.start();
        }
    }

    public void jurassicParkTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {400, 400, 200, 200, 400, 200, 200, 400, 400, 200, 200, 400, 200, 200, 200, 200};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;

            });
            lightDanceThread.start();
        }
    }

    public void lordOfTheRingsTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {300, 200, 300, 200, 300, 300, 200, 200, 300, 300, 200, 200, 300, 200, 200, 300};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;

            });
            lightDanceThread.start();
        }
    }

    public void matrixTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {300, 100, 300, 100, 300, 100, 300, 100, 300, 100, 300, 100, 300, 100, 300, 100};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;

            });
            lightDanceThread.start();
        }
    }

    public void avengersTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {200, 200, 400, 200, 400, 200, 200, 400, 200, 200, 400, 200, 400, 200, 200, 200};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;

            });
            lightDanceThread.start();
        }
    }

    public void piratesOfTheCaribbeanTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {200, 400, 200, 400, 200, 400, 200, 400, 200, 400, 200, 400, 200, 400, 200, 400};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;

            });
            lightDanceThread.start();
        }
    }

    public void backToTheFutureTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {300, 200, 300, 200, 300, 300, 200, 300, 300, 200, 200, 300, 200, 300, 300, 200};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;

            });
            lightDanceThread.start();
        }
    }

    public void etTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {200, 400, 200, 400, 200, 400, 200, 400, 200, 400, 200, 400, 200, 400, 200, 400};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;

            });
            lightDanceThread.start();
        }
    }

    public void ghostBustersTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {300, 200, 300, 200, 300, 300, 200, 200, 300, 300, 200, 200, 300, 200, 200, 300};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;

            });
            lightDanceThread.start();
        }
    }

    public void batmanTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {200, 200, 300, 100, 200, 200, 300, 100, 200, 200, 300, 100, 200, 200, 300, 100};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;

            });
            lightDanceThread.start();
        }
    }

    public void frozenTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {300, 200, 300, 200, 300, 300, 200, 200, 300, 300, 200, 200, 300, 200, 200, 300};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;

            });
            lightDanceThread.start();
        }
    }

    public void lionKingTheme() {
        if (!isLightDanceRunning) {
            isLightDanceRunning = true;
            lightDanceThread = new Thread(() -> {
                int[] durations = {200, 400, 200, 400, 200, 400, 200, 400, 200, 400, 200, 400, 200, 400, 200, 400};
                for (int duration : durations) {
                    if (!isLightDanceRunning)
                        break;
                    flashlightOn();
                    sleep(duration);
                    flashlightOff();
                    sleep(50);
                }
                isLightDanceRunning = false;

            });
            lightDanceThread.start();
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