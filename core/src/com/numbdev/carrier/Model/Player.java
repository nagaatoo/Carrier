package com.numbdev.carrier.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.numbdev.carrier.Controller.Controller;
import com.numbdev.carrier.Controller.PlayerController;

import static com.numbdev.carrier.Utils.Constants.PPM;

public class Player {

    private PlayerController controller;
    private Body player;
    private Texture texture;

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
        def.position.set(0, 0);
        def.fixedRotation = true;
        pBody = world.createBody(def);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(50f / 2f / PPM, 50f / 2f / PPM);
        pBody.createFixture(shape, 1.0f);
        shape.dispose();
        this.player = pBody;
        controller = new PlayerController(player);
    }
}
