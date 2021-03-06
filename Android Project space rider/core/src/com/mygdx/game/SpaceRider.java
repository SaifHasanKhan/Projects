package com.mygdx.game;



		import com.badlogic.gdx.ApplicationAdapter;
		import com.badlogic.gdx.Gdx;
		import com.badlogic.gdx.audio.Music;
		import com.badlogic.gdx.graphics.GL20;
		import com.badlogic.gdx.graphics.g2d.SpriteBatch;
		import com.mygdx.game.states.GameStateManager;
		import com.mygdx.game.states.MenuState;

 public class SpaceRider extends ApplicationAdapter {
	public static final int WIDTH=480;
	public static final int HEIGHT=800;
	public static final String TITLE = "Space Rider";

	private GameStateManager gsm;
	private SpriteBatch batch;

	private Music music;


	@Override
	public void dispose() {
		super.dispose();
		music.dispose();
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		gsm = new GameStateManager();
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();

		gsm.push(new MenuState(gsm));
		Gdx.gl.glClearColor(1, 0, 0, 1);
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
}

