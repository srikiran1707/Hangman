
//author @srikiran1707
/**
 * Hangman Game
Hangman is an old school favorite, a word game where the goal is simply to find the missing word or words.

You will be presented with a number of blank spaces representing the missing letters you need to find.

Use the keyboard to guess a letter (I recommend starting with vowels).

If your chosen letter exists in the answer, then all places in the answer where that letter appear will be revealed.

After you've revealed several letters, you may be able to guess what the answer is and fill in the remaining letters.

Be warned, every time you guess a letter wrong you loose a life and the hangman begins to appear, piece by piece.

Solve the puzzle before the hangman dies.
 */

import java.io.*;
import java.util.*;

public class Game {

    public static void main(String[] args) throws FileNotFoundException {
        hangmanMain();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Try again ?");
            char playAgain = sc.next().charAt(0);
            switch (playAgain) {
                case 'y':
                    hangmanMain();
                    break;
                case 'n':
                    return;
                default:
                    break;
            }
        }
    }

    public static void hangmanMain() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        // number of tries to guess the word
        int t = 6;

        // getting a random word from word list
        char[] randomWord = getWord().toLowerCase().toCharArray();

        // storing all incorrect guesses for user reference
        StringBuilder userWrongGuess = new StringBuilder();

        // array to store user input if a character matches with the chosen word
        char c[] = new char[randomWord.length];
        Arrays.fill(c, '_');
        System.out.println(String.valueOf(c));

        // game loop
        while (t > 0) {
            System.out.println();
            if (contains('_', c)) {
                char input = sc.next().charAt(0);
                for (int i = 0; i < randomWord.length; i++) {
                    if (input == randomWord[i])
                        c[i] = input;
                }
                if (!contains(input, randomWord)) {
                    if (!userWrongGuess.toString().contains(String.valueOf(input)))
                        userWrongGuess.append(input + " ");
                    t--;
                    System.out.println("Not in word : " + userWrongGuess);
                    System.out.println("Wrong guess, " + t + " chances left!");
                    switch (t) {
                        case 5: {
                            System.out.println("---------");
                            System.out.println("|");
                            System.out.println("|");
                            System.out.println("|");
                            System.out.println("|");
                            System.out.println("|");
                            System.out.println("|");
                            System.out.println("--------------");
                            break;
                        }
                        case 4: {
                            System.out.println("---------");
                            System.out.println("|     |");
                            System.out.println("|   [- -]");
                            System.out.println("|");
                            System.out.println("|");
                            System.out.println("| ");
                            System.out.println("|");
                            System.out.println("--------------");
                            break;
                        }
                        case 3: {
                            System.out.println("---------");
                            System.out.println("|     |");
                            System.out.println("|   [- -]");
                            System.out.println("|  >--|");
                            System.out.println("|     |");
                            System.out.println("|     ");
                            System.out.println("|");
                            System.out.println("--------------");
                            break;
                        }
                        case 2: {
                            System.out.println("---------");
                            System.out.println("|     |");
                            System.out.println("|   [- -]");
                            System.out.println("|  >--|--<");
                            System.out.println("|     |");
                            System.out.println("|     ");
                            System.out.println("|");
                            System.out.println("--------------");
                            break;
                        }
                        case 1: {
                            System.out.println("---------");
                            System.out.println("|     |");
                            System.out.println("|   [- -]");
                            System.out.println("|  >--|--<");
                            System.out.println("|     |");
                            System.out.println("|    / ");
                            System.out.println("|");
                            System.out.println("--------------");
                            break;
                        }
                        case 0: {
                            System.out.println("---------");
                            System.out.println("      |");
                            System.out.println("|   [x x]");
                            System.out.println("|  >--|--<");
                            System.out.println("|     |");
                            System.out.println("|    / \\");
                            System.out.println("|");
                            System.out.println("--------------");
                            break;
                        }
                        default:
                            break;
                    }
                }
                if (t >= 1)
                    System.out.println(String.valueOf(c));
            } else {
                System.out.println("you have successfully guessed the word : " + String.valueOf(c));
                break;
            }
        }
        if (contains('_', c))
            System.out.println("You  failed to guess the word : " + String.valueOf(randomWord));
    }

    public static boolean contains(char a, char[] c) {
        boolean flag = false;
        for (char i : c) {
            if (i == a)
                return true;
            else
                flag = false;
        }
        return flag;
    }

    private static String getWord() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("wordList.txt"));
        ArrayList<String> dictionary = new ArrayList<>();
        while (sc.hasNextLine()) {
            dictionary.add(sc.nextLine());
        }
        sc.close();
        Random r = new Random();
        int index = r.nextInt(dictionary.size());
        return dictionary.get(index);
    }

}
