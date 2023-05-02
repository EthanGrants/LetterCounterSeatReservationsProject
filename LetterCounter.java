// Import at top
import java.util.Scanner;
/** LetterCounter.java - Count letters
 * <p>Problem Statement: Count the number of each letter in a long series of
 *                   inputs from the user.
 * </p>
 * 
 * <p>Algorithm: <br />
 * 1. Import java.util.Scanner <br />
 * 2. Create class <br />
3. Create int,string,and array variables <br />
4. Print out statement telling user what to do <br />
5. Set up a for loop <br />
6. Ask user for inputs, have a counter to track and print each line <br />
7. Use .split("\\s+") for an array to count the number of words <br />
8. Use for each loop for each word, then the word's characters, then an
if loop to see if the characters are letters <br />
9. Within the if loop, set the letter to lower case, and then subtract
char 'a' from it, increment to update the letter <br />
10.Use an if statement with .endswith and set it to the string of a "."
then inside, have it break in order to allow an end to the sentence <br />
11.Print out the total words <br />
12.Set a for loop to print out each letter, 'a" + i gets the letter,
then use a variable[i] to reference the letter amount <br />
13.Compile and test <br />
 *      
 * </p>
 *   @author Ethan Grant
 *   @version Module 8, Homework 1
 */

public class LetterCounter {
    public static void main(String[] args) 
    {
        {
            // Variables
            int numberCounter = 1;
            int wordCounter = 0;
            String stringInput = "";
            int[] letterCounter = new int[25];
            // Print out statement
            System.out.println("Enter several lines of text to anaylyze. When done,");
            System.out.println("end a line with a period.");

            // Get sentences
            for (int i = 0; ; i++) {
                // Ask user for inputs
                System.out.printf("%d: ", numberCounter);
                Scanner input =
                    new Scanner(System.in);
                stringInput = input.nextLine();
                numberCounter++;

                // Splits the string on whitespace
                // Length of the array is the number of words
                String[] wordCount = stringInput.split("\\s+");
                wordCounter += wordCount.length;

                // loop through elements in an array:
                // for each loop, each word in array, loop executes
                for (String word : wordCount) {
                    // for each loop, each character of the word, loop executes
                    for (char c : word.toCharArray()) {
                        // if loop, if character is a letter, loop executes
                        if (Character.isLetter(c)) {
                            // gets value of each letter, increment updates letter
                            letterCounter[Character.toLowerCase(c) - 'a']++;
                        }
                    }
                }

                // Break once period is entered at end of string  
                if (stringInput.endsWith( "."))
                {
                    break;
                }
            }

            // Total words
            System.out.printf("There are %d words in the text \n", wordCounter);

            // Total alphabet
            for (int i = 0; i < 25; i++) {
                System.out.printf("%c: %d\n", 'a' + i, letterCounter[i]);
            }
        }
    }
}
