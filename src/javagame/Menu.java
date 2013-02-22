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
	Image face;
	int faceX = 200;
	int faceY = 200;
	
	public Menu(int state){
		
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		face = new Image("res/jbean.png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawString(mouseString, 100, 10);
		//g.drawRect(50, 100, 60, 120); //x, y, width, height
		
		// g.drawOval(200, 130, 130, 80); //x, y, width, height
		//Image face = new Image("res/jbean.png");
		//g.drawImage(face, 200, 130);
		
		g.drawImage(face, faceX, faceY);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		mouseString = "Mouse x:" + xpos + " y: " + ypos;
		
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_UP)){
			faceY -= 1;
		}
		if(input.isKeyDown(Input.KEY_DOWN)){
			faceY += 1;
		}
		if(input.isKeyDown(Input.KEY_LEFT)){
			faceX -= 1;
		}
		if(input.isKeyDown(Input.KEY_RIGHT)){
			faceX += 1;
		}
	}
	
	public int getID(){
		return 0;
	}

}
