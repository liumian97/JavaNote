package examination.jd;

import java.util.Scanner;

/**
 * Created by liumian on 2017/4/7.
 */
public class Test1 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int bitLength = scanner.nextInt();

        String sa = scanner.next();

        String sb = scanner.next();

        int a = 0, b = 0;
        for (int i = 0; i < bitLength; i++) {
            a = a * 2 + sa.charAt(i) - 48;
            b = b * 2 + sb.charAt(i) - 48;
        }

//        System.out.println(a + " - " + b);


        System.out.println(a ^ b);


    }


}
