class Abo {



    public static int rabo(int n) {

        if (n <= 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else {
            if (n % 2 == 0) { // even check

                return 1 + rabo(n/2);

            }
            else {
                return 2 + rabo((n+1)/2);
            }
        }
    }

    public static int iabo(int n) {


        int finalAnswer = 0;

        int temp = n;

        while (true) {

            if (temp <= 0) {
                break;
            }
            else if (temp == 1) {
                finalAnswer += 1;
                break;
            }
            else {
                if (temp%2 == 0) {
                    finalAnswer += 1;
                    temp = temp/2;
                }
                else {
                    finalAnswer += 2;
                    temp = (temp+1)/2;
                }
            }
        }
        return finalAnswer;
    }

    public static void main(String[] args) {

        System.out.println("RABO:");

        for (int i=0; i < 20; ++i) {
            System.out.print(rabo(i)+" | ");
        }

        System.out.println("\nIABO:");

        for (int i=0; i < 20; ++i) {
            System.out.print(iabo(i)+" | ");
        }
    }
}