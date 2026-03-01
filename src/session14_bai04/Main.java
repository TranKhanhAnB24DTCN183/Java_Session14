package session14_bai04;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Cúm A");
        list.add("Sốt xuất huyết");
        list.add("Cúm A");
        list.add("Covid-19");
        list.add("Cúm A");
        list.add("Sốt xuất huyết");

        TreeMap<String, Integer> map = new TreeMap<>();

        for (String benh : list) {
            if (map.containsKey(benh)) {
                map.put(benh, map.get(benh) + 1);
            } else {
                map.put(benh, 1);
            }
        }

        for (String benh : map.keySet()) {
            System.out.println(benh + ": " + map.get(benh) + " ca");
        }
    }
}
