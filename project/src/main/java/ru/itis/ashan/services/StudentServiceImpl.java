package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.ashan.entities.edit.student.StudentEditDto;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.repositories.StudentRepository;
import ru.itis.ashan.repositories.TeacherRepository;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public StudentDto getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (!optionalStudent.isPresent()) {
            throw new UsernameNotFoundException("User with id " + id + " doesn't exist");
        }
        return StudentDto.castToDto(optionalStudent.get());

    }

    @Override
    public List<StudentDto> findAll() {
        return StudentDto.from(studentRepository.findAll());
    }

    @Override
    public void updateStudentData(Student student, StudentEditDto studentEditDto) {
        Optional<Teacher> optionalTeacher = teacherIsExist(studentEditDto.getTeacherId());
        optionalTeacher.ifPresent(student::setTeacher);
    }

    private Optional<Teacher> teacherIsExist(Long teacherId) {
        if (teacherId == null) {
            return Optional.empty();
        }

        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
        if (!optionalTeacher.isPresent()) {
            throw new UsernameNotFoundException("teacher with id: " + teacherId + " not found");
        }
        return optionalTeacher;
    }


}
