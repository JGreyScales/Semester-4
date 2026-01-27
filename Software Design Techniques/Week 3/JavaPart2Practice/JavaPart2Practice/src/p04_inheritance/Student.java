package p04_inheritance;

import java.util.Arrays;

public class Student extends Person {
    private final String studentId;
    public String[] courses;
    private final int maxCourseLoad = 6;
    private int currentCourseLoad = 0;

    public Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
        this.courses = new String[maxCourseLoad];
    }

    public String getStudentId() { return studentId; }

    @Override
    public void study() {
        System.out.println(name + " is studying (Student override), id=" + studentId + "Current courseload=" + this.currentCourseLoad);
    }

    public void enroll(String courseCode){
        if (this.currentCourseLoad == this.maxCourseLoad){
            System.out.println("Student is in too many courses");
            return;
        }

        this.courses[this.currentCourseLoad++] = courseCode;
        System.out.println("Current courses: " + Arrays.toString(this.courses));
    }
}
