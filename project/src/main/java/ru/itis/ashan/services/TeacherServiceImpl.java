package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.exceptions.UserNotFoundException;
import ru.itis.ashan.repositories.TeacherRepository;

import java.util.Optional;

@Component
public class TeacherServiceImpl implements TeacherService {
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
}
