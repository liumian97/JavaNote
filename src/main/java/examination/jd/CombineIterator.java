package examination.jd;


import java.util.Iterator;

/**
 * 根据输入的数据，以及需要组合的大小生成满足要求的组合数
 * @author kitbox.net
 */
@SuppressWarnings("rawtypes")
public class CombineIterator implements Iterator {
    //源数据
    private int[] source;
    //结果数组大小
    private int resultSize;
    //结果数组个数
    private int size;
    //当前元素索引
    private int[] index;
    //当前序列索引
    private int offset = 0;

    public CombineIterator(int[] source, int resultSize) {
        if (source == null) throw new NullPointerException();
        int n = source.length;
        if (n < resultSize || resultSize <= 0)
            throw new IllegalArgumentException("size : " + n + ", m : " + resultSize);
        this.source = source;
        this.size = clacSize(n, resultSize);
        this.resultSize = resultSize;
        this.index = new int[resultSize];
        for (int i = 0; i < resultSize; i++) {
            this.index[i] = i;
        }
        this.index[resultSize - 1] -= 1;
    }

    /**
     * n中选m
     *
     * @param n
     * @param m
     * @return
     */
    private int clacSize(int n, int m) {
        return Factorial.factorial(n - m + 1, n).divide(Factorial.factorial(m)).intValue();
    }

    /**
     * 获取迭代器内元素总数
     *
     * @return
     */
    public int size() {
        return size;
    }

    public boolean hasNext() {
        return offset < size;
    }

    @Override
    public int[] next() {
        int idx = resultSize - 1;
        int n = source.length;
        //当index最后一个索引小于source长度时，直接递增
        if (index[idx] < n - 1) {
            index[idx] += 1;
        } else {
            //操作倒数第二个索引
            idx -= 1;
            //如果当前索引等于下一个索引 - 1，说明当前索引已经不能移动了，那么继续检测前一个索引
            while (idx > 0 && index[idx] == index[idx + 1] - 1) {
                idx -= 1;
            }
            //当前索引加一，相当于源数组向后移动一位
            index[idx] += 1;
            for (int i = idx + 1; i <= resultSize - 1; i++) {
                index[i] = index[idx] + (i - idx);
            }
        }
        int[] result = new int[resultSize];
        for (int i = 0; i <= resultSize - 1; i++) {
            result[i] = source[index[i]];
        }
        offset++;
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }


    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        int length = 5;
        int resultSize = 3;
        int[] source = new int[length];
        for (int i = 0; i < length; i++) {
            source[i] = i + 1;
        }
        CombineIterator itr = new CombineIterator(source, resultSize);
        //LinkedList<int[]> list = new LinkedList<int[]>();
        while (itr.hasNext()) {
            int[] a = itr.next();
            for (int i : a) {
                System.out.print(i);
            }
            System.out.println();
            //list.add(a);
        }
        long t2 = System.currentTimeMillis();
        System.out.println("耗时：" + (t2 - t1));//44~48ms
        //System.out.println("总计:" + list.size());
    }
}



