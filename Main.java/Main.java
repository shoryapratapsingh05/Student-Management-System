import java.util.*;
class Student {
    int id;
    String name;
    int age;
    Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
public class Main {
    static ArrayList<Student> students = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    deleteStudent(sc);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    public static void addStudent(Scanner sc) {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();
        students.add(new Student(id, name, age));
        System.out.println("✅ Student Added Successfully!");
    }
    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println("ID: " + s.id + ", Name: " + s.name + ", Age: " + s.age);
        }
    }
    public static void deleteStudent(Scanner sc) {
        System.out.print("Enter Student ID to delete: ");
        int delId = sc.nextInt();
        boolean removed = students.removeIf(s -> s.id == delId);
        if (removed) {
            System.out.println("🗑 Student Deleted Successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}