import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] arr = new int[2][26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        for (int i = 0; i < str1.length(); i++) {
            int index = str1.charAt(i) - 'a';
            arr[0][index]++;
        }

        for (int i = 0; i < str2.length(); i++) {
            int index = str2.charAt(i) - 'a';
            arr[1][index]++;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.abs(arr[0][i] - arr[1][i]);
        }

        System.out.println(result);
    }
}