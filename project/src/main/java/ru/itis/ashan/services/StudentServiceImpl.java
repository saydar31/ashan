package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.repositories.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User with id " + id + " doesn't exist"));

    }

    @Override
    public List<StudentDto> findAll() {
        return StudentDto.from(studentRepository.findAll());
    }

    @Override
    public List<StudentDto> getUnconfirmedStudentsByTeacher(Teacher teacher) {
        List<Student> students = studentRepository.findAllNotConfirmedCompetenceByTeacher(teacher);
        return students.stream().map(StudentDto::castToDto).collect(Collectors.toList());
    }
}
