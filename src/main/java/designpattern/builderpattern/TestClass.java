package designpattern.builderpattern;

public class TestClass {
    public static void main(String[] args) {
        Student s1 = new Student.Builder().setName("Satish").setAge(28).setRollno(101).setCourse("DSA").build();
        System.out.println(s1);
    }
}
