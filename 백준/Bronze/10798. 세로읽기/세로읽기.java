import java.util.*;
import java.io.*;

public class Main {
    public static int n, r, c, answer;
    public static int[][] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] input = new char[5][15]; 
 
        for (int i = 0; i < input.length; i++) {
            String str = br.readLine();
            
            for (int j = 0; j < str.length(); j++) {
                input[i][j] = str.charAt(j);
            }
        }
 
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (input[j][i] == '\0') {
                    continue;
                }
                
                System.out.print(input[j][i]);
            }
        }
    }
}    
