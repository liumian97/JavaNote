package examination.qihu;

import java.util.Scanner;

/**
 * Created by liumian on 2017/3/25.
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int todoList = in.nextInt();
        int tempList = in.nextInt();

        int[] todoTime = new int[todoList];
        for (int i = 0; i < todoList; i++) {
            todoTime[i] = in.nextInt();
        }

        int[] receiveTime = new int[todoList];
        for (int i = 0; i < tempList; i++) {
            receiveTime[i] = in.nextInt();
        }

        int current = 0;
        for (int i = 0; i < todoList - 1; i++) {

            if (todoTime[i] != todoTime[i + 1] + 1) {

                for (int j = current; j < tempList; j++) {

                    if (receiveTime[j] <= todoTime[i]) {
                        System.out.println(todoTime[i]);
                        current = j+1;
                    }
                }
            }
            if (current == tempList) {
                break;
            }
        }
        for (;current < tempList;current++){
            System.out.println(todoTime[todoList-1]+1);
        }

    }

}
