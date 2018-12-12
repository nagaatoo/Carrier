package com.numbdev.carrier.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.Body;
import com.numbdev.carrier.Enum.ControllerType;

public class PlayerController implements Controller {

    private Body player;

    public PlayerController(Body player) {
        this.player = player;
    }

    @Override
    public void update() {
        int forceX = 0;
        int forceY = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            forceX -= 10;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            forceX += 10;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            forceY += 10;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            forceY -= 10;
        }
        player.setLinearVelocity(forceX * 5, forceY * 5);
    }

    @Override
    public ControllerType typeControll() {
        return ControllerType.PLAYER_MOVE;
    }

}
