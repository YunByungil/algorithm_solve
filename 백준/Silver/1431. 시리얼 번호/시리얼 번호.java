// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static String[] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // A와 B의 길아가 짧은 것이 먼저 옴
        // 길이 같으면 A의 모든 자리수의 합, B의 모든 자리수 합 비교해서 작은 것이 먼저
        // 비교할 수 없으면 사전순으로, 숫자가 알파벳보다 사전순으로 작다.
        n = Integer.parseInt(br.readLine());
        arr = new String[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        
        Arrays.sort(arr, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return o1.length() - o2.length();
                } else if (o1.length() == o2.length()) {
                    int num1 = 0;
                    int num2 = 0;
                    for (int i = 0; i < o1.length(); i++) {
                        if (0 <= o1.charAt(i) - '0' && o1.charAt(i) - '0' <= 9) {
                            num1 += o1.charAt(i) - '0';
                        }
                    }
                    for (int i = 0; i < o2.length(); i++) {
                        if (0 <= o2.charAt(i) - '0' && o2.charAt(i) - '0' <= 9) {
                            num2 += o2.charAt(i) - '0';
                        }
                    }
                    if (num1 != num2) {
                        return num1 - num2;
                    } else if (num1 == num2) {
                        return o1.compareTo(o2);
                    }
                }
                return o1.length() - o2.length();
            }
        });
        
        
        
        
        for (String i : arr) {
            System.out.println(i);
        }
        
    }
}