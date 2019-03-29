import java.util.ArrayList;
public class Solution {

    public int intersection(ArrayList<String> list1, ArrayList<String> list2) {
        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    list1.remove(i);
                    list2.remove(j);
                    count++;
                    i--;
                    break;
                }
            }
        }
        return count;
    }

    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int len1 = str1.length();
        int len2 = str2.length();
        ArrayList<String> arrayList1 = new ArrayList<>();
        ArrayList<String> arrayList2 = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        String temp;
        for (int i = 0; i < len1 - 1; i++) {
            temp = str1.substring(i, i + 2);
            if (temp.charAt(0) >= 'a' && temp.charAt(0) <= 'z' && temp.charAt(1) >= 'a' && temp.charAt(1) <= 'z') {
                arrayList1.add(temp);
            }
        }
        for (int i = 0; i < len2 - 1; i++) {
            temp = str2.substring(i, i + 2);
            if (temp.charAt(0) >= 'a' && temp.charAt(0) <= 'z' && temp.charAt(1) >= 'a' && temp.charAt(1) <= 'z') {
                arrayList2.add(temp);
            }
        }
        if(arrayList1.size() == 0 && arrayList2.size() ==0){
            return 65536;
        }
        int b = intersection(arrayList1, arrayList2);
        int a = b + arrayList1.size() + arrayList2.size();

        answer = (int) (((double) b / a) * 65536);
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.solution("FRANCE", "french"));
        //System.out.println(solution.solution("handshake", "shake hands"));
        //System.out.println(solution.solution("aa1+aa2", "AAAA12"));
        System.out.println(solution.solution("E=M*C^2", "e=m*c^2"));

    }
}