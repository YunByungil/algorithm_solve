import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> notGroupWords = new ArrayList<>();
        String str = "";
        for (int k = 0; k < n; k++) {
            str = br.readLine();
            notGroupWords.add(str);
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i - 1) != str.charAt(i)) {
                    for (int j = i + 1; j < str.length(); j++) {
                        if (str.charAt(i - 1) == str.charAt(j)) {
                            notGroupWords.remove(str);
                        }
                    }
                }
            }
        }
        System.out.println(notGroupWords.size());
    }
}