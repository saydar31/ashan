package ru.itis.ashan.services;

import ru.itis.ashan.entities.fileInfo.FileInfo;
import ru.itis.ashan.entities.student.StudentEditForm;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.teacher.TeacherDto;

import java.util.List;

public interface StudentService {
    StudentDto getStudentById(Long id);
    List<StudentDto> findAll();
    List<StudentDto> getUnconfirmedStudentsByTeacher(Teacher teacher);
    List<StudentDto> getConfirmedStudentsByTeacher(TeacherDto teacher);
    void editStudent(Long id, StudentEditForm studentDto, FileInfo fileInfo);
}
