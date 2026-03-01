package session14_bai06;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Patient> list = new ArrayList<>();

        list.add(new Patient("Lan", 30, "Tim mạch"));
        list.add(new Patient("Hùng", 45, "Nội tiết"));
        list.add(new Patient("Mai", 28, "Tim mạch"));

        Map<String, List<Patient>> map = new HashMap<>();

        for (Patient p : list) {
            if (!map.containsKey(p.khoa)) {
                map.put(p.khoa, new ArrayList<>());
            }
            map.get(p.khoa).add(p);
        }

        for (String khoa : map.keySet()) {
            System.out.println("Khoa " + khoa + " -> " + map.get(khoa));
        }

        String khoaDongNhat = "";
        int max = 0;

        for (String khoa : map.keySet()) {
            int size = map.get(khoa).size();
            if (size > max) {
                max = size;
                khoaDongNhat = khoa;
            }
        }

        System.out.println("Khoa " + khoaDongNhat + " đang đông nhất (" + max + " bệnh nhân)");
    }
}
