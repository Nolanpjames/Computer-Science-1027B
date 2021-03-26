import java.util.Scanner;

public class Permutations {

    private static String removeChar(String s, int i) {
        return s.substring(0, i) + s.substring(i+1);
    }

    public static void permutations(String prefix, String suffix) {
        if (suffix.length() == 0) {
            System.out.print(prefix + " ");
            return;
        }

        for (int j = 0; j < suffix.length(); j++) {
            char c = suffix.charAt(j);

            String suff = removeChar(suffix, j);

            String pre = prefix + c;

            permutations(pre, suff);
        }

    }

    public static void calculatePermutations(){
        Scanner checkInput = new Scanner(System.in);
        System.out.print("Please enter your string: ");
        String suffix = checkInput.nextLine();
        String prefix = "";
        System.out.println("Possible permutations of " + suffix + " are the following: ");
        permutations(prefix, suffix);
        return;
    }



    public static void main(String[] args) {
        calculatePermutations();


    }
}