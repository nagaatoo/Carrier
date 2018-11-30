package com.numbdev.carrier.Controller;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.numbdev.carrier.Enum.ControllerType;

public class CameraController implements Controller {

    private OrthographicCamera camera;

    public CameraController(OrthographicCamera camera) {
        this.camera = camera;
    }

    public void update(float x, float y) {
        Vector3 position = new Vector3();
        position.x = x;
        position.y = y;
        camera.position.set(position);
        camera.update();
    }

    @Override
    public void update() {

    }

    @Override
    public ControllerType typeControll() {
        return ControllerType.CAMERA;
    }
}
