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
        int force = 0;
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            force -= 10;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            force += 10;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            // so big delay :(
            player.applyForceToCenter(0, 10000, false);
        }
        player.setLinearVelocity(force * 5, player.getLinearVelocity().y);
    }

    @Override
    public ControllerType typeControll() {
        return ControllerType.PLAYER_MOVE;
    }

}
