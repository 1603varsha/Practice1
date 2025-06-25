class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words=s.split(" ");
        if(words.length!=pattern.length())
            return false;
        String[] charToWord = new String[26]; // to map pattern char to word
        String[] wordToChar = new String[words.length]; // to map word to pattern char

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            int index = c - 'a';

            // If already mapped, check if it matches current word
            if (charToWord[index] != null) {
                if (!charToWord[index].equals(w)) return false;
            } else {
                // Check if this word is already assigned to another char
                for (int j = 0; j < 26; j++) {
                    if (w.equals(charToWord[j])) return false;
                }
                charToWord[index] = w;
            }
        }

        return true;
    }
}