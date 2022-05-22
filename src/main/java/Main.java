import java.util.*;

public class Main {
    static Map<String, Integer> letterCount = new HashMap<>();
    public static void main(String[] args) {
        StringBuilder buildString = new StringBuilder();
        for(String s : args) {
            buildString.append(s);
        }
        String[] resultString = buildString.toString()
                .toLowerCase(Locale.ROOT)
                .replace(" ","")
                .split("");

        letterCounter(resultString);
    }

    static void letterCounter(String[] input) {
        int counter = 1;
        for(int i = 1 ; i < input.length ; i++) {
            if(input[i].equals(input[0])) counter++;
        }
        letterCount.put(input[0], counter);
        String[] newInput = Arrays.toString(input).replace(input[0],"").split("");
        if(newInput.length>0) {
            letterCounter(newInput);
        } else {
            displayResults();
        }
    }

    static void displayResults() {
        Map<String,Integer> sortedMap = new TreeMap<>(letterCount);
        System.out.println(sortedMap);
    }
}
