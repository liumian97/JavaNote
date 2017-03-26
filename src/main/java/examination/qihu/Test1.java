package examination.qihu;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by liumian on 2017/3/25.
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] x = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextInt();
            p[i] = in.nextInt();
        }


        int total = 0;
        int size = 0;
        for (int i = 0; i < n; i++) {
            total += x[i] * p[i];
            size +=p[i];
        }
        if (size != 100){
            return;
        }

        BigDecimal result = new BigDecimal(total);
        result = result.divide(new BigDecimal(size));
        result = result.setScale(3,BigDecimal.ROUND_HALF_DOWN);

        System.out.println(result);
    }


}
