package CharacterString;

import com.sun.xml.internal.ws.util.StringUtils;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;


/**
 * Source: Java, How to Program, 10th Edition by Paul and Harvey Deitel
 *  Chapter 14
 * Exercise on Strings and Character
 */

public class Exercises {

    private static final int ARRAY_SIZE = 5;
    private static Scanner input = new Scanner(System.in);
    private static String firstString;
    private static String secondString;
    private static long startTime;
    private static long endTime;
    private static SecureRandom randomNumbers = new SecureRandom();

    public static void main(String[] args) {

        Instant start = Instant.now();
        startTime = System.nanoTime();

        /*ComparingStrings();
        ComparePortionsOfStrings();*/
        RandomSentences();

        Instant end = Instant.now();
        endTime = System.nanoTime();

        System.out.println();
        System.out.println("---------------------------");
        System.out.printf("Elapsed time: %s", Duration.between(start, end));
        System.out.printf("%nElapsed time2: %.5f secs%n", (double) (endTime - startTime) / 1000000000);
        System.out.println("---------------------------");
    }

    /**
     * Question 14.5
     */
    private static void RandomSentences() {

        String sentence = new String();
        String[] article = {"the", "a", "one", "some", "any"};
        String[] noun = {"boy", "girl", "dog", "town", "car"};
        String[] verbs = {"drove", "jumped", "ran", "walked", "skipped"};
        String[] propositions = {"to", "from", "over", "under", "on"};
        final int NUMBER_OF_SENTENCES = 20;

        for (int index = 1; index <= NUMBER_OF_SENTENCES; index++) {

            int randomWord = randomNumbers.nextInt(ARRAY_SIZE);

            System.out.println(index + sentence.concat(". ")
                    .concat(sentence.concat(StringUtils.capitalize(article[randomWord]).concat(" ")))
                    .concat(noun[randomWord]).concat(" ")
                    .concat(verbs[randomWord]).concat(" ")
                    .concat(propositions[randomWord]).concat(" ")
                    .concat(article[randomWord]).concat(" ")
                    .concat(noun[randomWord]).concat("."));
        }
    }

    /** Question 14.4
     * Write an application that uses String method region-Matches to compare two strings input by the user.
     * The application should input the number of characters to be compared and the starting index of the comparison.
     * The application should state
     * whether the strings are equal. Ignore the case of the characters when performing the comparison.
     */
    private static void ComparePortionsOfStrings() {

        System.out.println("**************************");
        System.out.println("ComparePortionsOfStrings");
        System.out.println("**************************");

        System.out.printf("Enter first string: ");
        firstString = input.nextLine();

        System.out.printf("Enter second string: ");
        secondString = input.nextLine();

        System.out.printf("%s is %s %s%n", firstString, firstString.regionMatches(0, secondString, 0, 3) ?
                "equal to" : "not equal to", secondString);

        System.out.println();
    }   /* ComparePortionsOfStrings */

    /** Question 14.3
     * Write an application that uses String method compareTo to compare
     * two strings input by the user. Output whether the first string is less than, equal to or greater than
     * the second.
     */
    private static void ComparingStrings() {

        System.out.println("**************************");
        System.out.println("ComparingStrings");
        System.out.println("**************************");

        System.out.printf("Enter first String: ");
        firstString = input.nextLine();

        System.out.printf("Enter second String: ");
        secondString = input.nextLine();

        int output = firstString.compareTo(secondString);
        System.out.println("Output: " + output);

        if (output > 0)
            System.out.printf("%s is greater than %s%n", firstString, secondString);
        else if (output < 0)
            System.out.printf("%s is less than %s%n", firstString, secondString);
        else if (output == 0)
            System.out.printf("Results: %s is equal to %s%n", firstString, secondString);
        else
            System.out.println("Unknown results");

        System.out.println();
    }   /* end ComparingStrings */


}
