package session14_bai06;

public class Patient {
    String name;
    int age;
    String khoa;

    public Patient(String name, int age, String khoa) {
        this.name = name;
        this.age = age;
        this.khoa = khoa;
    }

    @Override
    public String toString() {
        return "Patient(" + name + ", " + age + " tuổi)";
    }
}
