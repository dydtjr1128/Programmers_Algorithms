public class Solution {
    public int solution(String dartResult) {
        StringBuilder builder = new StringBuilder();
        int answer = 0;
        int len = dartResult.length();
        int value[] = new int[3];
        int nowIndex = 0;
        char c;
        int num;
        boolean isMun= false;
        for (int i = 0; i < len; i++) {
            c = dartResult.charAt(i);
            isMun = false;
            switch (c) {
                case 'S':
                    value[nowIndex++] = Integer.parseInt(builder.toString());
                    builder.setLength(0);
                    isMun = true;
                    break;
                case 'D':
                    num = Integer.parseInt(builder.toString());
                    value[nowIndex++] = (int) Math.pow(num, 2);
                    builder.setLength(0);
                    isMun = true;
                    break;
                case 'T':
                    num = Integer.parseInt(builder.toString());
                    value[nowIndex++] = (int) Math.pow(num, 3);
                    builder.setLength(0);
                    isMun = true;
                    break;
            }
            if (i + 1 < len) {
                if (dartResult.charAt(i + 1) == '*') {
                    value[nowIndex - 1] *= 2;
                    if (nowIndex > 1)
                        value[nowIndex - 2] *= 2;
                    i++;
                } else if (dartResult.charAt(i + 1) == '#') {
                    value[nowIndex - 1] *= -1;
                    i++;
                }
            }
            if(!isMun){
                builder.append(c);
            }
        }
        answer = value[0] + value[1] + value[2];



        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("1S2D*3T"));
        System.out.println(solution.solution("1D2S#10S"));
        System.out.println(solution.solution("1D2S0T"));
        System.out.println(solution.solution("1S*2T*3S"));
        System.out.println(solution.solution("1D#2S*3S"));
    }
}