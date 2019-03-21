import java.io.IOException;

public class Solution {
    public String solution(int n) {
        StringBuilder builder = new StringBuilder();

        int t;
        //11 42
        //12 44
        //13 111
        //14 112
        //15 114
        //16 121
        //17 122
        //18 124
        //19 141
        //20 142
        //21 144
        //22 211
        //23 212
        //24 214
        //25 221
        //26 222
        //27 224
        //28 241
        //29 242
        //30 244
        while (n > 1) {
            t = n % 3;
            if (t == 0) {
                builder.insert(0, "4");
                n /= 3;
                n--;
                //t+=4;
            } else {
                //builder.insert(0,num[n % 3]);
                builder.insert(0, t);
                n /= 3;
                //t += (n % 3);
            }

            //n /=3;
        }
        builder.insert(0, n % 3);

        return builder.toString().replace("0", "");
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        for (int i = 0; i < 30; i++) {
            System.out.println(solution.solution(i));
        }
    }
}