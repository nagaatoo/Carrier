package com.numbdev.carrier.Controller;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.numbdev.carrier.Enum.ControllerType;
import com.numbdev.carrier.Model.Player;

public class CameraController implements Controller {

    private OrthographicCamera camera;

    public CameraController(OrthographicCamera camera) {
        this.camera = camera;
    }

    public void update(float x, float y, Player player) {
        Vector3 position = camera.position;
        position.x = x;
        position.y = y;
        camera.position.set(position);
        camera.update();
        System.out.println(camera.position + " ===== " + player.getPlayerBody().getPosition());
    }

    @Override
    public void update() {

    }

    @Override
    public ControllerType typeControll() {
        return ControllerType.CAMERA;
    }
}
