package critters;



public class TemporaryMapShell {

	//2D map array
	private int[][] map = {		
			{0,0,0,0,0,0,0,0,0,0}	,
			{0,0,0,0,0,0,0,0,0,0}	,
			{0,0,0,0,0,0,0,0,0,0}	,
			{0,0,1,1,1,0,0,0,0,0}	,
			{0,0,1,0,1,0,0,0,0,0}	,
			{0,0,1,0,1,1,0,1,1,1}	,
			{1,1,1,0,0,1,1,1,0,0}	,
			{0,0,0,0,0,0,0,0,0,0}	,
			{0,0,0,0,0,0,0,0,0,0}	,
			{0,0,0,0,0,0,0,0,0,0}	};

	private int[] Startpoint 	= {6,0};
	private int[] Endpoint 		= {5,9};



	public int[][] getMap() {
		return map;
	}
	public int[] getStartpoint() {
		return Startpoint;
	}
	public int[] getEndpoint() {
		return Endpoint;
	}





}
