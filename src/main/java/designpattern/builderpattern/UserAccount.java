package designpattern.builderpattern;

public class UserAccount {

    private final String username;
    private final String email;
    private final String password;
    private final String phoneNumber;
    private final String address;
    private final int age;
    private final boolean isVerified;


    private UserAccount(Builder builder){
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
        this.age = builder.age;
        this.isVerified = builder.isVerified;
    }


    static class Builder{

        private String username;
        private String email;
        private String password;
        private String phoneNumber;
        private String address;
        private int age;
        private boolean isVerified;

        public Builder(String username, String email, String password){
            this.username = username.trim();
            this.email = email.trim();
            this.password = password.trim();
        }

        public Builder setPhoneNumber(String phoneNumber){
            this.phoneNumber = phoneNumber.trim();
            return this;
        }

        public Builder setAddress(String address){
            this.address = address.trim();
            return this;
        }

        public Builder setAge(int age){
            this.age = age;
            return this;
        }

        public Builder setVerified(boolean isVerified){
            this.isVerified = isVerified;
            return this;
        }

        public UserAccount build(){
            if(email==null || !email.contains("@")){
                throw new IllegalArgumentException("Invalid Email: must contain '@'");
            }
            if(password==null || password.length()<6){
                throw new IllegalArgumentException("Password must be at least 6 character.");
            }

            return new UserAccount(this);
        }
    }


    @Override
    public String toString() {
        return "UserAccount{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isVerified=" + isVerified +
                '}';
    }
}
