package com.scanner.standalone;

public class SentenceProcessor {
    public static void main(String[] args) {
        String sentence = "C:\\Windows\\System32\\KERNELBASE.dll";
        String lastWord = getLastWord(sentence);
        System.out.println("Last word: " + lastWord + ".exe");
    }

    public static String getLastWord(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        return (words.length == 1) ? sentence : words[words.length - 1];
    }
}


