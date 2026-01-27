package p04_inheritance;

public class Student extends Person {
    private final String studentId;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    public String getStudentId() { return studentId; }

    @Override
    public void study() {
        System.out.println(name + " is studying (Student override), id=" + studentId);
    }

    // TODO: EXERCISE 1
    // Add a method enroll(String courseCode) that prints a message.
}
