/**
 * This class is the main heart of the program.
 * It will read in a file of cities, creating a compressed array containing
 * the distance between each of the cities
 * @author Justin Yan
 */
public class Program {
    private int cityCount;
    private City[] cityArray;
    private CompressedArray array;

    /**
     *This constructor takes in a file name
     *and creates a city object out of each city name, x-value, y-value
     *and proceeds to city the object to cityArray.
     *The array will be expanded by 3 slots if needed.
     * @param fileName
     * @param showMap
     */
    public Program(String fileName, boolean showMap){
    	cityArray = new City[3];
		MyFileReader fr = new MyFileReader(fileName);
		fr.readString(); // reads & omits first line
		cityCount = 0;
		
		
		while (fr.endOfFile() == false) {//checks if end of file has been reached
			String name = fr.readString();
			int x = fr.readInt();
			int y = fr.readInt();
			
			City city = new City(name, x, y); //creates city object out of stored name, x , y
			
			if (cityCount == cityArray.length) { // checks to see if array is too small
				this.expandCapacity();
			}
			
			cityArray[cityCount] = city;
			cityCount++;
			
		}
		
		if (showMap == true) {//checks if map object needs to be created
			Map map = new Map();
			for (int i=0; i<cityCount; i++) {
				map.addCity(cityArray[i]);
			}
		}
        }
    
    public City[] getCityList() {//returns city list
    	return cityArray;
    }
    
    public void expandCapacity() {//expands array capacity by 3, retains all elements
    	City[] temporary= new City[cityCount + 3];
    	for(int j = 0; j < cityCount; j++)
    	{
    		temporary[j] = cityArray[j];
    	}
    	cityArray = temporary;
    }
    
    public double distBetweenCities(City a, City b) {//calculates Euclidean distance between 2 cities
    	return Math.sqrt((a.getY()-b.getY()) * (a.getY() - b.getY()) + (a.getX() - b.getX()) * (a.getX() - b.getX()));//Euclidean formula
    }
    
    public void compareDistances() {//creates a 2D array storing the distance between every pair of cities
    	double[][] pairDistances= new double[cityCount][cityCount];
    	
    	for(int i = 0; i < cityCount; i++) {
    		for(int j = 0; j < cityCount; j++) {
    			pairDistances[i][j] = distBetweenCities(cityArray[i], cityArray[j]);
    		}
    	}
    	this.array = new CompressedArray(pairDistances);
    }
    
    public CompressedArray getArray() {//returns  compressed array
    	return array;    	
    }
}
    



