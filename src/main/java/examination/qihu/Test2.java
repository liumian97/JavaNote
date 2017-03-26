package examination.qihu;

import java.util.Scanner;

/**
 * Created by liumian on 2017/3/25.
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        char[] chars = s.toCharArray();

        int total = 0;

        //子串长度
        for (int i = 0; i < s.length(); i++) {
            //向后推进
            for (int j = 0; j < i; j++) {
                byte[] result = new byte[26];

                for (int k = j; k < i + j; k++) {
                    result[chars[k] % 26] += 1;
                }

                boolean b = true;
                for (int k = 0; k < i; k++) {
                    if (result[chars[k] % 26] % 2 != 0) {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    total++;
                }
            }
        }
        System.out.println(total);
    }

}
