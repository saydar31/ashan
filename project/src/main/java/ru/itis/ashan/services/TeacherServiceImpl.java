package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.repositories.StudentRepository;
import ru.itis.ashan.exceptions.UserNotFoundException;
import ru.itis.ashan.repositories.TeacherRepository;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public TeacherDto getTeacherById(Long id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isPresent()){
            return TeacherDto.castToDto(teacherOptional.get());
        } else {
           throw new UserNotFoundException();
        }
    }

    @Override
    public List<TeacherDto> findConfirmedTeachers() {
        List<Teacher> confirmedTeachers = teacherRepository.findAllConfirmed();
        List<TeacherDto> dtoList = new LinkedList<>();
        for (Teacher teacher : confirmedTeachers) {
            dtoList.add(TeacherDto.castToDto(teacher));
        }
        return dtoList;
    }


    public List<TeacherDto> findAll() {
        return TeacherDto.from(teacherRepository.findAll());
    }

    @Override
    public TeacherDto getTeacherOfStudent(StudentDto student) {
        return getTeacherById(student.getTeacherDto().getId());
    }
}
