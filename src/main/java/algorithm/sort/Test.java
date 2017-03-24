package algorithm.sort;

import algorithm.sort.bubble.BubbleSort;
import algorithm.sort.insert.InsertSort;
import algorithm.sort.quick.QuickSort;
import algorithm.sort.shell.ShellSort;

/**
 * Created by LiuMian on 2015/12/21.
 */
public class Test {

    public static void main(String[] args) {
        int[] integers = new int[]{3, 12, 64, 34, 32, 35, 63, 235, 543, 234, 8};
//        testInsertSort(integers);
//        testBubbleSort(integers);
//        testQuickSort(integers);
        testShellSort(integers);
    }


    public  static void testShellSort(int[] src){

        ShellSort shellSort = new ShellSort();
        int[] result = shellSort.sort(src);
        printArray(result);

    }

    public static void testInsertSort(int[] integers) {
        InsertSort insertSort = new InsertSort();
        int[] result = insertSort.sort(integers);
        printArray(integers);
    }

    public static void testBubbleSort(int[] src) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(src);
        printArray(src);
    }

    public static void testQuickSort(int[] src) {
        QuickSort quickSort = new QuickSort();
        quickSort.sort(src);
        printArray(src);
    }

    public static void printArray(int[] src){
        for (int elemet : src)
            System.out.println(elemet);
    }
}
