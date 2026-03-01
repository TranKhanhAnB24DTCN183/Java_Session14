package session14_bai05;

public class Patient implements Comparable<Patient> {
    String name;
    int level;
    int time;

    public Patient(String name, int level, int time) {
        this.name = name;
        this.level = level;
        this.time = time;
    }

    @Override
    public int compareTo(Patient other) {
        if (this.level != other.level) {
            return this.level - other.level;
        }

        if (this.time != other.time) {
            return this.time - other.time;
        }

        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        String lv;
        switch (level) {
            case 1:
                lv = "Nguy kịch";
                break;
            case 2:
                lv = "Nặng";
                break;
            case 3:
                lv = "Nhẹ";
                break;
            default:
                lv = "Không rõ";
        }
        return name + " (Mức " + level + " - " + lv + ", đến lúc " + time + ")";
    }
}
