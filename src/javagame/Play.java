package javagame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {
	
	public Play(int state){
		
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawString("This is the play state!", 100, 100);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		
	}
	
	public int getID(){
		return 1;
	}

}
