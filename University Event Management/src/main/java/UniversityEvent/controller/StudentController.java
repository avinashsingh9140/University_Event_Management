package UniversityEvent.controller;

import UniversityEvent.model.Department;
import UniversityEvent.model.StudentModel;
import UniversityEvent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    //add student
    @PostMapping("addStudent")
    public String addStudent( @RequestBody List<StudentModel> id){
    return studentService.addStudent(id);
}

    //update student
    @PutMapping("addStudent/{id}/{department}")
public String   updateStudent(@PathVariable Integer id, @PathVariable Department department){
          return studentService.updateStudent(id,department);
    }
    //delete student
    @DeleteMapping("deletestudent/{id}")
public String  deleteStudent(@PathVariable Integer id){
         return studentService.deleteStudent(id);
    }
    //get allStudent
    @GetMapping("getAllStudent")
    public List<StudentModel> getAllStudent(){
        return studentService.getAllStudent();
    }
    //get student by id
    @GetMapping("getAllStudent/{id}")
    public StudentModel getStudentById(@PathVariable Integer id){
        return  studentService.getStudentById(id);
    }

}
