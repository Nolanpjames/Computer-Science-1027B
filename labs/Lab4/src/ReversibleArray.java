public class ReversibleArray<T> {
    T[] array;
    int count;

    public ReversibleArray(T[] array) {
        this.array = array;
        count = array.length;
    }

    @Override
    public String toString() {
        String regularString = "";

        for (int z = 0; z < array.length; z++) {

            if (z != array.length - 1) {
                regularString += array[z] + ", ";
            } else {
                regularString += array[z];
            }
        }
        return regularString;
    }

    public void reverse() {
        int p = 0;
        int w = array.length;
        for (int i = 0; i < w; i++) {
            T temporary = array[i];
            array[i] = array[w - 1];
            array[w - 1] = temporary;
            w--;
            p++;
        }
    }
}
