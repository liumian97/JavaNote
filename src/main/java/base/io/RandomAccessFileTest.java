package base.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Paths;

/**
 * Created by liumian on 2017/4/22.
 */
public class RandomAccessFileTest {

    private RandomAccessFile file;

    private String filePath;

    public RandomAccessFileTest(String filePath) {
        this.filePath = filePath;
        init();
    }

    private void init(){
        try {
            file = new RandomAccessFile(Paths.get(filePath).toFile(),"rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void write(String content){
        try {
            file.writeChars(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read(){
        try {
            return file.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }


    public static void main(String[] args) {
        RandomAccessFileTest test = new RandomAccessFileTest("randomtest.txt");
        test.write("hello ,this is randomaccessfiletest");
        System.out.println(test.read());
    }



}
