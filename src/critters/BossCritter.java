package critters;

public class BossCritter extends Critter {

	public BossCritter(int[][] Locations) {
		
		super(Locations, health, armor, speed, reward, name);


	}

	private static String		name		= "Boss";
	private static double 		health 		= 20;
	private static double 		speed		= 0.2;
	private static int			reward		= 50;
	private static double		armor		= 5;


}

