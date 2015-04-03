package game;

import java.awt.Font;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class EditMapScreen extends BasicGameState {

	Image SandTile;
	Image ExitButtonGraphic;
	Rectangle ExitButton;
	ArrayList<Rectangle> buttonList = new ArrayList<Rectangle>();
	
	public EditMapScreen (int state){
		
	}
	@Override
	public void init(GameContainer container, StateBasedGame arg1)
			throws SlickException {
		SandTile = new Image("graphics/SandTile.png");
		ExitButtonGraphic = new Image ("graphics/ExitButton.png");
		ExitButton = new Rectangle(container.getWidth()-ExitButtonGraphic.getWidth(), container.getHeight()-ExitButtonGraphic.getHeight()-2, ExitButtonGraphic.getWidth(),ExitButtonGraphic.getHeight());

		
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		for(int x = 0; x <container.getWidth(); x+=SandTile.getWidth()){
			for(int y = 0 ; y< container.getHeight(); y+=SandTile.getHeight()){
				SandTile.draw(x,y);
			}
		}
		
		ExitButtonGraphic.draw(container.getWidth()-ExitButtonGraphic.getWidth(), container.getHeight()-ExitButtonGraphic.getHeight()-2);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		if(Mouse.isButtonDown(0)){
			MouseClicked(Mouse.getX(), container.getHeight() - Mouse.getY(), sbg);
		}
		
	}
	
	public void MouseClicked(int x, int y, StateBasedGame sbg){
		if(ExitButton.contains(x, y))
			sbg.enterState(0);
			
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}

}
