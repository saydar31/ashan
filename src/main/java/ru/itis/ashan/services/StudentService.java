package ru.itis.ashan.services;


import ru.itis.ashan.entities.edit.student.StudentEditDto;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import java.util.List;

public interface StudentService {
    StudentDto getStudentById(Long id);
    List<StudentDto> findAll();
    void updateStudentData(Student student, StudentEditDto studentEditDto);
    List<StudentDto> getUnconfirmedStudentsByTeacher(Teacher teacher);
    void editStudent(Student student, StudentDto studentDto);
}
