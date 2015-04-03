package critters;

import java.util.Arrays;

public class Driver {


	public static void main(String[] args) {

	int[][] locations = { 
							{10,10},
							{40,10},
							{40,20},
							{200,20},
							{200,300}
											}; 
	

		Critter g = new GruntCritter(locations);
		CritterObserver o = new CritterObserver(g);
		g.addObserver(o);
		g.takeDamage(10);
		
	
	}






}
