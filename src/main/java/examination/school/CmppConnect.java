package examination.school;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * cmpp_connect消息体
 * Created by liumian on 2017/3/28.
 */
public class CmppConnect {

    private CmppConnectHeader header;

    //6字节
    private String sourceAddr;
    //16字节
    private String authenticatorSource;
    //1字节
    private byte version;
    //4字节
    private int timeStamp;

    public CmppConnect(CmppConnectHeader header) {
        this.header = header;
    }

    public void setAuthenticatorSource(String src){
        //用于加密的字符
        char md5String[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        //使用平台的默认字符集将此 String 编码为 byte序列，并将结果存储到一个新的 byte数组中
        byte[] btInput = src.getBytes();

        //信息摘要是安全的单向哈希函数，它接收任意大小的数据，并输出固定长度的哈希值。
        MessageDigest mdInst = null;
        try {
            mdInst = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //MessageDigest对象通过使用 update方法处理数据， 使用指定的byte数组更新摘要
        mdInst.update(btInput);

        // 摘要更新之后，通过调用digest（）执行哈希计算，获得密文
        byte[] md = mdInst.digest();

        // 把密文转换成十六进制的字符串形式
        int j = md.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {   //  i = 0
            byte byte0 = md[i];  //95
            str[k++] = md5String[byte0 >>> 4 & 0xf];    //    5
            str[k++] = md5String[byte0 & 0xf];   //   F
        }
        authenticatorSource = new String(str);
    }

    public void setSourceAddr(String sourceAddr){
        this.sourceAddr = sourceAddr;
    }

    public void setVersion(byte version) {
        this.version = version;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSourceAddr() {
        return sourceAddr;
    }

    public String getAuthenticatorSource() {
        return authenticatorSource;
    }

    public byte getVersion() {
        return version;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public byte[] getBytes(){
        return null;
    }

}
