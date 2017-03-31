package examination.school;

import java.util.Scanner;

/**
 * Created by liumian on 2017/3/31.
 */
public class MoPatternTest {

    public static void main(String[] args) {

        MoText[] moTexts = new MoText[5];

        moTexts[0] = new MoText("10628888","xw",1,0);
        moTexts[0] = new MoText("1062888801","xw",0,0);
        moTexts[0] = new MoText("1062888801","xw1",0,1);
        moTexts[0] = new MoText("10628888","01xw",1,1);
        moTexts[0] = new MoText("10628888","xw",0,0);

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入需要匹配的号码,字符内容");
        String accessNo = scanner.nextLine();
        String str = scanner.nextLine();

        MoPattern pattern = new MoPattern();
        for (int i = 0; i < moTexts.length; i++) {
            if(pattern.patter(moTexts[i].accessNo,accessNo,moTexts[i].accessCheck)){
                if(pattern.patter(moTexts[i].str,str,moTexts[i].strCheck)){
                    System.out.println("匹配到："+moTexts[i].accessNo+moTexts[i].str);
                    return;
                }
            }
        }
        System.out.println("没有匹配到数据");

    }

}
