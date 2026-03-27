package designpattern.builderpattern;

/**
 * UserAccount class represents an immutable user entity.
 *
 * DESIGN CHOICES:
 * - Uses Builder Pattern for object creation
 * - Immutable class (all fields are final)
 * - Validation is done before object creation
 *
 * WHY Builder Pattern?
 * - Avoids constructor overload (telescoping constructor problem)
 * - Improves readability
 * - Supports optional fields
 * - Ensures controlled object creation
 *
 * IMMUTABILITY:
 * - All fields are final
 * - No setters provided
 * - Object state cannot change after creation
 *
 * THREAD SAFETY:
 * - Immutable objects are inherently thread-safe
 */
public class UserAccount {

    // =========================
    // Fields (Final → Immutable)
    // =========================

    private final String username;
    private final String email;
    private final String password;
    private final String phoneNumber;
    private final String address;
    private final int age;
    private final boolean isVerified;

    /**
     * Private constructor
     *
     * WHY private?
     * - Prevent direct instantiation using new UserAccount(...)
     * - Forces usage of Builder for controlled creation
     *
     * HOW it works:
     * - Receives Builder object
     * - Copies values from Builder to final fields
     */
    private UserAccount(Builder builder){
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
        this.age = builder.age;
        this.isVerified = builder.isVerified;
    }

    /**
     * Static Nested Builder Class
     *
     * WHY static?
     * - Does not depend on outer class instance
     * - Can be created independently: new UserAccount.Builder(...)
     *
     * ROLE:
     * - Temporary container for values
     * - Provides step-by-step object construction
     * - Validates data before final object creation
     */
    static class Builder{

        // =========================
        // Builder Fields (Mutable)
        // =========================

        private String username;
        private String email;
        private String password;
        private String phoneNumber;
        private String address;
        private int age;
        private boolean isVerified;

        /**
         * Constructor with mandatory fields
         *
         * WHY mandatory?
         * - Ensures essential data is always provided
         *
         * TRIMMING:
         * - Removes unwanted spaces from input
         * - Prevents dirty data ("   rahul   ")
         */
        public Builder(String username, String email, String password){
            this.username = username.trim();
            this.email = email.trim();
            this.password = password.trim();
        }

        /**
         * Optional field setters
         *
         * WHY return this?
         * - Enables method chaining (Fluent API)
         *
         * Example:
         * new Builder(...).setAge(21).setAddress("Delhi")
         */

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

        /**
         * Final step of Builder Pattern
         *
         * WHAT it does:
         * - Validates data
         * - Creates final UserAccount object
         *
         * WHY validation here?
         * - All fields are set at this point
         * - Central place to enforce rules
         *
         * EXCEPTIONS:
         * - IllegalArgumentException used for invalid input
         */
        public UserAccount build(){

            // Validate email
            if(email == null || !email.contains("@")){
                throw new IllegalArgumentException("Invalid Email: must contain '@'");
            }

            // Validate password
            if(password == null || password.length() < 6){
                throw new IllegalArgumentException("Password must be at least 6 characters.");
            }

            // Create final immutable object
            return new UserAccount(this);
        }
    }

    /**
     * toString method for debugging/logging
     *
     * NOTE:
     * - Password intentionally excluded (security best practice)
     */
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