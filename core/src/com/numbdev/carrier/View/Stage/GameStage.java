package com.numbdev.carrier.View.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.numbdev.carrier.Controller.CameraController;
import com.numbdev.carrier.Controller.Controller;
import com.numbdev.carrier.Enum.ControllerType;
import com.numbdev.carrier.Model.PlatformItem;
import com.numbdev.carrier.Model.Player;
import com.numbdev.carrier.Utils.ControllUtil;

import java.util.ArrayList;
import java.util.List;

import static com.numbdev.carrier.Utils.Constants.SCALE;

public final class GameStage {

    private World world;
    private Box2DDebugRenderer renderer;
    private List<PlatformItem> blocks;
    private List<Controller> controllers;
    private Player player;
    private OrthographicCamera camera;

    // TODO may be context?
    public GameStage() {
        world = new World(new Vector2(0f, -9.8f), false);
        player = new Player();
        player.initPlayer(world);
        blocks = new ArrayList<>();
        blocks.add(new PlatformItem());
        blocks.forEach(block -> block.initPlatformItem(world));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth()/SCALE, Gdx.graphics.getHeight()/SCALE);
        renderer = new Box2DDebugRenderer();
        initControllers();
    }

    public void update(float delta) {
        world.step(1/60f, 6, 2);
        updateControllers();
        updateCamera();
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render(world, camera.combined.scl(SCALE));
    }

    public void dispose() {
        world.dispose();
    }

    // TODO
    private void initControllers() {
        controllers = new ArrayList<>();
        controllers.add(new CameraController(camera));
        controllers.add(player.getController());
    }

    private void updateControllers() {
        controllers.forEach(Controller::update);
    }

    private void updateCamera() {
        CameraController controller = (CameraController) ControllUtil
                .getControllerByType(ControllerType.CAMERA, controllers).get(0);
        float x = player.getPlayerBody().getPosition().x;//* PPM;
        float y = player.getPlayerBody().getPosition().y;// * PPM;
        controller.update(x, y, player);
    }
 }
