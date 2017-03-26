package examination.neteasy;

import java.util.Scanner;

/**
 *
 * 男生女生排队
 *
 * Created by liumian on 2017/3/25.
 */
public class Test2 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        char[] src = s.toCharArray();
        if(src.length ==0){
            System.out.print(0);

        }else if(src.length == 1 || src.length ==2){
            System.out.print(1);
        }

        int times = sort(src);
        System.out.print(times);


    }


    public static int sort(char[] src) {
        int sorted = src.length - 1;
        int times = 0;
        while (sorted != 0) {
            int unsorted = sorted;
            sorted = 0;
            for (int index = 1; index < unsorted; index++) {
                if (src[index] > src[index + 1]) {
                    src[0] = src[index];
                    src[index] = src[index + 1];
                    src[index + 1] = src[0];
                    sorted = index;
                    times++;
                }
            }
        }
        return times;
    }


}
