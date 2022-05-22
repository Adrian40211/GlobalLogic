import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        StringBuilder buildString = new StringBuilder();
        for(String s : args) {
            buildString.append(s);
        }
        String[] resultString = buildString.toString()
                .toLowerCase(Locale.ROOT)
                .replace(" ","")
                .split("");
    }
}
