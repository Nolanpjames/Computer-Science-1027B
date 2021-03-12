import java.util.Objects;

/**
 * A class representing players
 * stores name, position, and jersey number
 * @author Justin Yan
 * @version 1.0
 */


public class Player{
    private String name;
    private String position;
    private int jerseyNum;

    public Player(String name, String position, int jerseyNum) {
        /**
        *This is the constructor so we will be
        *initializing the member variables here
         */


        this.name = name;
        this.position = position;
        this.jerseyNum = jerseyNum;
    }

    public String getName() {
        return name;
    }

    /**
     * Returns the name of the player
     * @return a String value representing the player's name
     */


    public String getPosition() {
        return position;
    }

    public int getJerseyNum() {
        return jerseyNum;
    }

    /**
     * Sets the name to name
     * @param name String value
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setJerseyNum(int jerseyNum) {
        this.jerseyNum = jerseyNum;
    }

    @Override
    public String toString() {
        return this.name + ":  #" + this.jerseyNum;
    }

    public boolean equals (Player other){
        if (this.name.equals(other.getName()) && this.getJerseyNum() == other.getJerseyNum()) {
            return true;
        } else {
            return false;
        }
    }
}


