class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder builder = new StringBuilder();
        int len = s.length();
        boolean isBlank = true;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                builder.append(' ');
                isBlank = true;
            } else if (isBlank) {
                builder.append(Character.toUpperCase(s.charAt(i)));
                isBlank = false;

            } else {
                builder.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("a1aa aA a A aa "));

    }
}