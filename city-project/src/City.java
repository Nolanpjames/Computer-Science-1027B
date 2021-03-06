/**
 * This class represents a city. Each city has a specific name,
 * x and y coordinates, and a CityMarker icon.
 * @author Justin Yan
 */

public class City {
    private String name;
    private int x;
    private int y;
    private CityMarker marker;

    /**
     * Constructor creates a city with the given name, x coordinate, y coordinate
     * @param name name of the city
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public City(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
        marker = new CityMarker();
    }

    /**
     * Accessor method to get the name of the city
     * @return name of the city
     */
    public String getName() {
        return name;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CityMarker getMarker() {
        return marker;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method  to set the x-coordinate of a city
     * @param x x-coordinate of the city
     */
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMarker(CityMarker marker) {
        this.marker = marker;
    }

    @Override
    public String toString() {
        return name;
    }
}
