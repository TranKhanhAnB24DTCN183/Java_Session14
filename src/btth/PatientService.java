package btth;
import java.util.*;

public class PatientService implements Manageable<Patient> {
    private Set<Patient> patients = new HashSet<>();
    private Scanner sc = new Scanner(System.in);

    public Set<Patient> getPatients() {
        return patients;
    }

    @Override
    public void add(Patient p) {
        for (Patient patient : patients) {
            if (patient.getId().equalsIgnoreCase(p.getId())) {
                System.out.println("ID đã tồn tại!");
                return;
            }
        }
        patients.add(p);
        System.out.println("Thêm thành công.");
    }

    @Override
    public void update(String id) {
        List<Patient> list = new ArrayList<>(patients);
        for (Patient p : list) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.print("Tên mới: ");
                p.setName(sc.nextLine());
                System.out.print("Tuổi mới: ");
                p.setAge(Integer.parseInt(sc.nextLine()));
                System.out.print("SĐT mới: ");
                p.setPhone(sc.nextLine());
                System.out.println("Cập nhật thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân.");
    }

    @Override
    public void delete(String id) {
        Iterator<Patient> it = patients.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equalsIgnoreCase(id)) {
                it.remove();
                System.out.println("Xóa thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân.");
    }

    @Override
    public void displayAll() {
        if (patients.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (Patient p : patients) {
            p.displayInfo();
        }
    }

    public Patient findById(String id) {
        for (Patient p : patients) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }
}
