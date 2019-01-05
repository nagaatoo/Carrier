package com.numbdev.carrier.Model;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.numbdev.carrier.Controller.Controller;
import com.numbdev.carrier.Controller.PlayerController;
import com.numbdev.carrier.Exception.MaterialNotFoundException;

import static com.numbdev.carrier.Utils.Constants.PPM;

public class Player {

    private PlayerController controller;
    private Body player;
    private PolygonSprite poly;
    private PolygonSpriteBatch polygonSpriteBatch;
    private Camera camera;

    public Player(Camera camera) {
        if (camera == null) {
            throw new MaterialNotFoundException("Camera not found");
        }
        textureInit();
        this.camera = camera;
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
        def.position.set(190, 190);
        def.fixedRotation = true;
        pBody = world.createBody(def);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(50f / PPM, 50f /  PPM);
        pBody.createFixture(shape, 1.0f);
        shape.dispose();
        this.player = pBody;
        sprite();
        controller = new PlayerController(player);
    }

    public void updatePlayer() {
      //  batch.setProjectionMatrix(camera.combined);
        sprite();
    }

    private void sprite() {
       // System.out.println("player: " + player.getPosition().x + " | tex: " + batch.);
      //  batch.begin();
      //  batch.draw(texture, player.getPosition().x / SCALE, player.getPosition().y / SCALE);
     //   batch.end();

        polygonSpriteBatch.begin();
        poly.draw(polygonSpriteBatch);
        polygonSpriteBatch.end();
    }

    private void textureInit() {
        var texture = new Texture("player.png");
        var textureRegion = new TextureRegion(texture, 0, 0, texture.getWidth(), texture.getHeight());
        var region = new PolygonRegion(textureRegion, new float[] {0, 0, 100, 100, 0, 100, 100, 0}, new short[] {0, 1, 2, 0, 3, 2});
        poly = new PolygonSprite(region);
        polygonSpriteBatch = new PolygonSpriteBatch();
    }
}
