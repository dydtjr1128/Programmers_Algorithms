import java.util.Arrays;

class Solution {
    int min = 0;

    public int search(String name, char[] firstName, int index, int val) {
        int a = 0, b = 0;

        firstName[index] = name.charAt(index);
        int num = getMin(name.charAt(index) - 'A','Z' - name.charAt(index) + 1);

        if (String.valueOf(firstName).equals(name)) {
            if (min > val + num)
                min = val + num;
            return val + num;
        } else if (min < val + num)
            return val + num;


        b += search(name, firstName.clone(), index - 1 < 0 ? name.length() - 1 : index - 1, val + num + 1);
        a += search(name, firstName.clone(), index + 1 >= name.length() ? 0 : index + 1, val + num + 1);//+1은 좌우 이동키 누른 횟수
        return a > b ? b : a;
    }

    public int solution(String name) {
        int answer = 0;
        char[] firstName = new char[name.length()];
        Arrays.fill(firstName, 'A');
        min = getMin(name.charAt(0) - 'A', 'Z' - name.charAt(0) + 1);
        for (int i = 1; i < name.length(); i++) {
            min += getMin(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1) + 1;
        }
        answer = search(name, firstName, 0, 0);
        return answer;
    }

    public int getMin(int a, int b) {
        return a > b ? b : a;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("JAZ"));
        System.out.println(solution.solution("JEROEN"));
        System.out.println(solution.solution("BBAAAAABAA"));


    }
}