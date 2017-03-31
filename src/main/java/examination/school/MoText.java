package examination.school;

/**
 * Created by liumian on 2017/3/31.
 */
public class MoText {

    //发送方号码
    String accessNo;
    //发送内容
    String str;
    //号码匹配方式
    int accessCheck;
    //内容匹配方式
    int strCheck;


    public MoText(String accessNo, String str, int accessCheck, int strCheck) {
        this.accessNo = accessNo;
        this.str = str;
        this.accessCheck = accessCheck;
        this.strCheck = strCheck;
    }
}
