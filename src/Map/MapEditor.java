package Map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Queue;

import Grid.PathTile;

/**
 * @author		Wei Wang
 * @version		1.0
 * @since		2015-03-23
 */

public class MapEditor {

	private Map map;
	private int[][] mapArray;
	private int[][] cornerArray;

	private int width;
	private int height;
	private String userInput = "";
	private String mapInfo;

	public MapEditor(int width, int height, String userInput){
		map = new Map();
		map.setMapSize(width, height);
		map.setInputCorner(userInput);

		map.initializeMap();

		Queue<PathTile> path = map.multipleCoordinatesSplit(userInput);
		map.buildPath(path);
		
		Queue<PathTile> corner = map.multipleCoordinatesSplit(userInput);
		map.cornerArray(corner);
		
		mapArray = map.convertToBinaryMap(map);
		
		try {
			writeFile("customizedMap");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Retrieve the Map
	 * 
	 * @return	Map
	 */
	public Map getMap(){
		return map;
	}
	
	/**
	 * Write the Map information into a text file
	 * 
	 * @param map
	 * @throws IOException
	 */
	public void writeFile(String name) throws IOException{
		File file = new File("mapSaves/maps.txt");
		FileOutputStream fout = new FileOutputStream(file);

		StringBuffer results = new StringBuffer();
		String data = "";
		String nextLine = System.getProperty("line.separator");
		String endOfMap;

		if (!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		data+= name + nextLine;
		data+= map.getWidthOfMap() + nextLine;
		data+= map.getHeightOfMap() + nextLine;
		data+= map.getInputCorner() + nextLine;

		for (int i = 0; i < mapArray.length; ++i){
			for (int j = 0; j < mapArray[i].length; ++j){
				results.append(mapArray[i][j]).append(" ");
			}
			results.append(nextLine);
		}
		data+= results;
		data+="------------------------------------------------------------------------" + nextLine;

		try {
			fout.write(data.getBytes());
			fout.close();
			System.out.println("File Written Sucessfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read and create a map from a text file
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public void readFile(String name) throws IOException{
		File file = new File("data/" + name + ".txt");
		FileReader fr = new FileReader(file);
		BufferedReader br =  new BufferedReader(fr);
		int count = 0;
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				count++;
				if (count == 1){
					width = Integer.valueOf(line);
				}
				else if (count == 2){
					height = Integer.valueOf(line);
				}
				else if (count == 3){
					userInput = line.toString();
				}				
				else {
					sb.append(line);
					sb.append(System.lineSeparator());
				}

				line = br.readLine();
			}
			mapInfo = sb.toString();
		} finally {
			br.close();
			System.out.println("File Read Sucessfully!");
		}	
	}

	/**
	 * 
	 * @return width of customized map
	 */
	public int getTempWidth(){
		return width;
	}
	
	/**
	 * 
	 * @return height of customized map
	 */
	public int getTempHeight(){
		return height;
	}
	
	/**
	 * 
	 * @return user's input 
	 */
	public int[][] getUserInput(){
		return map.getCornersList();
	}
	public String toString(){
		return map.toString();
	}
}