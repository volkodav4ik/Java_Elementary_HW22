package com.volkodav4ik;

import com.volkodav4ik.dao.GroupDao;
import com.volkodav4ik.dao.StudentDao;
import com.volkodav4ik.models.Group;
import com.volkodav4ik.models.Student;

import java.util.ArrayList;
import java.util.List;

public class DataServise {

    private StudentDao studentDao = new StudentDao();
    private GroupDao groupDao = new GroupDao();

    public DataServise() {
    }

    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    public void addGroup(int id, String name) {
        groupDao.addGroup(new Group(id, name));
    }

    public Group getGroup(int id){
        return groupDao.getGroup(id);
    }

    public Student getStudent(String name){
        return studentDao.getStudent(name);
    }
    public List<String> getStudentsByGroup(String groupName){
        List <Student> students = studentDao.getStudentByGroup(groupName);
        List <String> result = new ArrayList<>();
        for (Student student :students) {
            result.add(student.getName());
        }
        return result;
    }

    public List<String> getGroupByStudent (String studentName) {
        List<Group> groups = studentDao.getGroupByStudent(studentName);
        List <String> result = new ArrayList<>();
        for (Group group : groups) {
            result.add(group.getName());
        }
        return result;
    }

    public void close(){
        studentDao.close();
        groupDao.close();
    }

}

