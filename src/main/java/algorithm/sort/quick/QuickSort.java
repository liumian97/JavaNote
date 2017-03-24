package algorithm.sort.quick;

import algorithm.sort.Sort;

/**
 * Created by LiuMian on 2015/12/22.
 */
public class QuickSort implements Sort {


    public static void main(String[] args) {
        int[] src = {2, 3, 65, 435, 75, 32, 7, 8, 456, 2, 7, 8, 2435, 865, 4352};
        QuickSort sort = new QuickSort();
        sort.sort(src);
        for (int i : src) {
            System.out.printf(i + " ");
        }
    }


    @Override
    public int[] sort(int[] src) {
        quickSort(src, 0, src.length - 1);
        return src;
    }

    private int doPartition(int[] src, int first, int end) {
        while (first < end) {
            while (first < end && src[first] <= src[end])
                end--;
            //交换数据
            if (first < end) {
                int temp = src[first];
                src[first] = src[end];
                src[end] = temp;
                first++;
            }

            while (first < end && src[first] <= src[end])
                first++;
            if (first < end) {
                int temp = src[first];
                src[first] = src[end];
                src[end] = temp;
                end--;
            }
        }
        return first;       //first == end
    }

    private void quickSort(int[] src, int first, int end) {
        if (first < end) {
            int pivot = doPartition(src, first, end);
            quickSort(src, first, pivot - 1);
            quickSort(src, pivot + 1, end);
        }

    }

}
