package examination.ctrip;

import java.util.Scanner;



/**
 * 还原完整拼图的最少移动次数。如不需要调整，则输出0；如无解，则输出-1。
    例如：
    0 1 3
    4 2 5
    7 8 6
    依次移动1,2,5,6，即可还原为正确拼图，移动次数为4
 *
 * Created by liumian on 2017/4/11.
 */
public class Test2{

    /*请完成下面这个函数，实现题目要求的功能*/
    /*当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */
    /******************************开始写代码******************************/
    static int run(String numbers){


        return 0;
    }
    /******************************结束写代码******************************/

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String numbers = new String();
        for(int rows=3; rows>0; rows--){
            for(String n: scan.nextLine().split(" ")){
                numbers += n;
            }
        }

        int res = run(numbers);

        System.out.println(String.valueOf(res));
    }
}

