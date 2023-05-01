class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        // 1. 세 숫자가 모두 다른 경우
        if (a != b && b != c) {
            answer = a + b + c;
        } else if (a == b && b == c) {
            int sum = a + b + c;
            int sum2 = (int) Math.pow(a, 2);
            sum2 += (int) Math.pow(b, 2);
            sum2 += (int) Math.pow(c, 2);
            int sum3 = (int) Math.pow(a, 3);
            sum3 += (int) Math.pow(b, 3);
            sum3 += (int) Math.pow(c, 3);
            answer = sum * sum2 * sum3;
        } 
        // else {
        //     int sum = a + b + c;
        //     System.out.println("a: " + a);
        //     System.out.println("b: " + b);
        //     System.out.println("c: " + c);
        //     int sum2 = (int) Math.pow(a, 2);
        //     sum2 += (int) Math.pow(b, 2);
        //     sum2 += (int) Math.pow(c, 2);
        //     answer = sum * sum2;
        // }
        
        // 2. 두 숫자만 같을 때
        if ((a == b && b != c) || (b == c && a != c) || (a == c && a != b)) {
            int sum = a + b + c;
        //     System.out.println("a: " + a);
        //     System.out.println("b: " + b);
        //     System.out.println("c: " + c);
            int sum2 = (int) Math.pow(a, 2);
            sum2 += (int) Math.pow(b, 2);
            sum2 += (int) Math.pow(c, 2);
            answer = sum * sum2;
        } 
        
        
        // 3. 세 숫자가 모두 같을 때
//         if (a == b && b == c) {
            
//             int sum = a + b + c;
//             int sum2 = (int) Math.pow(a, 2);
//             sum2 += (int) Math.pow(b, 2);
//             sum2 += (int) Math.pow(c, 2);
//             int sum3 = (int) Math.pow(a, 3);
//             sum3 += (int) Math.pow(b, 3);
//             sum3 += (int) Math.pow(c, 3);
//             answer = sum * sum2 * sum3;
//         }
        return answer;
    }
}