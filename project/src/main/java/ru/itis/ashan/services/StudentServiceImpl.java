package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.repositories.StudentRepository;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    @Override
    public void editStudent(Student student, StudentDto studentDto) {
        student.setName(studentDto.getName());
        student.setSurname(studentDto.getSurname());
        student.setPatronymic(studentDto.getPatronymic());
        student.setCourse(studentDto.getCourse());
        student.setGroupNumber(studentDto.getGroupNumber());
        student.setTeacher(Teacher.castToModel(studentDto.getTeacherDto()));
        studentRepository.save(student);
    }
}
