package com.example.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public @ResponseBody
    Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public @ResponseBody
    Student getStudentById(@PathVariable("id") int id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }

    @GetMapping("/students/save")
    public @ResponseBody
    String saveStudent() {
        Student student = new Student();
        student.setAge(18);
        student.setName("马东");
        student.setSex("男");
        student = studentRepository.save(student);
        System.out.println("保存数据成功：" + student);
        return "修改数据成功！";
    }

    @RequestMapping("/students/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        studentRepository.deleteById(id);
        return "删除数据成功！";
    }

//    @PostMapping("/students/{id}")
//    public @ResponseBody Student getStudentById(@PathVariable("id") Integer id) {
//        Optional<Student> student = studentRepository.findById(id);
//        return student.get();
//    }


}
