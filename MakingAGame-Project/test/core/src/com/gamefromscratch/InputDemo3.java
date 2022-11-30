package com.gamefromscratch;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public class InputDemo3 extends ApplicationAdapter implements InputProcessor, GestureDetector.GestureListener {

    private SpriteBatch batch;
    private BitmapFont font;
    private String message = "No gesture performed yet";
    private int w,h;

    @Override
    public void create() {

        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.RED);
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();

        InputMultiplexer im = new InputMultiplexer();
        GestureDetector gd = new GestureDetector(this);
        im.addProcessor(gd);
        im.addProcessor(this);

        Gdx.input.setInputProcessor(im);

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        GlyphLayout gl = new GlyphLayout(font, message);
        float x = w/2 - gl.width/2;
        float y = h/2 + gl.height/2;
        font.draw(batch, message, x, y);

        batch.end();

    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {

        batch.dispose();
        font.dispose();

    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {

        message = "Touch down!";
        Gdx.app.log("INFO", message);
        return true;

    }

    @Override
    public boolean tap(float x, float y, int count, int button) {

        message = "Tap performed, finger " + Integer.toString(button);
        Gdx.app.log("INFO", message);
        return false;

    }

    @Override
    public boolean longPress(float x, float y) {

        message = "Long press performed";
        Gdx.app.log("INFO", message);
        return true;

    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {

        message = "Fling performed, velocity: " + Float.toString(velocityX) +
                ", " + Float.toString(velocityY);
        Gdx.app.log("INFO", message);
        return true;

    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {

        message = "Pan performed, delta: " + deltaX +
                ", " + deltaY;
        Gdx.app.log("INFO", message);
        return true;

    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {

        message = "Zoom performed: " + initialDistance +
                ", " + distance;
        Gdx.app.log("INFO", message);
        return true;

    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {

        message = "Pinch Performed";
        Gdx.app.log("INFO", message);
        return true;

    }

    @Override
    public void pinchStop() {

    }

    @Override
    public boolean keyDown(int keycode) {

        message = "Key Down";
        Gdx.app.log("INFO", message);
        return true;

    }

    @Override
    public boolean keyUp(int keycode) {

        message = "Key Up";
        Gdx.app.log("INFO", message);
        return true;

    }

    @Override
    public boolean keyTyped(char character) {

        message = "Key Typed";
        Gdx.app.log("INFO", message);
        return true;

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        message = "Touch Down";
        Gdx.app.log("INFO", message);
        return false;

    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {

        message = "Touch Up";
        Gdx.app.log("INFO", message);
        return false;

    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {

        message = "Touch Dragged";
        Gdx.app.log("INFO", message);
        return false;

    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {

        message = "Mouse Moved";
        Gdx.app.log("INFO", message);
        return false;

    }

    @Override
    public boolean scrolled(float amountX, float amountY) {

        message = "Scrolled";
        Gdx.app.log("INFO", message);
        return false;

    }

}
