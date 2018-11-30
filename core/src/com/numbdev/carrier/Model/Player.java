package com.numbdev.carrier.Model;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.numbdev.carrier.Controller.Controller;
import com.numbdev.carrier.Controller.PlayerController;

public class Player {

    private PlayerController controller;
    private Body player;

    public Player() {
    }

    public Body getPlayerBody() {
        return player;
    }

    // TODO
    public Controller getController() {
        return controller;
    }

    /**
     * Инициализация игрока в мире.
     * @return body игрока
     */
    public void initPlayer(World world) {
        Body pBody;
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(50, 100);
        def.fixedRotation = true;

        pBody = world.createBody(def);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(12, 12);
        pBody.createFixture(shape, 1.0f);
        shape.dispose();

        this.player = pBody;
        controller = new PlayerController(player);
    }
}
