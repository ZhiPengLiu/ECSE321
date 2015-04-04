package game;





import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


import critters.CritterObserver;
//test

public class Game extends StateBasedGame {



	static long tickCount = 0;

	Image blackBeetleDead;
	Image SandTile;
	Image GravelTile;
	Image StartGameButtonGraphic;
	Image EditMapButtonGraphic;
	CritterObserver gruntObserver;

	private static final int menuScreen = 0;
	private static final int playScreen = 1;
	private static final int editMapScreen = 2;
	private static final int mapSelectScreen =3;

	public Game(String title) {
		super(title);
		this.addState(new MenuScreen(menuScreen));
		this.addState(new PlayScreen(playScreen));
		this.addState(new EditMapScreen(editMapScreen));
		this.addState(new MapSelectScreen(mapSelectScreen));
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {

		this.enterState(menuScreen);
		
	
	}

	public static void main(String[] args) throws SlickException {


		//initialize game frame
		AppGameContainer app = new AppGameContainer(new Game("Tower Defense"));
		//set resolution to map size
		app.setDisplayMode(640, 480, false);
		//this is delta info, so that the game isn't reliant on the speed of the users computer
		app.setMinimumLogicUpdateInterval(20);
		app.setMaximumLogicUpdateInterval(21);
		app.start();
	}





}
