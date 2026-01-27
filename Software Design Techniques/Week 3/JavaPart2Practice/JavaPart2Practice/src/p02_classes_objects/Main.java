package p02_classes_objects;

import support.config.Config;

public class Main {
    public static void main(String[] args) {
        String name = Config.getString("student.name", "Student One");
        int age = Config.getInt("demo.age", 18);

        Person p = new Person(name, age);
        System.out.println("Created person: " + p.getName() + ", age=" + p.getAge());
        p.study();

        p.setAge(p.getAge() + 1);
        System.out.println("After birthday: age=" + p.getAge());

        p.setAge(-30);
        System.out.println("After negative age: age=" + p.getAge());
    }
}

