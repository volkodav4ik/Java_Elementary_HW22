package com.volkodav4ik;

import com.volkodav4ik.models.Student;

public class Main {
    public static void main(String[] args) {
        fillData();
        show();
    }

    private static void fillData() {
        DataServise dataServise = new DataServise();
        dataServise.addGroup(1, "Java");
        dataServise.addGroup(2, "JavaScript");
        dataServise.addGroup(3, "Pyton");

        Student student1 = new Student("Artem", 30);
        student1.addGroup(dataServise.getGroup(1));
        student1.addGroup(dataServise.getGroup(3));
        dataServise.addStudent(student1);

        Student student2 = new Student("Kolya", 40);
        student2.addGroup(dataServise.getGroup(2));
        student2.addGroup(dataServise.getGroup(3));
        dataServise.addStudent(student2);

        Student student3 = new Student("Sasha", 20);
        student3.addGroup(dataServise.getGroup(1));
        dataServise.addStudent(student3);

        Student student4 = new Student("Katya", 50);
        student4.addGroup(dataServise.getGroup(2));
        dataServise.addStudent(student4);

        Student student5 = new Student("Gosha", 60);
        student5.addGroup(dataServise.getGroup(1));
        dataServise.addStudent(student5);

        dataServise.close();
    }

    private static void show() {
        DataServise dataServise = new DataServise();
        System.out.println("All students in " + dataServise.getGroup(1).getName() + ":\n"
                + dataServise.getStudentsByGroup(dataServise.getGroup(1).getName()).toString());
        System.out.println("All groups of student " + dataServise.getStudent("Artem").getName() + ":\n"
                + dataServise.getGroupByStudent("Artem").toString());
        dataServise.close();
    }
}
