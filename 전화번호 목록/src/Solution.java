import java.io.*;

public class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int len = phone_book.length;
        String val;
        for (int i = 0; i < len && answer; i++) {
            val = phone_book[i];
            for (int j = 0; j < len && answer; j++) {
                if (i != j && phone_book[j].startsWith(val)) {
                    answer = false;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        /*for(int i=0; i<30; i++) {
            System.out.println(solution.solution(i));
        }*/
    }
}