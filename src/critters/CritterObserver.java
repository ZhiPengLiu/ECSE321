package critters;



public class CritterObserver implements CrObserver {

	private Critter subjectCritter;
	private boolean critterisDead;
	private double critterHealth;
	private String critterStatus= "";

	//constructor takes the passed critter observer, updates the status
	public CritterObserver (Critter pCritter){
		subjectCritter = pCritter;
		critterisDead =false;
		critterHealth = pCritter.getHealth();
		critterStatus = "Critter has "+critterHealth+" health points remaining.";
	}
	
	//this method updates the critters status, which is displayed on the game screen
	@Override
	public void update() {
		
		critterHealth= subjectCritter.getHealth();
		if(!subjectCritter.isAlive()){
			critterisDead=true;
			critterStatus = "Critter is dead";
		}
		else{
			critterStatus = "Critter has "+critterHealth+" health points remaining.";
		}
	}
	
	
	public String getCritterStatus() {
		return critterStatus;
	}
	
	

}
