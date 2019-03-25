import java.util.Arrays;

public class Solution {
    char map[][];
    StringBuilder builder = new StringBuilder();

    public void toBinary(int a, int j, int n) {
        builder.setLength(0);
        //9 == 01001;
        while (a >= 1) {
            builder.insert(0, a % 2);
            a /= 2;
        }
        while (builder.length() != n) {
            builder.insert(0, 0);
        }
        int len = builder.length();
        for (int i = 0; i < len; i++) {
            if (builder.charAt(i) == '1' || map[j][i] == '#') {
                map[j][i] = '#';
            } else {
                map[j][i] = ' ';
            }
        }
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        map = new char[n][n];
        for (int i = 0; i < arr1.length; i++) {
            toBinary(arr1[i], i,n);
        }
        for (int i = 0; i < arr2.length; i++) {
            toBinary(arr2[i], i,n);
        }

        for (int i = 0; i < map.length; i++) {
            builder.setLength(0);
            for (int j = 0; j < map[i].length; j++) {
                builder.append(map[i][j]);
            }
            answer[i] = builder.toString();
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
        System.out.println(Arrays.toString(solution.solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10})));

    }
}