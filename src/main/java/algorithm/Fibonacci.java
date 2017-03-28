package algorithm;

/**
 * 两种递归：
 * 1. 一种无重复计算
 * 2. 一种会重复计算原来已经计算过的值
 * <p>
 * Created by liumian on 2017/3/26.
 */
public class Fibonacci {


    /**
     * 从0,1往上循环,无重复
     *
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     *
     * @param n       f(n)
     * @param index   目前计算的位置
     * @param current 上一次运算的结果
     * @param pre     上上次运算的结果
     * @return
     */
    public long f(long n, long index, long current, long pre) {

        if (index < n) {
            if (index == 0) {
                return f(n, index + 1, 0, 0);

            }
            if (index == 1) {

                return f(n, index + 1, 1, current);
            }

            return f(n, index + 1, current + pre, current);

        } else {
            return current + pre;
        }


    }

    /**
     * 常规的递归方式，会重复计算已经计算过的值
     *
     * 时间复杂度：o()
     * 空间复杂度：o(1)
     *
     * @param n
     * @return
     */
    public long f(long n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }


    /**
     * 通过循环实现
     *
     * 时间复杂度：o(n)
     * 空间复杂度：o(1)
     *
     * @param n
     * @return
     */
    public long fByLoop(int n) {

        long[] result = {0, 1};

        for (int i = 2; i < n + 1; i++) {
            result[i & 1] += result[(i + 1) & 1];
        }

        return result[n & 1];

    }


    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        int n = 100;
        System.out.println("计算:"+n+"项斐波那契数列");

        long start = System.nanoTime();
        System.out.println("无重复递归:");

        System.out.println(fibonacci.f(n, 0, 0, 0));
        long stamp1 = System.nanoTime();
        System.out.println("归用时(nano)：" + (stamp1 - start));

        System.out.println("重复递归:");
        System.out.println(fibonacci.f(n));

        long stamp2 = System.nanoTime();

        System.out.println("重复递归用时(nano)：" + (stamp2 - stamp1));

        System.out.println("循环方式:");
        System.out.println(fibonacci.fByLoop(n));

        long end = System.nanoTime();
        System.out.println("循环用(nano)：" + (end - stamp2));

    }


}
