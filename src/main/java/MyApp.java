import org.apache.commons.lang3.ArrayUtils;

import java.util.*;

public class MyApp {
    static Map<String, Integer> letterCount = new HashMap<>();      //declaring map where key will be letters from String and values will be their repetitions
    public static void main(String[] args) {
        StringBuilder buildString = new StringBuilder();
        for(String s : args) {
            buildString.append(s);   //building string
        }
        String[] resultString = buildString.toString()
                .toLowerCase(Locale.ROOT)
                .replace(" ","")
                .split("");                                         //removing spaces, converting all letters to the same size
                                                                    //splitting string to array
        letterCounter(resultString);
    }

    static void letterCounter(String[] input) {
        int counter = 1;
        for(int i = 1 ; i < input.length ; i++) {
            if(input[i].equals(input[0])) counter++;                //counting repetitions
        }
        letterCount.put(input[0], counter);                         //placing repetitions in map
        input= ArrayUtils.removeAllOccurrences(input,input[0]);     //removing letters from array that are already counted with usage of external library, defined in pom.xml
        if(input.length>0) letterCounter(input);                    //recurrence usage
        else displayResults();
    }

    static void displayResults() {
        Map<String,Integer> sortedMap = new TreeMap<>(letterCount); //sorting map by keys with usage of treemap
        System.out.println(sortedMap);                              //printing results
    }
}
