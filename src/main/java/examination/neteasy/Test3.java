package examination.neteasy;

import java.util.Scanner;

/**
 * 魔力手环
 * <p>
 * Created by liumian on 2017/3/25.
 */
public class Test3 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] num = new int[n + 1];
        int i = 0;
        while (in.hasNextInt()) {//注意while处理多个case
            num[i] = in.nextInt();
            i++;
            if (i == n) {
                break;
            }
        }
        num[n] = num[0];

        for (int j = 0; j < k; j++) {

            for (int l = 0; l < n; l++) {
//                int r = num[l] + num[l+1];
//                num[l] = r > 100 ? r - 100 : r;

                num[l] = (num[l] + num[l + 1]) % 100;


            }
            num[n] = num[0];

        }

        for (int j = 0; j < n - 1; j++) {
            System.out.print(num[j] + " ");
        }
        System.out.print(num[n - 1]);

    }

}
