package com.numbdev.carrier.Utils;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import static com.numbdev.carrier.Utils.Constants.PPM;

public class TiledUtils {

    public static void mapControll(World world, MapObjects objects) {
        objects.forEach(obj -> controllMapObject(world, obj));
    }

    private static void controllMapObject(World world, MapObject obj) {
        Shape shape = null;
        if(obj instanceof PolygonMapObject) {
            shape = createPolyLine((PolygonMapObject) obj);
        }

        Body pBody;
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.StaticBody;
        pBody = world.createBody(def);
        pBody.createFixture(shape, 1.0f);
        shape.dispose();
    }

    private static Shape createPolyLine(PolygonMapObject obj) {
        float[] vertices = obj.getPolygon().getTransformedVertices();
        Vector2[] worldVertices = new Vector2[vertices.length /2];

        for (int i = 0; i < worldVertices.length; i++) {
            worldVertices[i] = new Vector2(vertices[i*2] / PPM, vertices[i*2+1] / PPM);
        }

        ChainShape chain = new ChainShape();
        chain.createChain(worldVertices);
        return chain;
    }
}
