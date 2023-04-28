class Solution {
    public int solution(int num) {
        
        int answer = 0;
        while (num > 1) {
            if(num % 2 == 0) {
                num /= 2;
            } else {
                num *= 3;
                num += 1;
            }
            
            answer++;
            
            
        }
        System.out.println(answer);
        

        return num == 1 ? answer : -1;
    }
}