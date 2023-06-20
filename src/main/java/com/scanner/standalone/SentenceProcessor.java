package com.scanner.standalone;

public class SentenceProcessor {
    public static void main(String[] args) {
        String sentence = "This is a sample sentence to test the program";
        String lastWord = getLastWord(sentence);
        System.out.println("Last word: " + lastWord);
    }

    public static String getLastWord(String sentence) {
        // Split the sentence into words
        String[] words = sentence.trim().split("\\s+");

        if (words.length == 1) {
            // If only one word, return the original sentence
            return sentence;
        } else {
            // Return the last word
            return words[words.length - 1];
        }
    }
}

