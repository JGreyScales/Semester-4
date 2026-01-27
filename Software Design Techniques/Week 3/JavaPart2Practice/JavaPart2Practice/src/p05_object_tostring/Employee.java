package p05_object_tostring;

public class Employee {
    private final String name;
    private final int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + "}";
    }

    @Override 
    public int hashCode(){
        int nameSum = this.name.chars().sum();
        return nameSum + this.age;
    }

    @Override
    public boolean equals(Object o){
        if (o == null) {return false;}
        if (o.getClass() != getClass()){
            return false;
        }
        int ownHash = this.hashCode();
        int otherHash = o.hashCode();
        System.out.println("Own: " + ownHash + ", Other:" + otherHash);
        return (otherHash == ownHash);
    }
}
