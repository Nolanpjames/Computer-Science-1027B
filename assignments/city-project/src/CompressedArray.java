/**
 * This class represents a compressed array.
 * Each compressed array has an original array size
 * and a array comprised of doubles
 * @author  Justin Yan
 */
public class CompressedArray {
    private int origArraySize;
    private double[] array;

    /**
     * Constructor creates a  compressed array given a 2D array
     * @param originalArray2d original 2D array
     */
    public CompressedArray(double [][]originalArray2d){
        array = new double[(((originalArray2d.length) * (originalArray2d[0].length)) - (originalArray2d.length)) / 2];
        origArraySize = 0;
        for(int i = 0; i < originalArray2d.length; i++){
            for(int j = 0; j<originalArray2d[0].length - 1; j++){
                if (j < i){
                    array[origArraySize] = originalArray2d[i][j];
                    origArraySize++;
                }
            }
        }
    }

    public int getLength(){
        return  array.length;
    }

    public double getElement(int i){
        return array[i];
    }

    public boolean equals(CompressedArray other){
        if(this.origArraySize == other.getLength()){
            for (int i = 0; i < origArraySize; i++){
                if (this.getElement(i) != other.getElement(i)){
                    return false;
                }
            }
        }
        else{
            return false;
        }
        return true;
    }

    
	public String toString() {
		String str = "\n";
		int elemCount = 0;
		int newLine = 1;		
		
		for (int i=0; i<array.length; i++) {
			elemCount++;
			if (elemCount == newLine) {
				str += String.format("%8.2f", array[i]) + "\n";
				elemCount = 0;
				newLine++;
			}
			else {
				str += String.format("%8.2f", array[i]);
			}
		}
		
		return str;
	}
}

