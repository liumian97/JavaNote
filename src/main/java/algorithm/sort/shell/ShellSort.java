package algorithm.sort.shell;

import algorithm.sort.Sort;

/**
 * Created by liumian on 2017/3/23.
 */
public class ShellSort implements Sort {


    @Override
    public int[] sort(int[] src) {

        int length = src.length;

        //每趟的步长缩小一半
        for (int d = length / 2; d > 1; d = d / 2) {

            //向后遍历
            for (int i = d + 1; i < length; i++) {

                //
                int temp = src[i];
                int j = i - d;
                //从后往前遍历
                for (; j > 0 && temp < src[j]; j = j - d) {
                    //向后移动
                    src[j + d] = src[j];
                }
                //将temp放在最前面
                src[j + d] = temp;
            }

        }


        return src;
    }


}
