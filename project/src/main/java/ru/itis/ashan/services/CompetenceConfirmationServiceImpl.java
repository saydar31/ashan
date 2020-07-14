package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.ashan.entities.student.CompetenceState;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.exceptions.StudentNotMatchingException;
import ru.itis.ashan.exceptions.UserNotFoundedException;
import ru.itis.ashan.repositories.StudentRepository;

import java.util.Optional;

@Component
public class CompetenceConfirmationServiceImpl implements CompetenceConfirmationService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public void confirm(Long id, Teacher teacher) {
        this.setStateToStudent(id, teacher, CompetenceState.CONFIRMED);
    }

    @Override
    @Transactional
    public void refuse(Long id, Teacher teacher) {
        setStateToStudent(id, teacher, CompetenceState.DENIED);
    }

    private void setStateToStudent(Long id, Teacher teacher, CompetenceState competenceState) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            if (student.getTeacher().getId().equals(teacher.getId())) {
                student.setCompetenceState(competenceState);
            } else {
                throw new StudentNotMatchingException();
            }
        } else {
            throw new UserNotFoundedException();
        }
    }
}
