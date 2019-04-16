
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int len = skill_trees.length;
        int skillLen = skill.length();
        int skillTreeLen;
        boolean canLearn;
        int nowIndex;

        for (int i = 0; i < len; i++) {
            canLearn = true;
            nowIndex=0;
            skillTreeLen = skill_trees[i].length();
            for (int j = 0; j < skillTreeLen && canLearn; j++) {
                for (int k = 0; k < skillLen; k++) {
                    if (skill_trees[i].charAt(j) == skill.charAt(k)) {
                        if(nowIndex < k){
                            canLearn = false;
                        }
                        else{
                            nowIndex++;
                        }
                        break;
                    }
                }
            }
            if (canLearn)
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));

    }
}