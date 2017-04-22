package examination.ctrip;

import java.util.*;


/**
 * 一个一维数组，记录n天中每天的携程股价。
 * 股市交易规则如下：
 * a）一天只能有买进或者卖出一种操作，也可以不做任何操作，卖出时价格减买入时价格即为收益
 * b）每次卖出操作后有冻结期，k天之后才能进行下一次买进操作（k>=1）
 * c）买进之后必须卖出才能再次买进
 * 设计一个算法，找到交易收益最大化的买进卖出策略，返回最后的最大收益值
 * <p>
 *
 *     画出折线图，
 *     理想的情况下在最低点买入，最高点卖出，
 *     不理想的情况（有可能拐点在k天）这时候需要列举出所有情况
 *
 * Created by liumian on 2017/4/11.
 */
public class Test3 {


    /*请完成下面这个函数，实现题目要求的功能*/
    /*当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */

    /******************************开始写代码******************************/
    static int maxProfit(int[] stockPrices, int k) {


        int result = 0;

        int price = 0;

        int index;
        for (int i = 0; i < stockPrices.length; i++) {

            int lowerPrice = 0;
            for (int j = 0; j < k; j++) {

                if (price == 0) {
                    //准备买入
                    if (lowerPrice > stockPrices[i+j]){
                        lowerPrice = stockPrices[i+j];
                    }else {

                    }
                } else {
                    //准备卖出

                }
            }
        }


        return 0;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _stockPrices_size = 0;
        _stockPrices_size = Integer.parseInt(in.nextLine().trim());
        int[] _stockPrices = new int[_stockPrices_size];
        int _stockPrices_item;
        for (int _stockPrices_i = 0; _stockPrices_i < _stockPrices_size; _stockPrices_i++) {
            _stockPrices_item = Integer.parseInt(in.nextLine().trim());
            _stockPrices[_stockPrices_i] = _stockPrices_item;
        }

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        res = maxProfit(_stockPrices, _k);
        System.out.println(String.valueOf(res));

    }
}
