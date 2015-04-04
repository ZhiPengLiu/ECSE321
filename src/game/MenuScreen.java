package game;



import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import critters.Critter;
public class MenuScreen extends BasicGameState{

	Image SandTileGraphic;
	Image StartGameButtonGraphic;
	Image EditMapButtonGraphic;
	Image TowerDefenseTitleGraphic;
	Image ExitButtonGraphic;
	Rectangle ExitButton;
	Rectangle EditMapButton;
	Rectangle StartGameButton;
	private static final double delay = 0.5;
	public static long currentSystemTime;

	private final String authors = "A Java Game by Callum May, Wei Wang,\nCharles Liu and Robert Zhao";


	public MenuScreen (int state){

	}


	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {

		loadImages();
		createRectangleButtons(container);


	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {

		if(Mouse.isButtonDown(0)){
			mouseClicked(Mouse.getX(),container.getHeight()-Mouse.getY(), sbg);

<<<<<<< HEAD
=======
			if( Mouse.getY() > 2*container.getHeight()/3 -StartGameButton.getHeight()/2 && Mouse.getY() < 2*container.getHeight()/3 +StartGameButton.getHeight()/2 )
			{
	
				if(Mouse.isButtonDown(0)){
					sbg.enterState(Game.mapSelectScreen);
				}
			}
>>>>>>> origin/master
		}


<<<<<<< HEAD
=======
			if( Mouse.getY() > container.getHeight() -(2*container.getHeight()/4 +EditMapButton.getHeight()/2) && Mouse.getY() < container.getHeight() -(2*container.getHeight()/4 -EditMapButton.getHeight()/2) )
			{
	
				if(Mouse.isButtonDown(0)){
					sbg.enterState(Game.editMapScreen);
				}
			}
		}

		if( Mouse.getX() < container.getWidth() -ExitButton.getWidth() && Mouse.getX() > container.getWidth())
		{

			if( Mouse.getY() > container.getHeight()-ExitButton.getHeight()-2 && Mouse.getY() < container.getHeight() )
			{
	
				if(Mouse.isButtonDown(0)){
					System.exit(0);
					
				}
			}
		}
>>>>>>> origin/master
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		drawMapAndOverlay(container);

<<<<<<< HEAD
=======
		StartGameButton.draw(container.getWidth()/2 -StartGameButton.getWidth()/2, container.getHeight()/3 -StartGameButton.getHeight()/2);
		EditMapButton.draw(container.getWidth()/2 -EditMapButton.getWidth()/2, container.getHeight()/2 -EditMapButton.getHeight()/2);
		TowerDefenseTitle.draw(container.getWidth()/2 - TowerDefenseTitle.getWidth()/2, TowerDefenseTitle.getHeight()/2);
		ExitButton.draw(container.getWidth()-ExitButton.getWidth(), container.getHeight()-ExitButton.getHeight()-2);
		
>>>>>>> origin/master
		g.setColor(Color.black);
		g.drawString(authors, 5, container.getHeight()-40);
	}


	public void createRectangleButtons(GameContainer container){
		StartGameButton = new Rectangle(container.getWidth()/2 -StartGameButtonGraphic.getWidth()/2, container.getHeight()/3 -StartGameButtonGraphic.getHeight()/2, StartGameButtonGraphic.getWidth(), StartGameButtonGraphic.getHeight());
		ExitButton = new Rectangle(container.getWidth() - ExitButtonGraphic.getWidth(), container.getHeight() - ExitButtonGraphic.getHeight() - 2, ExitButtonGraphic.getWidth(), ExitButtonGraphic.getHeight());
		EditMapButton = new Rectangle(container.getWidth()/2 -EditMapButtonGraphic.getWidth()/2, 2*container.getHeight()/4 -EditMapButtonGraphic.getHeight()/2, EditMapButtonGraphic.getWidth(), EditMapButtonGraphic.getHeight());
	}


	//render the map and the buttons
	public void drawMapAndOverlay(GameContainer container){
		for(int x = 0; x <container.getWidth(); x+=SandTileGraphic.getWidth()){
			for(int y = 0 ; y< container.getHeight(); y+=SandTileGraphic.getHeight()){
				SandTileGraphic.draw(x,y);
			}
		}

		StartGameButtonGraphic.draw(container.getWidth()/2 -StartGameButtonGraphic.getWidth()/2, container.getHeight()/3 -StartGameButtonGraphic.getHeight()/2);
		EditMapButtonGraphic.draw(container.getWidth()/2 -EditMapButtonGraphic.getWidth()/2, 2*container.getHeight()/4 -EditMapButtonGraphic.getHeight()/2);
		TowerDefenseTitleGraphic.draw(container.getWidth()/2 - TowerDefenseTitleGraphic.getWidth()/2, 50 - TowerDefenseTitleGraphic.getHeight()/2);
		ExitButtonGraphic.draw(container.getWidth()-ExitButtonGraphic.getWidth(), container.getHeight()-ExitButtonGraphic.getHeight()-2);

	}

	public void loadImages() throws SlickException{
		SandTileGraphic = new Image("graphics/SandTile.png");
		StartGameButtonGraphic = new Image("graphics/StartGameButton.png");
		EditMapButtonGraphic = new Image("graphics/EditMapButton.png");
		TowerDefenseTitleGraphic = new Image("graphics/TowerDefenseTitle.png");
		ExitButtonGraphic = new Image ("graphics/ExitButton.png");

	}

	public void mouseClicked(int x, int y, StateBasedGame sbg){
		if(StartGameButton.contains(x,y))
			sbg.enterState(3);

		if(ExitButton.contains(x,y)&&Mouse.getDX()!=0)
			System.exit(0);

		if(EditMapButton.contains(x,y))
			sbg.enterState(2);



	}
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}


}
