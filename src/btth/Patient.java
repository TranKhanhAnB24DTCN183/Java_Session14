package btth;

public class Patient extends Person implements Comparable<Patient> {
    private String phone;

    public Patient(String id, String name, int age, String phone) {
        super(id, name, age);
        this.phone = phone;
    }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPhone() { return phone; }

    @Override
    public int compareTo(Patient o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public void displayInfo() {
        System.out.println(id + " - " + name + " - " + age + " - " + phone);
    }
}
