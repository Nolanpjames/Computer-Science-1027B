import java.io.*;

/**
 * Represents cipher that encodes/decodes information with specified algorithm
 * @author  Justin Yan
 */
public class WesternCipher {

    private CircularArrayQueue<Character> encodingQueue;
    private CircularArrayQueue<Character> decodingQueue;

    /**
     * Default constructor initializes encoding  & decoding queues with capacity 10 and type character
     */
    public WesternCipher() {
        encodingQueue = new CircularArrayQueue<Character>(10);
        decodingQueue = new CircularArrayQueue<Character>(10);
    }

    /**
     * Takes integer as input and initializes encoding & decoding queues with that capacity and type Character
     *
     * @param capacity user input initial capacity
     */
    public WesternCipher(int capacity) {
        encodingQueue = new CircularArrayQueue<Character>(capacity);
        decodingQueue = new CircularArrayQueue<Character>(capacity);
    }

    /**
     * Recieves string as input, applies the Western Cipher described in assignment
     * Utilizes a circular queue to store letters
     * @param input
     * @return encrypts user input
     */

    public String encode(String input) {
        for (int scanner = 0; scanner < input.length(); scanner++) {
            encodingQueue.enqueue(input.charAt(scanner));
        }

        String output = "";
        boolean priorDigit = false;
        int priorDigitValue = 0;

        for (int scanner = 0; scanner < input.length(); scanner++) {
            char letter = encodingQueue.dequeue();
            if (letter == ' ') {
                output += letter;
            } else {
                if (priorDigit) {
                    if (letter == 'A') {
                        priorDigit = true;
                        output += '3';
                        priorDigitValue = 3;
                    } else if (letter == 'E') {
                        priorDigit = true;
                        output += '4';
                        priorDigitValue = 4;
                    } else if (letter == 'I') {
                        priorDigit = true;
                        output += '5';
                        priorDigitValue = 5;
                    } else if (letter == 'O') {
                        priorDigit = true;
                        output += '6';
                        priorDigitValue = 6;
                    } else if (letter == 'U') {
                        priorDigit = true;
                        output += '1';
                        priorDigitValue = 1;
                    } else if (letter == 'Y') {
                        priorDigit = true;
                        output += '2';
                        priorDigitValue = 2;
                    } else {
                        priorDigit = false;
                        int newLetter = letter + 5 + 2 * scanner - 2 * priorDigitValue;
                        output += (char) convertToLetter(newLetter);
                    }
                } else {
                    if (letter == 'A') {
                        priorDigit = true;
                        output += '1';
                        priorDigitValue = 1;
                    } else if (letter == 'E') {
                        priorDigit = true;
                        output += '2';
                        priorDigitValue = 2;
                    } else if (letter == 'I') {
                        priorDigit = true;
                        output += '3';
                        priorDigitValue = 3;
                    } else if (letter == 'O') {
                        priorDigit = true;
                        output += '4';
                        priorDigitValue = 4;
                    } else if (letter == 'U') {
                        priorDigit = true;
                        output += '5';
                        priorDigitValue = 5;
                    } else if (letter == 'Y') {
                        priorDigit = true;
                        output += '6';
                        priorDigitValue = 6;
                    } else {
                        priorDigit = false;
                        int newLetter = letter + 5 + 2 * scanner;
                        output += (char) convertToLetter(newLetter);
                    }
                }
            }
        }
        return output;
    }

    /**
     * Splits inputted string into individual chars, undoes the Western Cipher encryption
     * Rejoins characters into string
     * @param input
     * @return decoded Western Cipher string
     */
    public String decode(String input){
        for (int scanner = 0; scanner < input.length(); scanner++) {
            decodingQueue.enqueue(input.charAt(scanner));
        }

        String output = "";
        boolean priorDigit = false;
        int priorDigitValue = 0;

        for (int scanner = 0; scanner < input.length(); scanner++) {
            char letter = decodingQueue.dequeue();
            if (letter == ' ') {
                output += letter;
            }
            else {
                if (priorDigit) {
                    if (letter == '3') {
                        priorDigit = true;
                        output += 'A';
                        priorDigitValue = 3;
                    }
                    else if (letter == '4') {
                        priorDigit = true;
                        output += 'E';
                        priorDigitValue = 4;
                    } else if (letter == '5') {
                        priorDigit = true;
                        output += 'I';
                        priorDigitValue = 5;
                    } else if (letter == '6') {
                        priorDigit = true;
                        output += 'O';
                        priorDigitValue = 6;
                    } else if (letter == '1') {
                        priorDigit = true;
                        output += 'U';
                        priorDigitValue = 1;
                    } else if (letter == '2') {
                        priorDigit = true;
                        output += 'Y';
                        priorDigitValue = 2;
                    } else {
                        priorDigit = false;
                        int newLetter = letter - 5 - 2 * scanner + 2 * priorDigitValue;
                        output += (char) convertToLetter(newLetter);
                    }
                } else {
                    if (letter == '1') {
                        priorDigit = true;
                        output += 'A';
                        priorDigitValue = 1;
                    } else if (letter == '2') {
                        priorDigit = true;
                        output += 'E';
                        priorDigitValue = 2;
                    } else if (letter == '3') {
                        priorDigit = true;
                        output += 'I';
                        priorDigitValue = 3;
                    } else if (letter == '4') {
                        priorDigit = true;
                        output += 'O';
                        priorDigitValue = 4;
                    } else if (letter == '5') {
                        priorDigit = true;
                        output += 'U';
                        priorDigitValue = 5;
                    } else if (letter == '6') {
                        priorDigit = true;
                        output += 'Y';
                        priorDigitValue = 6;
                    } else {
                        priorDigit = false;
                        int newLetter = letter - 5 - 2 * scanner;

                        output += (char) convertToLetter(newLetter);
                    }
                }
            }
        }
        return output;
    }

    private int convertToLetter(int originalLetter){
        return originalLetter > 'Z' ? convertToLetter(originalLetter - 26) : (originalLetter < 'A' ? convertToLetter(originalLetter + 26) : originalLetter);
    }


}


