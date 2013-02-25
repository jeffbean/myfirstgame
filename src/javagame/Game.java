package javagame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

	public static final String gamename = "Don't know yet";
	public static final int menu = 0;
	public static final int play = 1;

	public Game(String gamename) {
		super(gamename);
		this.addState(new Menu(menu));
		this.addState(new Play(play));
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		// Need to add the states
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		// What state to go to first
		this.enterState(menu);
	}

	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(640, 360, false);
			appgc.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}