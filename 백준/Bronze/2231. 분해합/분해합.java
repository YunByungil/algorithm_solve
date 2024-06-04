import java.util.*;
import java.io.*;

public class Main {
    public static int n, m, k, t, w;
    public static int[] arr;
    public static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = null;
        
        n = Integer.parseInt(br.readLine());
        
        int result = 0;
        
        for(int i = 0; i < n; i++) {
			int number = i;
			int sum = 0;	// 각 자릿수 합 변수 
			
			while(number != 0) {
				sum += number % 10;	// 각 자릿수 더하기
				number /= 10;
			}
			
			// i 값과 각 자릿수 누적합이 같을 경우 (생성자를 찾았을 경우) 
			if(sum + i == n) {
				result = i;
				break;
			}
			
		}
 
		System.out.println(result);
        
    }
}
    
    
