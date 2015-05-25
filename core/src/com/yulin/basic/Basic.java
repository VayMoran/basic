package com.yulin.basic;

import com.badlogic.gdx.Game;

public class Basic extends Game {

	
	@Override
	public void create () {
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}
}
