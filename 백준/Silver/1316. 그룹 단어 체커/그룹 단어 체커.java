import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = null;
        
        int count = 0;
		n = Integer.parseInt(br.readLine());
 
		for (int i = 0; i < n; i++) {
			if (check() == true) {
				count++;
			}
		}
		System.out.println(count);
	}
 
	public static boolean check() throws IOException {
		boolean[] check = new boolean[26];
		int prev = 0;
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			int now = str.charAt(i);	
			
			
			
			if (prev != now) {		
				
				if ( check[now - 'a'] == false ) {
					check[now - 'a'] = true;		
					prev = now;					
				}
	 
				
				else {
					return false;	//함수 종료
				}
			}
	        
	        
			
			else {
				continue;
			}
		}    
		return true;
	}
}
    
    
