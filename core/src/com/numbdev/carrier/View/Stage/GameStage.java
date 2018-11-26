package com.numbdev.carrier.View.Stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameStage extends Stage {

    private SpriteBatch batch;
    private Texture img;

    public GameStage() {
        super(new ScreenViewport());
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
    }

    public void drawStage() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
        this.draw();
    }
}
