package algorithm.offer;

/**
 *
 * 字符串全排列
 *
 * Created by liumian on 2017/3/26.
 */
public class StringPermutation {

    public static void main(String[] args) {
        StringPermutation permutation = new StringPermutation();
        permutation.permutation("abc");
    }


    public void permutation(String s){
        if(s == null){
            return;
        }
        permutation(s.toCharArray(),0);
    }

    public void permutation(char[] chars, int index) {

        if (index == chars.length) {
            System.out.println(new String(chars));
            return;
        }


        for (int i = index; i < chars.length; i++) {
            //第一个字符与第i个字符交换
            char temp = chars[i];
            chars[i] = chars[0];
            chars[0] = temp;

            permutation(chars,index+1);

            //交换回来
            temp = chars[i];
            chars[i] = chars[0];
            chars[0] = temp;

        }
    }


}
