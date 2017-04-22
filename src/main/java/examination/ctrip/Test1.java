package examination.ctrip;

import java.util.Scanner;

/**
 * 有一个整数n，将n分解成若干个不同自然数之和，问如何分解能使这些数的乘积最大，输出这个乘积m
 * <p>
 * Created by liumian on 2017/4/11.
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int temp = 2;
        int result = 1;
        while (number > temp) {

            if (temp <= number - temp) {
                result *= temp;
                number -= temp;
            }
            temp++;
        }

        System.out.println(result * number);
    }
}
