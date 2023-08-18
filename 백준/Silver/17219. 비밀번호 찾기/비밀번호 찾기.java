import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 저장된 사이트 주소의 수
        int m = Integer.parseInt(st.nextToken()); // 비밀번호를 찾으려는 사이트 주소의 수
        
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            map.put(site, password);
        }
        
        for (int i = 0; i < m; i++) {
            String site = br.readLine();
            System.out.println(map.get(site));
        }
    }
}
