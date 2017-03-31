package examination.school;

/**
 * Created by liumian on 2017/3/31.
 */
public class MoPattern {


    public boolean patter(String src, String pattern, int flag) {
        //精确匹配
        if (flag == 1) {
            if (src.length() !=  pattern.length()){
                return false;
            }
            //匹配所有的字符
            for (int i = 0; i < pattern.length(); i++) {
                //任意一个字符不相等，那么直接返回false
                if(src.indexOf(i) != pattern.indexOf(i)){
                    return false;
                }
            }
        } else {
            //模糊匹配，后面的字符不要求全部匹配
            for (int i = 0; i < pattern.length(); i++) {
                //如果匹配到不相等的字符，那么返回false
                if(src.indexOf(i) != pattern.indexOf(i)){
                    return false;
                }
            }
        }
        return true;
    }

}
