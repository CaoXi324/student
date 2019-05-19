package com.example.student.controller;

import com.example.student.dao.StudentRepository;
import com.example.student.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students/{id}/")
    public Student getStudentById(@PathVariable("id") Integer id) {
        Student student = studentRepository.findById(id).get();
        return student;
    }

    @GetMapping("/students/")
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    @PostMapping("/students/")

    public String saveStudent(
            @RequestParam String name,
            @RequestParam String sex,
            @RequestParam Integer age) {
        Student student = new Student();
        student.setAge(age);
        student.setName(name);
        student.setSex(sex);
        studentRepository.save(student);

        return "保存数据成功！";
    }

    @DeleteMapping("/students/{id}/")
    public String delete(@PathVariable("id") Integer id) {
        studentRepository.deleteById(id);
        return "删除数据成功！";
    }

    @PutMapping("students/{id}/")
    public String update(
            @PathVariable("id") Integer id,
            @RequestParam String name,
            @RequestParam String sex,
            @RequestParam Integer age) {
        Student student = new Student();
        student.setSex(sex);
        student.setName(name);
        student.setAge(age);
        studentRepository.save(student);
        return "修改数据成功";
    }

}
