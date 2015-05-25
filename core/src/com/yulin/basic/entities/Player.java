package com.yulin.basic.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite implements InputProcessor {
    // Create velocity, speed, and gravity
    private Vector2 velocity = new Vector2();
    private float speed = 60 * 8, gravity = 60 * 1.8f;

    private boolean can_jump = true;

    public Player(Sprite sprite) {
        super(sprite);
        this.setY(500f);
    }

    @Override
    public void draw(Batch batch){
        update(Gdx.graphics.getDeltaTime());
        super.draw(batch);
    }

    public void update(float delta){
        // apply gravity
        velocity.y -= gravity * delta;

        // clamp velocity
        if(velocity.y>speed)
            velocity.y = speed;
        else if(velocity.y < speed)
            velocity.y = -speed;

        //set position by getting position, add velocity, apply delta
        setX(getX() + velocity.x * delta);
        setY(getY() + velocity.y * delta);
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Input.Keys.SPACE:
                if(can_jump)
                    velocity.y = speed;
                    can_jump=false;
                break;
            case Input.Keys.A:
                velocity.x = -speed;
                break;
            case Input.Keys.D:
                velocity.x = speed;
                break;
            case Input.Keys.ESCAPE:
                Gdx.app.exit();
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case Input.Keys.A:
            case Input.Keys.D:
                velocity.x=0;
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
