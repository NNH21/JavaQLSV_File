package javacore.file.practice2.JavaQLSV_File;

public class Student {
    private int id, age;
    private String name, address;
    private double gpa;

    public Student() {
    }

    public Student(int id, int age, String name, double gpa, String address) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.gpa = gpa;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student: "+id+" | "+name+" | "+age+" | "+address+" | "+gpa;
    }
    public String toFile() {
        return id+" | "+name+" | "+age+" | "+address+" | "+gpa + "\n";
    }
    public void parse(String line){
        try{
            String[] data = line.split(" \\| ");
            id = Integer.parseInt(data[0]);
            name = data[1];
            age = Integer.parseInt(data[2]);
            address = data[3];
            gpa = Double.parseDouble(data[4]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Loi dinh dang file" + e.getMessage());
        }
    }
}
