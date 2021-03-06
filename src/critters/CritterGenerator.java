package critters;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;


public class CritterGenerator {
	
	public CritterGenerator (int[][] pLocations,int pLevel){
		Locations = pLocations;
		this.level =pLevel-1;
	}
	
	//The critter stream sets the type and quantity of each critter for each level. It can be easily adjusted
	int[][] CritterStream = {		
			{5,1,0,0,0},
			{5,2,1,0,0},
			{5,3,1,1,0},
			{6,3,2,2,1},
			{6,3,3,3,2},
			{8,4,4,4,2},
			{9,5,5,5,2},
			{10,6,6,6,4},	};

	//creating  critter queue and finding starting point

	private Queue<Critter> 		CritterQueue 	= new LinkedList<Critter>();
	private int 				level;
	private int[][]				Locations;
	

	public void createCritterQueue(){
		//for that level, create the critter objects as per the values in the critter stream and then randomize the queue 
		for(int x = 0; x < 5 ; x++)
		{
			for(int y = 0; y < CritterStream[level][x] ; y++){	

				Critter c = addCritter(x);
				CritterQueue.add(c);

			}
		}


	}
	
	
	//shuffle the order of the critters
	public void RandomizeCritterQueue()
	{
		Collections.shuffle((LinkedList<Critter>) CritterQueue);
	}

	//add the critters according to the input x, whose value is determined by the critterStream
	private Critter addCritter(int x){
		if(x==0){
			Critter c = new GruntCritter(Locations);
			return c;
		}
		if(x==1){
			Critter c = new ScoutCritter(Locations);
			return c;
		}
		if(x==2){
			Critter c = new TankCritter(Locations);
			return c;
		}
		if(x==3){
			Critter c = new ArmoredCritter(Locations);
			return c;
		}
		if(x==4){
			Critter c = new BossCritter(Locations);
			return c;
		}

		return null;
	}

	//prints the critter queue to comnsole
	public void printCritterQueue(){
		
		System.out.print("<- [ ");
		for(Critter s : CritterQueue){
			System.out.print(s.getName()+" ");
		}
		System.out.println("]");
	}


	public Queue<Critter> getCritterQueue() {
		return CritterQueue;
	}

	
	

}
