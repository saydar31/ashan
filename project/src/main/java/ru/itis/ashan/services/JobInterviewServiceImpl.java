package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.exceptions.UserNotFoundException;
import ru.itis.ashan.repositories.EmployerRepository;
import ru.itis.ashan.repositories.StudentRepository;

import java.util.Optional;

@Component
@Transactional
public class JobInterviewServiceImpl implements JobInterviewService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private InterviewNotificationService interviewNotificationService;
    @Override
    @Transactional
    public void invite(Long studentId, Employer employer) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (studentOptional.isPresent()){
            Student student = studentOptional.get();
            interviewNotificationService.sendInterviewNotification(employer,student);
            employer.getInvitedStudents().add(student);
            student.getInvitingEmployers().add(employer);
            employerRepository.save(employer);
        }else {
            throw new UserNotFoundException();
        }
    }
}
