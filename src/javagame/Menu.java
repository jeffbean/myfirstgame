package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {

	public String mouseString = "No input yet!";
	public String welcome = "Welcome to JBean land!";
	
	Image playNow;
	Image exitGame;
	
	int faceX = 200;
	int faceY = 200;

	public Menu(int state) {

	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {

		playNow = new Image("res/playNow.png");
		exitGame = new Image("res/exitGame.png");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString(mouseString, 101, 10);
		g.drawString(welcome, 100, 50);
		playNow.draw(100, 100);
		exitGame.draw(100, 200);
	
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		mouseString = "Mouse x:" + xpos + " y: " + ypos;
		//Play Now Button
		if((xpos > 100 && xpos < 311) && (ypos > 209 && ypos < 260)) {
			if(input.isMouseButtonDown(0)){
				sbg.enterState(1);
			}
		}
		//Exit Game
		if((xpos > 100 && xpos < 311) && (ypos > 109 && ypos < 160)) {
			if(input.isMouseButtonDown(0)){
				System.exit(0);
			}
		}
		

	}

	public int getID() {
		return 0;
	}

}
