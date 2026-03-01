package session14_bai05;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Patient> set = new TreeSet<>();

        set.add(new Patient("Bệnh nhân A", 3, 800));
        set.add(new Patient("Bệnh nhân B", 1, 815));
        set.add(new Patient("Bệnh nhân C", 1, 805));

        System.out.println("Thứ tự xử lý:");

        for (Patient p : set) {
            System.out.println(p);
        }
    }
}
