package javagame;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {

	Animation player, movingUp, movingDown, movingLeft, movingRight;
	Image worldMap;
	boolean quit = false;
	int[] duration = { 200, 200 };
	float playerPositionX = 0;
	float playerPositionY = 0;

	// this is for centering player in the middle of the screen
	float shiftX = playerPositionX + 320;
	float shiftY = playerPositionY + 160;

	public Play(int state) {

	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		worldMap = new Image("res/world.png");
		Image[] walkUp = { new Image("res/buckysBack.png"),
				new Image("res/buckysBack.png") };
		Image[] walkDown = { new Image("res/buckysFront.png"),
				new Image("res/buckysFront.png") };
		Image[] walkLeft = { new Image("res/buckysLeft.png"),
				new Image("res/buckysLeft.png") };
		Image[] walkRight = { new Image("res/buckysRight.png"),
				new Image("res/buckysRight.png") };

		movingUp = new Animation(walkUp, duration, false);
		movingDown = new Animation(walkDown, duration, false);
		movingLeft = new Animation(walkLeft, duration, false);
		movingRight = new Animation(walkRight, duration, false);
		player = movingDown;
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {

		worldMap.draw(playerPositionX, playerPositionY);
		player.draw(shiftX, shiftY);
		g.drawString("Player\nX:" + playerPositionX + "\nY:" + playerPositionY,
				100, 10);

		if (quit == true) {
			g.drawString("Resume (R)", 250, 100);
			g.drawString("Main Menu (M)", 250, 120);
			g.drawString("Quit Game (Q)", 250, 140);
			if (quit == false) {
				g.clear();
			}
		}
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		// move up
		if (input.isKeyDown(Input.KEY_UP)) {
			player = movingUp;
			playerPositionY += delta * .1f;
			if (playerPositionY > 172) {
				playerPositionY -= delta * .1f;
			}
		}
		// move down
		if (input.isKeyDown(Input.KEY_DOWN)) {
			player = movingDown;
			playerPositionY -= delta * .1f;
			if (playerPositionY < -600) {
				playerPositionY += delta * .1f;
			}
		}
		// move left
		if (input.isKeyDown(Input.KEY_LEFT)) {
			player = movingLeft;
			playerPositionX += delta * .1f;
			if (playerPositionX > 324) {
				playerPositionX -= delta * .1f;
			}
		}
		// move right
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			player = movingRight;
			playerPositionX -= delta * .1f;
			if (playerPositionX < -840) {
				playerPositionX += delta * .1f;
			}
		}
		
		// escape menu 
		if(input.isKeyDown(Input.KEY_ESCAPE)){
			quit = true;
		}
		//when the menu is on the screen
		if(quit==true){
			if(input.isKeyDown(Input.KEY_R)){
				quit = false;
			}
			if(input.isKeyDown(Input.KEY_M)){
				sbg.enterState(0);
			}
			if(input.isKeyDown(Input.KEY_Q)){
				System.exit(0);
			}
		}
	}

	public int getID() {
		return 1;
	}

}
