package base.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

/**
 * Created by liumian on 2017/4/16.
 */
public class NioFileTest {


    public static void main(String[] args) {

        FileWriter writer = new FileWriter("nio.txt");
        writer.write("this is a test !");
        System.out.println(writer.read());

    }


    static class FileWriter{

        String filePath;

        File file;

        FileChannel fc;

        public FileWriter(String filePath) {
            this.filePath = filePath;
            init();
        }

        private void init(){
            file = new File(filePath);
            try {
                file.createNewFile();
                fc = new RandomAccessFile(file,"rw").getChannel();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public void write(String content){
            try {
                fc.write(ByteBuffer.wrap(content.getBytes()));
                fc.write(ByteBuffer.wrap("apple".getBytes()),file.length());
//                fc.force(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public String read(){
            try {
                ByteBuffer buffer = ByteBuffer.allocate(200);
                fc.read(buffer);
                return buffer.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

    }


}
