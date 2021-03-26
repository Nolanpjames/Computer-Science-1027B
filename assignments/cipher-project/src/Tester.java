public class Tester {

    public static int convertToLetter(int originalLetter){
        return originalLetter > 'Z' ? convertToLetter(originalLetter - 26) : (originalLetter < 'A' ? convertToLetter(originalLetter + 26) : originalLetter);
    }


    public static void main(String[] args) {
        Tester.convertToLetter(142);

    }
}
