package btth;
import java.util.*;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static PatientService patientService = new PatientService();
    private static Map<String, List<MedicalRecord>> recordMap = new HashMap<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n========= QUẢN LÝ PHÒNG KHÁM =========");
            System.out.println("1. Thêm bệnh nhân");
            System.out.println("2. Cập nhật bệnh nhân");
            System.out.println("3. Xóa bệnh nhân");
            System.out.println("4. Hiển thị danh sách bệnh nhân");
            System.out.println("------------------------------------");
            System.out.println("5. Thêm hồ sơ khám bệnh");
            System.out.println("6. Xem hồ sơ theo bệnh nhân");
            System.out.println("7. Xóa hồ sơ khám");
            System.out.println("------------------------------------");
            System.out.println("8. Tìm bệnh nhân");
            System.out.println("9. Sắp xếp bệnh nhân");
            System.out.println("------------------------------------");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("SĐT: ");
                    String phone = sc.nextLine();
                    patientService.add(new Patient(id, name, age, phone));
                    break;

                case 2:
                    System.out.print("Nhập ID cần cập nhật: ");
                    patientService.update(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Nhập ID cần xóa: ");
                    patientService.delete(sc.nextLine());
                    break;

                case 4:
                    patientService.displayAll();
                    break;

                case 5:
                    System.out.print("Nhập ID bệnh nhân: ");
                    String pid = sc.nextLine();
                    if (patientService.findById(pid) == null) {
                        System.out.println("Bệnh nhân không tồn tại.");
                        break;
                    }
                    System.out.print("Mã hồ sơ: ");
                    String rid = sc.nextLine();
                    System.out.print("Chẩn đoán: ");
                    String diag = sc.nextLine();
                    System.out.print("Ngày khám: ");
                    String date = sc.nextLine();

                    recordMap.putIfAbsent(pid, new ArrayList<>());
                    recordMap.get(pid).add(new MedicalRecord(rid, diag, date));
                    System.out.println("Thêm hồ sơ thành công.");
                    break;

                case 6:
                    System.out.print("Nhập ID bệnh nhân: ");
                    String viewId = sc.nextLine();
                    List<MedicalRecord> records = recordMap.get(viewId);
                    if (records == null) {
                        System.out.println("Không có hồ sơ.");
                    } else {
                        for (MedicalRecord r : records) {
                            System.out.println(r);
                        }
                    }
                    break;

                case 7:
                    System.out.print("Nhập ID bệnh nhân: ");
                    String delId = sc.nextLine();
                    List<MedicalRecord> list = recordMap.get(delId);
                    if (list == null) {
                        System.out.println("Không có hồ sơ.");
                        break;
                    }
                    System.out.print("Nhập mã hồ sơ cần xóa: ");
                    String delRid = sc.nextLine();
                    list.removeIf(r -> r.getRecordId().equalsIgnoreCase(delRid));
                    System.out.println("Đã xóa.");
                    break;

                case 8:
                    System.out.print("Nhập tên cần tìm: ");
                    String keyword = sc.nextLine();
                    for (Patient p : patientService.getPatients()) {
                        if (p.getName().toLowerCase().contains(keyword.toLowerCase())) {
                            p.displayInfo();
                        }
                    }
                    break;

                case 9:
                    List<Patient> sorted = new ArrayList<>(patientService.getPatients());
                    System.out.println("1. Theo tên");
                    System.out.println("2. Theo tuổi");
                    System.out.println("3. Theo ID");
                    int sortChoice = Integer.parseInt(sc.nextLine());

                    if (sortChoice == 1) {
                        Collections.sort(sorted);
                    } else if (sortChoice == 2) {
                        sorted.sort((a, b) -> Integer.compare(a.getAge(), b.getAge()));
                    } else if (sortChoice == 3) {
                        sorted.sort((a, b) -> a.getId().compareToIgnoreCase(b.getId()));
                    }

                    for (Patient p : sorted) {
                        p.displayInfo();
                    }
                    break;

            }

        } while (choice != 0);
    }
}
