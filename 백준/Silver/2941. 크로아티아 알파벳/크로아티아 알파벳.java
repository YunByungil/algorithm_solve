import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        String word = br.readLine();
        String test = "";
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            test += word.charAt(i);
            for (int j = 0; j < str.length; j++) {
                if (test.contains(str[j])) {
                    test = test.replace(str[j], " ");
                    count++;
                }
            }
        }
        System.out.println(count + test.replace(" ","").length());
    }
}