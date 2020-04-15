package com.volkodav4ik.models;


import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@Proxy(lazy = false)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int age;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_group",
            joinColumns = @JoinColumn(name = "studentsGroup_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<Group> groups = new HashSet<Group>();

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(int id, String name, int age, Set<Group> groups) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.groups = groups;
    }

    public Set<Group> getGroups() {
        return this.groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
        group.getStudents().add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", groups=" + groups +
                '}';
    }
}
