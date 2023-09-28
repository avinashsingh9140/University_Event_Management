package UniversityEvent.service;

import UniversityEvent.controller.StudentController;
import UniversityEvent.model.Department;
import UniversityEvent.model.StudentModel;
import UniversityEvent.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;


    public String addStudent(List<StudentModel> id) {
        studentRepo.saveAll(id);
        return "student added";
    }

    public String  updateStudent(Integer id, Department department) {
        StudentModel student=studentRepo.findById(id).get();
        student.setDepartment(department);
        studentRepo.save(student);
        return "studentId Updated";
    }

    public String deleteStudent(Integer id) {
        studentRepo.deleteById(id);
        return "student deleted";
    }

    public List<StudentModel> getAllStudent() {
        return (List<StudentModel>) studentRepo.findAll();
    }

    public StudentModel getStudentById(Integer id) {
        return studentRepo.findById(id).get();
    }
}
