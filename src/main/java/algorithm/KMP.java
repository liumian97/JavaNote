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


    /**
     * 求出搜索词中已经比较过的字符串中部分匹配值的长度
     *
     * @param pattern 搜索词
     * @param index   已经匹配到的下表
     * @return 部分匹配值的长度
     */
    private int commonLength(char[] pattern, int index) {

//        if (index > pattern.length || index < 3) {
//            return 0;
//        }

        int nextIndex = 0;
        int tempIndex = 0;
        //比较最前缀和最后缀是否相等
        //因为要分前缀和后缀，所以后缀必须要保留一位
        for (int i = 1; i < index; i++) {
            tempIndex = 0;
            for (int j = 0; j < i; j++) {

                if (pattern[j] == pattern[index - i + j]) {
                    tempIndex++;
                } else {
                    tempIndex = 0;
                }

                if (nextIndex <= tempIndex) {
                    nextIndex = tempIndex;
                }

            }

        }

        return nextIndex;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.commonLength("ababa".toCharArray(), 4));
    }

}
