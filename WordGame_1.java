import java.util.*;
import java.io.*;

public class WordGame {
    /**
     * method to find the numbers of word with 7 unique letters
     * 
     * @return it returns an integer value which stores the number of words
     * @throws Exception is used to manage exception
     */
    public static int sortedLength() throws Exception {
        File myFile = new File("words.txt"); /* myFile is used to store words.txt */
        Scanner scnr = new Scanner(myFile); /* scnr is used to create a Scanner class to read the data from myFile */
        int sortLength = 0; /* sortLength is used to store the number of sorted words */
        String word; /* word variable is used to read the words from myFile */
        /* this loops runs till myFile has a next line */
        while (scnr.hasNextLine()) {
            word = scnr.next();
            boolean hasUniqueLetter=true;/*to check if the letter are unique or not */
            if (word.length() == 7) {
                char[] unWord=word.toCharArray();
                for (int i = 0; i < unWord.length; i++) {
                    char currChar=word.charAt(i);
                    for (int j = 0; j < unWord.length; j++) {
                        if (i!=j) {
                            if (currChar==word.charAt(j)) {
                                hasUniqueLetter=false;
                                break;
                                
                            }
                            
                        }
                    }
                    if (!hasUniqueLetter) {
                        break;
                    }}
            
                if (hasUniqueLetter) {
                    sortLength++;
                }}
            
        }
        scnr.close();
        return sortLength;

    }

    /**
     * method to add the sorted words to the array named sortedWords
     * 
     * @param sortedWord passes the array named sortedWord
     * @return it returns a String array
     * @throws Exception to manage the exceptions
     */
    public static String[] sort(String[] sortedWord) throws Exception {
        File myFile = new File("words.txt");/* myFile is used to store words.txt */

        Scanner scnr = new Scanner(myFile); /* scnr is used to create a Scanner class to read the data from myFile */
        String word; /* word variable is used to read the words from myFile */
        int ind = 0; /* i is used as an index to address the elemnts of array: sortedWord */
        /* this loops runs till myFile has a next line */
        while (scnr.hasNextLine()) {
            word = scnr.next();
            boolean hasUniqueLetter=true;
            if (word.length() == 7) {
                char[] unWord=word.toCharArray();
                for (int i = 0; i < unWord.length; i++) {
                    char currChar=word.charAt(i);
                    for (int j = 0; j < unWord.length; j++) {
                        if (i!=j) {
                            if (currChar==word.charAt(j)) {
                                hasUniqueLetter=false;
                                break;
                                
                            }
                            
                        }
                    }
                    if (!hasUniqueLetter) {
                        break;
                    }}
            
                if (hasUniqueLetter) {
                    sortedWord[ind]=word;
                    ind++;
                }
            }
            
        }
        scnr.close();
        return sortedWord;
            
        }

        

    

    /**
     * method to choose a word from the array, sortedWord
     * 
     * @param sortedWord passes the array to the method
     * @return it returns a String
     * @throws Exception
     */

    public static String chooseWord(String[] sortedWord) throws Exception {
        Random r = new Random(); /* r is used to create a random class */
        int rNum = r.nextInt(sortedWord.length);
        String choosenWord = sortedWord[rNum];
        return choosenWord;
    }

