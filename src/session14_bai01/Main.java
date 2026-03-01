package session14_bai01;

import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
        LinkedHashSet<String> list = new LinkedHashSet<>();

        list.add("Nguyễn Văn A – Yên Bái");
        list.add("Trần Thị B – Thái Bình");
        list.add("Nguyễn Văn A – Yên Bái");
        list.add("Lê Văn C – Hưng Yên");

        System.out.println("Danh sách gọi khám:");

        for (String name : list) {
            System.out.println(name);
        }
    }
}
