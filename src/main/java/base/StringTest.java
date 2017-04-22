package base;

/**
 * Created by liumian on 2017/4/10.
 */
public class StringTest {


    public static void main(String[] args) {
        String a = "abc";
        f(a);
        System.out.println(a);
        Student student = new Student();
        student.name = "liu";
        f(student);
        System.out.println(student.name);
    }

    public static void f(String s) {
//        s = "123";
        s = new String("def");
    }

    public static void f(Student student) {
        student.name = "mian";
    }


}

class Student {

    String name;


}