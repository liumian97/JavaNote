package algorithm.sort.insert;

import algorithm.sort.Sort;

/**
 * Created by LiuMian on 2015/12/21.
 */
public class InsertSort implements Sort {


    public int[] sort(int[] src) {
        for (int i = 1; i < src.length; i++) {
            src[0] = src[i];   //记录当前值
            int j = 0;
            for (j = i - 1; src[0] < src[j]; j--) {    //在有序区比较
                src[j + 1] = src[j];      //向后移动
            }
            src[j + 1] = src[0];
        }
        return src;
    }
}
