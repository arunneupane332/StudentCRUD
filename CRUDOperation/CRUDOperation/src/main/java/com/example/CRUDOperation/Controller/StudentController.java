package com.example.CRUDOperation.Controller;

import com.example.CRUDOperation.Model.Student;
import com.example.CRUDOperation.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1") //v1 version 1 releasing all Api
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

//get all the student
    @GetMapping("/students")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    //create student for the rest APi
    @PostMapping("/students")
    public Student postStudent(@RequestBody Student student) throws IOException {
        return this.studentRepository.save(student);
    }


    //get id by rest Api
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getEmployeeById(@PathVariable Long id) {
        Student student = this.studentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Id doesn't exist."));
        return ResponseEntity.ok(student);
    }


    @PutMapping("students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails){
        Student student=this.studentRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Id doesn't exist."));
        student.setFname(studentDetails.getFname());
        student.setLname(studentDetails.getLname());
        student.setEmail(studentDetails.getEmail());
        student.setAddress(studentDetails.getAddress());
        student.setPhone(studentDetails.getPhone());
        student.setRollNo(studentDetails.getRollNo());
        student.setStudies(studentDetails.getStudies());

        Student updatedStudent=this.studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }
    @DeleteMapping("/students/{id}")
    public Map<String,Boolean> deleteStudent(@PathVariable Long id){
        Student student=this.studentRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Id doesn't exist."));
        studentRepository.delete(student);
//after deleting the data it response either it is deleted or not
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return response;
    }
}