    /**
     * method to display the choosenWord in scrambled way and this code has been
     * made with the help of chatGPT.
     * 
     * @param choosenWord passes the selected word from the array
     * @return it returns a string in a scrambled way
     * @throws Exception manages the exception
     */
    public static String displayWord(String choosenWord) throws Exception {
        Random r = new Random(); /* r is used to create a random class */

        char[] chars = choosenWord.toCharArray();
        boolean check = false;
        /* this loop is used to scramble the word */
        while (!check) {
            for (int i = 0; i < chars.length; i++) {
                int j = r.nextInt(chars.length);

                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }

            // Check if the scramble is valid
            check = true;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == choosenWord.charAt(i)) {
                    check = false;
                    break;
                }
            }
        }
        String scrambledWord = new String(chars);
        for (int i = 0; i < chars.length; i++) {
            System.out.print(scrambledWord.charAt(i));
            if (i != (scrambledWord.length() - 1)) {
                System.out.print("     ");
            }

        }
        System.out.println();
        return scrambledWord;

    }

    /**
     * 
     * @param userChoice passes the word entered by the user
     * @param score      passes the current score of the user
     * @return it returns the score of the user after ever guess
     * @throws Exception manages the exceptions
     */
    public static int wordCheck(String userChoice, int score) throws Exception {
        if (userChoice.length() >= 4) {
            File myFile = new File("words.txt"); /* myFile is used to store words.txt */
            Scanner scnr = new Scanner(myFile); /*
                                                 * scnr is used to create a Scanner class to read the data from myFile
                                                 */
            /* this loops continues until it finds a matching word from myFile */
            while (scnr.hasNextLine()) {
                String word = scnr.next();

                if (word.equalsIgnoreCase(userChoice)) {
                    if (word.length() == 4) {
                        score = score + 1;
                    } else {
                        score = score + word.length();
                    }
                }

            }
            scnr.close();
        }

        return score;
    }

    /**
     * method to check whether the user entered word is present in the array list
     * 
     * @param list       passes the array of user entered words
     * @param userChoice passes the current user entered word
     * @return it returns a boolean value
     * @throws Exception
     */
    public static boolean listCheck(String[] list, String userChoice) throws Exception {
        boolean check = false; /*
                                * check is used to return a boolean value with respect to word present in the
                                * array
                                */
        /*
         * this loop is used to check the presence of user entered word in the array
         * list
         */
        for (String listW : list) {
            if (listW != null) {

                if (listW.equalsIgnoreCase(userChoice)) {
                    check = true;
                    break;
                } else {
                    check = false;
                }
            }

        }

        return check;
    }

    /**
     * method to check if the user entered word is created from the characters of
     * choosenWord
     * 
     * @param userChoice  passes the user entered word to the method
     * @param choosenWord passes the choosen word to the method
     * @return returns a boolean variable
     * @throws Exception manages the exception
     */
    public static boolean wordCreateCheck(String userChoice, String choosenWord) throws Exception {
        char[] array_UserChoice = userChoice.toCharArray();/* creates an array of the characters of user entered word */
        char[] array_ChoosenWord = choosenWord.toCharArray();/*
                                                              * creates an array of the characters of the choosesn word
                                                              */

        boolean charPresent = false;
        for (char c : array_UserChoice) {
            charPresent = false;
            for (char d : array_ChoosenWord) {
            
                if (c == d) {
                    charPresent = true;

                }

            }
            if (charPresent == false) {
                break;

            }

        }
        return charPresent;
    }

    /**
     * method to define the game logic
     * 
     * @param scrambledWord passes the scrambled word to the game logic
     * @param score         passes the current score of the user
     * @param currentSize   passes the value of current size
     * @param list          passes the array list
     * @throws Exception manages th exception
     */
    public static void gameLogic(String scrambledWord, int score, int currentSize, String[] list) throws Exception {
        Scanner scnr = new Scanner(System.in);
        boolean check = false;
        boolean play = false;

        while (!play) {

            System.out.print("enter your word : ");/* prompts the user for a word */
            String userChoice = scnr.next();
            //

            if (userChoice.equalsIgnoreCase("mix")) {
                displayWord(scrambledWord);/* calls the method displayWord */
                System.out.println();
                System.out.println("Score : "+score);
            } else if (userChoice.equalsIgnoreCase("bye")) {
                play = true;
            } else if (userChoice.equalsIgnoreCase("ls")) {
                for (int i = 0; i < currentSize - 1; i++) {

                    String wordList = list[i];
                    System.out.println("        " + wordList);
                }
                System.out.println();
                System.out.println("Score : "+score);
            } else {
                boolean createdFromWord = wordCreateCheck(userChoice, scrambledWord);
                if (createdFromWord == true) {

                    if (userChoice.length() < 4) {
                        System.out.println("Score:" + score);
                        continue;
                    } else {

                        check = listCheck(list, userChoice);/* calls the method listCheck */
                    }
                    if (!check) {

                        int score1 = wordCheck(userChoice, score);
                        System.out.println("Score : " + score1);
                        if (score1 > score) {

                            score = score1;
                            list[currentSize - 1] = userChoice;
                            currentSize++;

                        }
                    }
                } else {
                    continue;
                }
            }

        }
        scnr.close();

    }

    public static void main(String[] args) throws Exception {
        int score = 0; /* score is used to store the initial score of user */
        Scanner scnr = new Scanner(System.in);
        int sortLength = sortedLength(); /* calls the method sortedLength() */
        int currentSize = 1; /* it is used as an index for the element of the array list */
        String[] list = new String[100]; /* list array is used to store the user entered words */
        String[] sortedWord = new String[sortLength]; /*
                                                       * sortedWord array is used to store all the sorted words from
                                                       * 'words.txt'
                                                       */
        sortedWord = sort(sortedWord); /* calls the method sort */

        String choosenWord = chooseWord(sortedWord); /* calls the method chooseWord */
        String scrambledWord = displayWord(choosenWord);/* calls the method displayWord */
        gameLogic(scrambledWord, score, currentSize, list);/* calls the method gameLogic */

        scnr.close();
    }

}
