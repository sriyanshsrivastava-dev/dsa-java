package designpattern.builderpattern;

/**
 * Student class represents a simple data model.
 * This class uses the Builder Pattern to construct objects.
 */
public class Student {

    // Fields of Student (final object state)
    private String name;
    private int age;
    private int rollno;
    private String course;

    /**
     * Private constructor
     *
     * WHY private?
     * - Prevents direct object creation using new Student(...)
     * - Forces use of Builder class
     *
     * HOW it works:
     * - Takes Builder object
     * - Copies values from Builder to Student
     */
    private Student(Builder builder){
        this.age = builder.age;
        this.name = builder.name;
        this.rollno = builder.rollno;
        this.course = builder.course;
    }

    /**
     * Static Nested Builder Class
     *
     * WHY static?
     * - Builder does NOT depend on Student instance
     * - Can be created using: new Student.Builder()
     *
     * PURPOSE:
     * - Temporarily hold values
     * - Provide step-by-step object creation
     */
    static class Builder{

        // Same fields as Student (temporary storage)
        private String name;
        private int age;
        private int rollno;
        private String course;

        /**
         * Setter method for name
         *
         * WHY return this?
         * - Enables method chaining (fluent API)
         * - Example: setName().setAge()
         */
        public Builder setName(String name){
            this.name  = name;
            return this;
        }

        public Builder setAge(int age){
            this.age = age;
            return this;
        }

        public Builder setRollno(int rollno){
            this.rollno = rollno;
            return this;
        }

        public Builder setCourse(String course){
            this.course = course;
            return this;
        }

        /**
         * Final step of Builder
         *
         * WHAT it does:
         * - Creates Student object
         * - Passes Builder (this) to constructor
         */
        public Student build(){
            return new Student(this);
        }
    }

    /**
     * toString() for easy debugging and printing
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rollno=" + rollno +
                ", course='" + course + '\'' +
                '}';
    }
}
