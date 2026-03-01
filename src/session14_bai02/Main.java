package session14_bai02;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("T01", "Paracetamol");
        map.put("T02", "Ibuprofen");
        map.put("T03", "Amoxicillin");
        map.put("T04", "Vitamin C");
        map.put("T05", "Aspirin");

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã thuốc: ");
        String code = sc.nextLine();

        if (map.containsKey(code)) {
            System.out.println("Tên thuốc: " + map.get(code));
        } else {
            System.out.println("Thuốc không tồn tại.");
        }

        sc.close();
    }
}
