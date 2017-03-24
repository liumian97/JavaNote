package algorithm.sort.bubble;

import algorithm.sort.Sort;

/**
 * Created by LiuMian on 2015/12/22.
 */
public class BubbleSort implements Sort {


    @Override
    public int[] sort(int[] src) {
        int sorted = src.length - 1;        //记录更新的index，后面的数据都已经排好
        while (sorted != 0) {               //sorted==0意味着后面都已经排好
            int unsorted = sorted;
            sorted = 0;
            for (int index = 1; index < unsorted; index++) {
                if (src[index] > src[index + 1]) {
                    src[0] = src[index];
                    src[index] = src[index + 1];
                    src[index + 1] = src[0];
                    sorted = index;          //后面的数据都已经排好
                }
            }
        }
        return src;
    }

//    private void swap(int[] src,int )
}
