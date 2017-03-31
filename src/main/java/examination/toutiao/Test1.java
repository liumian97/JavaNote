package examination.toutiao;

import java.util.Scanner;


/**
 * 按数组的形式给出函数f(x)的取值，即数组A的A[0]元素为f(0)的取值，数组的取值都为整数，函数在每个点都是严格单调递增或者严格递减（即A[i-1] != A[i] != A[i+1]），要求找出最宽的先上升后下降的区间（这个区间内函数的值必须先上升到一个点然后下降，区间的上升段和下降段长度必须都大于0）。
 * 1. 如果找到符合条件的最大区间输出数组对应的左右下标（有多个最大区间时，输出最左边的那个”）
 * 2. 找不到那么输出-1 -1
 * <p>
 * Created by liumian on 2017/3/30.
 */
public class Test1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] values = new int[count];
        for (int i = 0; i < count; i++) {
            values[i] = in.nextInt();
        }

        int[] record = {-4, 0, 0};

        for (int i = 0; i < count - 2; i++) {
            if (values[i] < values[i + 1] && values[i + 1] < values[i + 2]) {

                boolean isContinue = true;
                int right = i + 1;
                int left = i;
                while (right < count - 2 && isContinue) {
                    isContinue = false;
                    if (values[right + 1] > values[right + 2]) {

                        int diff = right - left + 2;

                        if (record[0] <= diff) {
                            record[2] = right + 2;
                            record[0] = diff + 2;
                        }

                        isContinue = true;
                    }
                    right++;
                }
                isContinue = true;

                while (left > -1 && isContinue) {
                    isContinue = false;
                    if (values[left] < values[left + 1]) {

                        int diff = right - left+2;

                        if (record[0] <= diff) {
                            record[1] = left;
                            record[0] = diff;
                        }

                        isContinue = true;
                    }
                    left--;
                }


            }
        }

        System.out.println(record[0] +" "+record[1] + " " + record[2]);
    }


}
