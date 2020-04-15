package com.volkodav4ik.dao;

import com.volkodav4ik.models.Group;
import com.volkodav4ik.models.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentDao {

    private SessionFactory sessionFactory;

    public StudentDao() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void addStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }
    }

    public List<Student> getStudentByGroup(String groupName) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT students from Group where lower(group_name)= lower (:groupName)")
                    .setParameter("groupName", groupName)
                    .list();
        }
    }

    public List<Group> getGroupByStudent(String studentName) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT groups from Student where lower (name) = lower (:studentName)")
                    .setParameter("studentName", studentName)
                    .list();
        }
    }

    public Student getStudent(String name) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.createQuery("From Student WHERE name = :name ", Student.class)
                    .setParameter("name", name)
                    .getSingleResult();
            transaction.commit();
            return student;
        }
    }

    public void close() {
        sessionFactory.close();
    }
}
