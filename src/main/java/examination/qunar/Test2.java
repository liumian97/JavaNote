package examination.qunar;

import java.util.Scanner;

/**
 * 进制转换
 * <p>
 * 用英文字母a-z来分别表示数值0-25, 形成一个26进制的数值表示法。
 * 需要你写一个方法，将用a-z表示的26进制数值的字符串，转化为对应的10进制数值。
 * Created by liumian on 2017/4/1.
 */
public class Test2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String[] inputs = new String[size];
        for (int i = 0; i < size; i++) {
            inputs[i] = scanner.next();
        }
        for (int i = 0; i < size; i++) {
            transfer(inputs[i].toCharArray());
        }


//        transfer("ba".toCharArray());
    }

    public static void transfer(char[] input) {

        int result = 0;
        for (int i = 0; i < input.length; i++) {
            result = result * 26 + (input[i] - 97);
        }
        System.out.println(result);

    }

}
