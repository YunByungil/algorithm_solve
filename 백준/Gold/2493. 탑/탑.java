import java.util.*;
import java.io.*;


public class Main {
    static class Top {
        private int index;
        private int height;
        
        public Top(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        Stack<Top> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            
            if (s.isEmpty()) {
                s.push(new Top(i, height));
                sb.append(0).append(" ");
            } else {
                while(true) {
                    if (s.isEmpty()) {
                        sb.append(0).append(" ");
                        s.push(new Top(i, height));
                        break;
                    }
                    
                    if (s.peek().height < height) {
                        s.pop();
                    } else {
                        sb.append(s.peek().index).append(" ");
                        s.push(new Top(i, height));
                        break;
                    }
                }
                
            }
        }
        
        System.out.println(sb);
        
    }
}