package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.exceptions.UserNotFoundException;
import ru.itis.ashan.repositories.EmployerRepository;
import ru.itis.ashan.repositories.StudentRepository;

import java.util.Optional;

@Component
public class InterviewResultServiceImpl implements InterviewResultService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private InterviewNotificationService interviewNotificationService;

    @Override
    public void accept(Long studentId, Employer employer) {
        setResults(studentId,employer,true);
    }

    @Override
    public void refuse(Long studentId, Employer employer) {
        setResults(studentId,employer,false);
    }

    private void setResults(Long id, Employer employer, boolean success) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            employer.getInvitedStudents().remove(student);
            student.getInvitingEmployers().remove(employer);
            if (success){
                employer.getStudents().add(student);
                student.setEmployer(employer);
            }
            studentRepository.save(student);
            employerRepository.save(employer);
        } else {
            throw new UserNotFoundException();
        }
    }
}
