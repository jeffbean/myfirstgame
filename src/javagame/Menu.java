package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {
	
	public String mouse = "No input yet!";
	
	public Menu(int state){
		
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawString(mouse, 50, 50);
		g.drawRect(50, 100, 60, 120); //x, y, width, height
		
		// g.drawOval(200, 130, 130, 80); //x, y, width, height
		Image face = new Image("res/jbean.png");
		g.drawImage(face, 200, 130);
		
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		
		mouse = "Mouse position x:" + xpos + " y: " + ypos;
	}
	
	public int getID(){
		return 0;
	}

}
