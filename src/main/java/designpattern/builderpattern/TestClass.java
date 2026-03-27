package designpattern.builderpattern;

public class TestClass {
    public static void main(String[] args) {
//        Student s1 = new Student.Builder().setName("Satish").setAge(28).setRollno(101).setCourse("DSA").build();
//        System.out.println(s1);

        UserAccount user1 = new UserAccount.Builder("testUserAccount","testemail@user.com","password")
                .setPhoneNumber("7070707070")
                .setAddress("Hyderabad,India")
                .setAge(40)
                .setVerified(true)
                .build();
        System.out.println(user1);
    }
}
