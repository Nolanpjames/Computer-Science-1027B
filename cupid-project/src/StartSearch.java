import java.io.IOException;
import java.io.FileNotFoundException;

public class StartSearch {
    private final Map targetMap; // reference the object representing the map where Cupid and targets are found
    private int numArrows; //Cupid's fired arrows total so far
    private int inertia; //tracks how many times arrow has traveled in same direction, starts at 0, and increments by 1 each time
    private int direction; //tracks direction of arrow. 0 = north. 1 = east. 2 = south. 3 = west

    /**
     * @param file file containing the description of the map
     */
    public StartSearch(String file) throws IOException {
        targetMap = new Map(file); // creates a new object of class map using given parameter
        direction = -5; // initialize direction 
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("You must provide the name of the input file");
            System.exit(0);
        }
        String mapFile = args[0];
        int maxCellLength = 1000000;
        int numTargetsFound = 0;
        ArrayStack<MapCell> arrayStack;
        if(args.length > 1){
            maxCellLength = Integer.parseInt(args[1]);
            arrayStack = new ArrayStack<>(maxCellLength);
        }
        else{
            arrayStack = new ArrayStack<>();
        }
        StartSearch mapObj = new StartSearch(mapFile);
        MapCell mapCellStart = mapObj.targetMap.getStart();
        int lengthPath = 0;
        while(mapObj.numArrows < mapObj.targetMap.quiverSize()){// while Cupid still has arrows remaining
            arrayStack.push(mapCellStart);
            mapCellStart.markInStack();
            
            MapCell startMapCell = mapCellStart;
            int direction = -5; // initialize direction to non-impacting direction
            for(int i = 0; i < 4; i++){// prefers target cell over all else
                MapCell neighbourCell = startMapCell.getNeighbour(i);
                if(neighbourCell != null && !neighbourCell.isMarked() && neighbourCell.isTarget()) {
                    direction = i;
                    break;
                }
            }
            
            if(direction == -5){ //prefers cross path cell if no target cell adjacent to current cell
                for(int i = 0; i < 4; i++){
                    MapCell neighbour = startMapCell.getNeighbour(i);
                    if(neighbour != null && !neighbour.isMarked() && neighbour.isCrossPath()) {
                        direction = i;
                        break;
                    }
                }
            }

            if(direction == -5){ // prefers smallest index cell if no cross-path cell
                for(int i = 0; i < 4; i++){
                    MapCell neighbour = startMapCell.getNeighbour(i);
                    if(neighbour != null && !neighbour.isMarked() &&
                            ((i % 2 == 0 && neighbour.isVerticalPath()) || (i % 2 == 1 && neighbour.isHorizontalPath()))){
                        direction = i;
                        break;
                    }
                }
            }

            mapObj.direction = direction;

            mapObj.inertia = -1;// initialize inertia to value that does not affect the count
            lengthPath = 0;
            mapObj.numArrows++; // shoot arrow
            int backtracks = 0; // backtrack occurrences
            
            // while stack isn't empty and backtrack is less than 3
            // and the arrow path length has yet to be reached
            while(!arrayStack.isEmpty() && lengthPath <= maxCellLength && backtracks <= 3){
                MapCell currentMapCell = arrayStack.peek();
                MapCell nextMapCell = mapObj.nextCell(currentMapCell);
                if(nextMapCell != null){
                    arrayStack.push(nextMapCell);
                    nextMapCell.markInStack();
                    lengthPath++;
                    mapObj.inertia++;
                    if(nextMapCell.isTarget()){// stop arrow if target found
                        numTargetsFound++;
                        break;
                    }
                }
                else{
                    arrayStack.pop();
                    backtracks++;
                    lengthPath++;
                }
            }
            
            while(!arrayStack.isEmpty()){// pop stack until empty
                MapCell frontMapCell = arrayStack.pop(); 
                for(int i = 0; i < 4; i++){
                    MapCell neighbourMapCell = frontMapCell.getNeighbour(i);
                    if(neighbourMapCell != null && neighbourMapCell.isStart()){
                        frontMapCell.markOutStack();
                    }
                }
            }
        }
        System.out.println("Found Targets " + numTargetsFound);
    }

    /**
     * @param current cell
     * @return optimal cell to proceed t
     */
    public MapCell nextCell(MapCell cell){
        try{
            MapCell directionMapCell = cell.getNeighbour(direction);
            MapCell present = cell;
            MapCell nextCell = directionMapCell;
            int directionTwo = direction;
            boolean result = false;
            
            if(nextCell != null && !nextCell.isMarked() && !nextCell.isBlackHole()){// checks validity of path
                if(present.isStart() || present.isCrossPath() || present.isTarget()){
                    if(nextCell.isTarget() || nextCell.isCrossPath() || (nextCell.isVerticalPath() && directionTwo % 2 == 0) || (nextCell.isHorizontalPath() && directionTwo % 2 == 1)){
                        result = true;
                    }
                }
                if(present.isVerticalPath()){
                    if(directionTwo % 2 == 0 && (nextCell.isStart() || nextCell.isTarget() || nextCell.isCrossPath() || nextCell.isVerticalPath())){
                        result = true;
                    }
                }
                if(present.isHorizontalPath()){
                    if(directionTwo % 2 == 1 && (nextCell.isStart() || nextCell.isTarget() || nextCell.isCrossPath() || nextCell.isHorizontalPath())){
                        result = true;
                    }
                }
            }
            
            if(result){// check that next cell is valid, is not a wall
                return directionMapCell;
            }
        }
        catch(InvalidNeighbourIndexException exception){
            return null;
        }
        if(inertia > 2){// checks if inertia is too great to overcome
            return null;
        }
        
        MapCell proceedingCell = null;
        for(int i = 0; i < 4; i++){
            if(i == direction) {
            	continue;
            }
            MapCell neighbourCell = cell.getNeighbour(i);
            MapCell present = cell;
            MapCell nextCell = neighbourCell;
            int directionTwo = i;
            boolean result = false;
            
            if(nextCell != null && !nextCell.isMarked() && !nextCell.isBlackHole()){// checks validity of path
                if(present.isStart() || present.isCrossPath() || present.isTarget()){
                    if(nextCell.isTarget() || nextCell.isCrossPath() || (nextCell.isVerticalPath() && directionTwo % 2 == 0) || (nextCell.isHorizontalPath() && directionTwo % 2 == 1)){
                        result = true;
                    }
                }
                if(present.isVerticalPath()){
                    if(directionTwo % 2 == 0 && (nextCell.isStart() || nextCell.isTarget() || nextCell.isCrossPath() || nextCell.isVerticalPath())){
                        result = true;
                    }
                }
                if(present.isHorizontalPath()){
                    if(directionTwo % 2 == 1 && (nextCell.isStart() || nextCell.isTarget() || nextCell.isCrossPath() || nextCell.isHorizontalPath())){
                        result = true;
                    }
                }
            }                    
            
            if(result){
                if(neighbourCell.isTarget()){
                    proceedingCell = neighbourCell;
                    direction = i;
                    inertia = -1;
                    break;
                }
                else if(neighbourCell.isCrossPath()){
                    if(proceedingCell == null || proceedingCell.isVerticalPath() || proceedingCell.isHorizontalPath()){
                        direction = i;
                        inertia = -1;
                        proceedingCell = neighbourCell;
                    }
                }
                else if(neighbourCell.isHorizontalPath()){
                    if(proceedingCell == null){
                        direction = i;
                        inertia = -1;
                        proceedingCell = neighbourCell;
                    }
                }
                else if(neighbourCell.isVerticalPath()){
                    if(proceedingCell == null){
                        direction = i;
                        inertia = -1;
                        proceedingCell = neighbourCell;
                    }
                }
            }
        }
        return proceedingCell;
    }
}