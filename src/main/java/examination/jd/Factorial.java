package examination.jd;

import java.math.BigInteger;

/**
 * 阶乘计算
 *
 * @author kitbox.net
 */
public class Factorial {

    /**
     * 计算1到n的阶乘,0! = 1
     *
     * @param n
     * @return 1 * 2 *3 * ... * (n - 1) * n
     */
    public static BigInteger factorial(int n) {
        if (n == 0) return new BigInteger("1");
        return factorial(1, n);
    }

    /**
     * 计算start到end的阶乘,不支持0参数
     *
     * @param start 起始数(包含)
     * @param end   终止数(包含)
     * @return start * (start + 1) * ... *(end - 1) * end
     */
    public static BigInteger factorial(int start, int end) {
        if (start <= 0 || end < start) throw new IllegalArgumentException("start : " + start + ",end : " + end);
        BigInteger result = new BigInteger("1");
        for (int i = start; i <= end; i++) {
            result = result.multiply(new BigInteger(i + ""));
        }
        return result;
    }
}
