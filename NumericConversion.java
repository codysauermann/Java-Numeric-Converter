import java.util.Scanner;

public class NumericConversion {
    public static long hexStringDecode(String hex) {
        int positionIndex;
        long decodedHex = 0;
        for (int i = 0; i < hex.length(); i++) { // Used to go through each character of the string.
            if (hex.charAt(i) == '0' && hex.charAt(i+1) == 'x') {
                i = 1;
                continue;
            }
            positionIndex = hex.length() - i -1;
            char digit = hex.charAt(i);
            long newDigit;
            if (Character.isLetter(digit)== true) { // checks for characters that are letters to call the character decode method
                int intDigit = hexCharDecode(digit);
                newDigit = (long) (intDigit * Math.pow(16,positionIndex));
            }
            else {
                int intDigit = (int) digit - 48; // the 48 is used to get the true value of the digit.
                newDigit = (long) (intDigit * Math.pow(16,positionIndex));
            }
            decodedHex += newDigit;
        }
        return decodedHex;
    }

    public static short hexCharDecode(char digit) { // decodes a letter from the hex code.
        short newDigit = 0;
        if (digit == 'a' || digit == 'A') {
            newDigit = 10;
        }
        else if (digit == 'b' || digit == 'B') {
            newDigit = 11;
        }
        else if (digit == 'c' || digit == 'C') {
            newDigit = 12;
        }
        else if (digit == 'd' || digit == 'D') {
            newDigit = 13;
        }
        else if (digit == 'e' || digit == 'E') {
            newDigit = 14;
        }
        else if (digit == 'f' || digit == 'F') {
            newDigit = 15;
        }
        return newDigit;
    }

    public static short binaryStringDecode(String binary) {
        short decodedBin = 0;
        int positionIndex;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0' && binary.charAt(i+1) == 'b') {
                i = 1;
                continue;
            }
            positionIndex = binary.length() - i - 1; // gives the power of 2 for each position in the string
            int digit = binary.charAt(i) - 48;
            short newDigit;
            newDigit = (short) (digit * Math.pow(2,positionIndex));
            decodedBin += newDigit;
        }
        return decodedBin;
    }

    public static String binaryToHex(String binary) {
        String binToHex = "";

        return binToHex;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int startMenu = 1;

        while (startMenu == 1) { // while loop used to start and stop the code on command.
            System.out.println("Decoding Menu");
            System.out.println("-------------");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit");
            System.out.println();

            System.out.print("Please enter an option: ");
            int userOption = scnr.nextInt();
            System.out.println();

            if (userOption == 1) {
                System.out.println("Please enter the numeric string to convert: ");
                String hex = scnr.next();
                long result = hexStringDecode(hex);
                System.out.println("Result: " + result);
            }
            else if (userOption == 2) {
                System.out.println("Please enter the numeric string to convert: ");
                String binary = scnr.next();
                short result = binaryStringDecode(binary);
                System.out.println("Result: " + result);
            }
            else if (userOption == 3) {
                System.out.println("Please enter the numeric string to convert: ");
                String binary = scnr.next();
                String result = binaryToHex(binary);
                System.out.println("Result: " + result);
            }
            else if (userOption == 4) {
                System.out.println("Goodbye!");
                startMenu = 0;
            }
        }
    }
}
