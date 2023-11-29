import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println (decipherThis("72olle"));
    }

    // 1. parenthesesCheck ()" => true ")(()))" => false
    //Write a method called parenthesesCheck that takes a string of parentheses,
    // and determines if the order of the parentheses is valid.
    // The function should return true if the string is valid, and false if it's invalid.

    public static boolean parenthesesCheck (String par) {
        int open = 0;
        int close = 0;
        for (int i=0;i<par.length();i++) {
            if (par.charAt(i) == '(') {
                open++;
            }
            if (par.charAt(i) == ')') {
                close ++;
            }
            if (close > open) {
                return false;
            }
        }
        return (open == close);
    }

    // 2. reverseInteger
    //write a method called reverseInteger that reverses the
    // digits in an integer. Return the digits as a string.

    public static String reverseInteger (int rev) {
        String output = "";
        String rev2 = "" + rev;
        for (int i=rev2.length()-1;i>=0;i--){
            output += rev2.charAt(i);
        }
        return output;
    }

    // 3. encryptThis
    //For each word:
    //the second and the last letter is switched (e.g. Hello becomes Holle)
    // the first letter is replaced by its character code (e.g. H becomes 72)
    // Note: there are no special characters used, only letters and spaces

    public static String encryptThis (String msg) {
        Scanner sc = new Scanner (msg);
        String output = "";
        while (sc.hasNext()) {
            String word = sc.next();
            if (word.length() ==  2) {
                output += (int) word.charAt(0);
                output += word.charAt(1);
                output += " ";
            }
            else if (word.length() > 1) {
                output += (int) word.charAt(0);
                output += word.charAt(word.length() - 1);
                output += word.substring(2, word.length() - 1);
                output += word.charAt(1);
                output += " ";
            }
            else {
                output += (int) word.charAt(0);
                output += " ";
            }
        }
        return output.strip();
    }
    // 4. decipherThis
    //the second and the last letter is switched
    // (e.g. Hello becomes Holle) the first letter is replaced
    // by its character code (e.g. H becomes 72)
    // Note: there are no special characters used, only letters and spaces
    public static String decipherThis (String dec) {
        Scanner sc = new Scanner(dec);
        String output = "";
        while (sc.hasNext()) {
            String word = sc.next();
            output += decipherWord(word) + " ";
        }
        return output.strip();
    }

    public static String decipherWord(String word) {
        int numIndex=0;
        for (numIndex=0; numIndex<word.length(); numIndex++)
            if (!Character.isDigit(word.charAt(numIndex)))
                break;

        int num = Integer.parseInt(word.substring(0, numIndex));
        String theRest = word.substring(numIndex);

        String output = "" + (char) num;
        if (theRest.length() < 2) {
            output += theRest;
        }
        else if (theRest.length() == 2) {
            output += "" + theRest.charAt(1) + theRest.charAt(0);
        }
        else {
                output += theRest.charAt(theRest.length() - 1);
                output += theRest.substring(1, theRest.length()-1);
                output += theRest.charAt(0);
        }

        return output;
    }

}