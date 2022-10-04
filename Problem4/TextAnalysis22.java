package Problem4;

// import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TextAnalysis22 {
    // ArrayList<String> words = new ArrayList<String>();
    String[] words;

    // Let the constructor throw the error
    public TextAnalysis22 (String sourceFileName, int maxNoOfWords) throws FileNotFoundException {
        // Using normal array
        words = new String[maxNoOfWords];
        // Read file and add words to words array
        Scanner file = new Scanner(new File(sourceFileName));

        int wordCount = 0;

        while (file.hasNextLine()) {
            String[] tokens = file.nextLine().split("[^a-zA-Z]+");
            // Merge words and tokens
            for (int i = 0; i < tokens.length; i++) {
                if (tokens[i] == null || tokens[i].length() < 1) continue;
                words[wordCount] = tokens[i];
                wordCount++;
            }
        }
    }

    public int wordCount() {
        // Find the first null element
        int i = 0;
        for (int j = 0; j < words.length; j++) {
            if (words[i] == null) continue;
            i++;
        }
        return i;
        // return words.length; // words.size();
    }

    public int frequency(String word) {
        int count = 0;

        for (String w : words) {
            if (w != null && w.equals(word)) {
                count++;
            }
        }

        return count;
    }

    public boolean contains(String word1, String word2) {
        boolean contains = false;

        for (int i = 0; i < words.length - 1; i++) {
            if (words[i] == null) continue;
            if (words[i].toLowerCase().equals(word1.toLowerCase()) && words[i + 1].toLowerCase().equals(word2.toLowerCase())) {
                contains = true;
            }
        }
        return contains;
    }
}
