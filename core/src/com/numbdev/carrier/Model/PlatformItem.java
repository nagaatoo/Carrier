package com.numbdev.carrier.Model;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import static com.numbdev.carrier.Utils.Constants.PPM;

public class PlatformItem {

    private Body item;

    public PlatformItem() {
    }

    public Body getItem() {
        return item;
    }

    public void initPlatformItem(World world) {
        Body pBody;
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.StaticBody;
        def.position.set(0, 0);
        def.fixedRotation = true;
        pBody = world.createBody(def);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(3000f / PPM, 300f / PPM);
        pBody.createFixture(shape, 1.0f);
        shape.dispose();
        this.item = pBody;
    }
}
