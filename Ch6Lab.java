import java.util.*;
import java.io.*;

public class TokenProcessingCanonical{
    public static void main(String[] args) throws FileNotFoundException {
        //precondition: input file exists and consists of words and integers separated by whitespace
        String file = "input.txt";

        System.out.println("Number of tokens: " + numTokens(file));
        System.out.println("Sum of integers: " + sumInts(file));
        System.out.println("Average words per line: " + wordsPerLine(file));
        
        System.out.print("Words with letter 'a': ");
        wordsWithLetter('a', file);
    }

    // write a method that returns the number of tokens in given file
    public static int numTokens(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        int count = 0;

        //counts each token
        while (sc.hasNext()) {
            sc.next();
            count++;
        }

        sc.close();
        return count;
    }

    // write a method returns the sum of all integers in the given file
    public static int sumInts(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        int sum = 0;

        //adds integers while ignoring words
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                sum += sc.nextInt();
            } else {
                sc.next();
            }
        }
        sc.close();

        return sum;
    }

    // write a method that returns the average number of words per line in the given file 
    // (numbers can be ignored)
    public static double wordsPerLine(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName)); 
        int totalWords = 0;
        int totalLines = 0;

        //counts words line by line
        while (sc.hasNextLine()) {
            Scanner lineScanner = new Scanner(sc.nextLine());

            //counts words in the current line
            while (lineScanner.hasNext()) {
                if (lineScanner.hasNextInt()) {
                    lineScanner.nextInt();
                } else {
                    lineScanner.next();
                    totalWords++;
                }
            }

            totalLines++;
            lineScanner.close();
        }
        sc.close();

        //avoids division by zero error
        if (totalLines == 0) {
            return 0;
        }
        
        return (double) totalWords / totalLines;
    }

    

    // write a method prints all words in the given file that contain the specified letter
    // separated by commas and spaces (e.g. "apple, banana, cat")
    public static void wordsWithLetter(char letter, String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));

        
        while (sc.hasNext()) {
            //checks if token is a word and contains the specified letter
            if (sc.hasNextInt()) {
                sc.nextInt();
            } else {
                String word = sc.next();
                if (word.indexOf(letter) != -1) {
                    System.out.print(word);
                    if (sc.hasNext()) {
                        System.out.print(", ");
                    }
                }
            }
        }
        sc.close();
    }
}
