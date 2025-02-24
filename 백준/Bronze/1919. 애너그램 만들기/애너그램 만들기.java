import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        // occurs 영단어와 succor는 서로 애너그램 관계
        
        // aabbcc, xxyybb가 존재할 때
        // 애너그램 관계를 만들기 위해서는 aa, cc, xx, yy
        // 따라서 총 8개를 제거해야 된다.
        
        String str1 = br.readLine();
        String str2 = br.readLine();
        
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        
        for (int i = 0; i < str1.length(); i++) {
            int num = str1.charAt(i) - 'a';
            arr1[num]++;
        }
        
        for (int i = 0; i < str2.length(); i++) {
            int num = str2.charAt(i) - 'a';
            arr2[num]++;
        }
        
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                int result = Math.abs(arr1[i] - arr2[i]);
                answer += result;
            }
        }
        
        System.out.println(answer);
    }
}   