package javacore.file.practice2.JavaQLSV_File;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentList {
    private ArrayList<Student> students;
    Scanner sc = new Scanner(System.in);

    public StudentList(ArrayList<Student> students) {
        this.students = students;
    }

    public StudentList() {
        this.students = new ArrayList<>();
    }

    public void addSinhVien() {
        System.out.println("Nhap so luong sinh vien: ");
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap ID sinh vien thu " + (i + 1) + ": ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println("Nhap ten sinh vien: ");
            String name = sc.nextLine();
            System.out.println("Nhap tuoi sinh vien: ");
            int age = Integer.parseInt(sc.nextLine());
            System.out.println("Nhap dia chi sinh vien: ");
            String address = sc.nextLine();
            System.out.println("Nhap diem trung binh sinh vien: ");
            double gpa = Double.parseDouble(sc.nextLine());
            Student student = new Student(id, age, name, gpa, address);
            students.add(student);
        }
    }

    public void editById() {
        System.out.println("Nhap ID can sua thong tin: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean found = false;
        for (Student std : students) {
            if (std.getId() == id) {
                found = true;
                System.out.println("Nhap ten sinh vien: ");
                std.setName(sc.nextLine());
                System.out.println("Nhap tuoi sinh vien: ");
                std.setAge(Integer.parseInt(sc.nextLine()));
                System.out.println("Nhap dia chi sinh vien: ");
                std.setAddress(sc.nextLine());
                System.out.println("Nhap diem trung binh sinh vien: ");
                std.setGpa(Double.parseDouble(sc.nextLine()));
                return;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay sinh vien co ID = " + id);
        }
    }

    public void DeleteById() {
        System.out.println("Nhap ID can xoa: ");
        int id = Integer.parseInt(sc.nextLine());
        if (students.removeIf(std -> std.getId() == id)) {
            System.out.println("Xoa thanh cong.");
        } else {
            System.out.println("Khong tim thay sinh vien co ID = " + id + " de xoa.");
        }
    }

    public void SortByGpa() {
        Collections.sort(students, (std1, std2) -> -Double.compare(std1.getGpa(), std2.getGpa()));
        System.out.println("Danh sach sinh vien sau khi sap xep theo GPA: ");
        for (Student std : students) {
            System.out.println(std);
        }
    }

    public void SortByName() {
        Collections.sort(students, (std1, std2) -> std1.getName().compareToIgnoreCase(std2.getName()));
        System.out.println("Danh sach sinh vien sau khi sap xep theo ten: ");
        for (Student std : students) {
            System.out.println(std);
        }
    }

    public void showStudent() {
        for (Student std : students) {
            System.out.println(std);
        }
    }

    public void SaveFile() {
        boolean check = false;
        try {
            FileOutputStream fos = new FileOutputStream("src/javacore/file/practice2/Student.txt", true);
            for (Student std : students) {
                String line = std.toFile();
                fos.write(line.getBytes());
            }
            fos.close();
            check = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (check) {
            System.out.println("Luu file thanh cong.");
        } else {
            System.out.println("Luu file that bai.");
        }
    }

    public void ReadFile() {
        try {
            FileInputStream fis = new FileInputStream("src/javacore/file/practice2/Student.txt");
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                if(line.isEmpty()){
                    continue;
                }
                Student std = new Student();
                std.parse(line);
                students.add(std);
            }
            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Doc file thanh cong.");
        System.out.println("Danh sach sinh vien sau khi doc tu file: ");
        for (Student std : students) {
            System.out.println(std);
        }
    }
}
