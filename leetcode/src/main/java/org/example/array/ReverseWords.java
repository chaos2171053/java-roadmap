package org.example.array;

public class ReverseWords {

    public String reverseWords(String s) {
        String[] words = s.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }
        // Remove trailing space
        return reversed.toString().trim();
    }
}
