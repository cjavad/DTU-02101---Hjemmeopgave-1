package Problem4;

import java.io.FileNotFoundException;

public class Problem4 {
    public static void main(String[] args) throws FileNotFoundException {
        TextAnalysis22 ta22 = new TextAnalysis22("TimeMachine.txt", 35000);
        int n = ta22.wordCount();
		System.out.println(n);
    }
}