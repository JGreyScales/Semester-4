package p04_inheritance;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Alex", 30);
        Student s = new Student("Sam", 20, "S1001");

        p.introduce();
        p.study();

        s.introduce();
        s.study();
        s.enroll("course 1");
        s.enroll("course 2");
        s.enroll("course 3");
        s.enroll("course 4");
        s.enroll("course 5");
        s.enroll("course 6");
        s.enroll("course 7");


        Person[] People = new Person[2];
        People[0] = p;
        People[1] = s;

        for (int i = 0; i < 6; i++) {
            People[i % 2].study();
        }
    }
}

