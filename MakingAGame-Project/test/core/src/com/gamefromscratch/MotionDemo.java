package com.gamefromscratch;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MotionDemo implements ApplicationListener {

    private SpriteBatch batch;
    private BitmapFont font;
    private String message = "Do something already!";
    private float highestY = 0.0f;

    @Override
    public void create() {

        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);

    }

    @Override
    public void resize(int width, int height) {

        batch.dispose();
        batch = new SpriteBatch();
        String resolution = width + ", " + height;
        Gdx.app.log("MJF", "Resolution changed " + resolution);

    }

    @Override
    public void render() {

        int w = Gdx.graphics.getWidth();
        int h = Gdx.graphics.getHeight();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        int deviceAngle = Gdx.input.getRotation();
        Input.Orientation orientation = Gdx.input.getNativeOrientation();
        float accelY = Gdx.input.getAccelerometerY();
        if (accelY > highestY) {

            message = "Device rotated to: " + deviceAngle + " degrees\n";
            message += "Device orientation is ";

            switch (orientation) {

                case Landscape:
                    message += " landscape. \n";
                    break;

                case Portrait:
                    message += " portrait. \n";
                    break;

                default:
                    message += " complete crap! \n";
                    break;

            }

            message += "Device resolution: " + w + ", " + h + "\n";
            message += "Y axis accel: " + accelY + "\n";
            message += "Highest Y value: " + highestY + "\n";

            if (Gdx.input.isPeripheralAvailable(Input.Peripheral.Vibrator)) {

                if (accelY > 7) {

                    Gdx.input.vibrate(100);

                }

            }

            if (Gdx.input.isPeripheralAvailable(Input.Peripheral.Compass)) {

                message += "Azmuth: " + Gdx.input.getAzimuth() + "\n";
                message += "Pitch: " + Gdx.input.getPitch() + "\n";
                message += "Roll: " + Gdx.input.getRoll() + "\n";

            }

            else {

                message += "No compass available \n";

            }

        }

        font.draw(batch, message, 0, h);
        batch.end();

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

        batch.dispose();
        font.dispose();

    }

}
