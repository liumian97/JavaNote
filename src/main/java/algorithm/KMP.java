package algorithm;

/**
 * KMP算法
 * 参考:
 * 1、http://blog.csdn.net/v_july_v/article/details/7041827
 * 2、http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 * <p>
 * Created by liumian on 2017/3/31.
 */
public class KMP {


    public boolean kmp(String src, String pattern) {
        if (pattern == null || src == null) {
            return false;
        }

        char[] patternChars = pattern.toCharArray();
        int[] nextIndex = commonLength(patternChars, patternChars.length);

        char[] srcChars = src.toCharArray();
        int patternIndex = 0;
        int srcIndex = 0;

        while (srcIndex < srcChars.length && patternIndex < patternChars.length) {

            //patterIndex == -1，说明第一个字符没有匹配上
            if (patternIndex == -1 || srcChars[srcIndex] == patternChars[patternIndex]) {
                patternIndex++;
                srcIndex++;
            } else {
                //失配时，模式串向右移动的位数为：失配字符所在位置 - 失配字符对应的next 值
                //即模式串的nextIndex[patternIndex]与src的srcIndex比较
                patternIndex = nextIndex[patternIndex];
            }

        }

        if (patternIndex == pattern.length()) {
            return true;
        } else {
            return false;
        }

    }


    /**
     * 求出搜索词中已经比较过的字符串中部分匹配值的长度
     *
     * @param pattern 搜索词
     * @param length  已经匹配到的下表
     * @return 部分匹配值的长度
     */
    private int[] commonLength(char[] pattern, int length) {

        int nextIndex[] = new int[length];

        for (int right = 1; right < length; right++) {
            //模式串在当前长度下的最前缀和最后缀的共同长度
            int commonLength = 0;
            //step为步长，当前长度下的搜索词的分割长度，用于求不同步长下的共同长度，取最大值
            for (int step = 0; step < right; step++) {
                //prefixLeft，前缀的起始位置
                //suffixLft，后缀的起始位置
                for (int prefixLeft = 0, suffixLeft = right - step;
                     suffixLeft <= right;
                     prefixLeft++, suffixLeft++) {

                    if (pattern[prefixLeft] == pattern[suffixLeft]) {
                        commonLength++;
                    }

                }
                if (right == length - 1) {
                    nextIndex[0] = -1;
                } else {
                    if (nextIndex[right + 1] < commonLength) {
                        nextIndex[right + 1] = commonLength;
                    }
                }

            }


        }

        return nextIndex;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String src = "ABCDABD";
        int[] next = kmp.commonLength(src.toCharArray(), src.length());
        for (int i : next) {
            System.out.println(i);
        }
        System.out.println(kmp.kmp(src, "ABL"));
    }

}
