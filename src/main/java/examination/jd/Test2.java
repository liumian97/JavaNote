package examination.jd;

import java.util.Scanner;

/**
 * 小明同学要参加一场考试，考试一共有n道题目，小明必须做对至少60%的题目才能通过考试。
 * 考试结束后，小明估算出每题做对的概率，p1,p2,...,pn。你能帮他算出他通过考试的概率吗？
 * Created by liumian on 2017/4/7.
 *
 * 本题的核心是生成符合要求的组合数集合
 *
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();

        int[] question = new int[size];
        for (int i = 0; i < size; i++) {
            question[i] = scanner.nextInt();
        }


        int min = 0;
        for (int i = 0; i < size; i++) {
            if(5 * i >= 3 * size){
                min = i;
                break;
            }
        }




    }


}
