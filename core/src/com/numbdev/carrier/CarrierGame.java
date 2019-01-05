package com.numbdev.carrier;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.numbdev.carrier.View.Stage.GameStage;

import static com.numbdev.carrier.Utils.Constants.SCALE;

public class CarrierGame extends ApplicationAdapter {

    private GameStage stage;

    @Override
    public void create() {
        stage = new GameStage();
    }

    @Override
    public void render() {
        float delta = Gdx.graphics.getDeltaTime();
        stage.update(delta);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }

    @Override
    public void resize(int width, int height) {
        stage.getCamera().setToOrtho(false, width / SCALE, height / SCALE);
    }
}
