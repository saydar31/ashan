package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.signUp.SignUpEmployerDto;
import ru.itis.ashan.entities.signUp.SignUpStudentDto;
import ru.itis.ashan.entities.signUp.SignUpTeacherDto;
import ru.itis.ashan.entities.student.CompetenceState;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.repositories.EmployerRepository;
import ru.itis.ashan.repositories.StudentRepository;
import ru.itis.ashan.repositories.TeacherRepository;

@Component
public class SignUpServiceImpl implements SignUpService{

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    WelcomeLetterService welcomeLetterService;


    @Override
    public void signUpStudent(SignUpStudentDto form) {
        Student student = Student.builder()
                .mail(form.getMail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .name(form.getName())
                .surname(form.getSurname())
                .patronymic(form.getPatronymic())
                .course(form.getCourse())
                .groupNumber(form.getGroupNumber())
                .competenceState(CompetenceState.NOT_CONFIRMED)
                .role(Role.STUDENT)
                .state(State.NOT_CONFIRMED)
                .build();
        studentRepository.save(student);
        welcomeLetterService.sendWelcomeLetter(student);
    }

    @Override
    public void signUpTeacher(SignUpTeacherDto form) {
        Teacher teacher = Teacher.builder()
                .mail(form.getMail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .name(form.getName())
                .surname(form.getSurname())
                .patronymic(form.getPatronymic())
                .role(Role.TEACHER)
                .state(State.NOT_CONFIRMED)
                .build();

        teacherRepository.save(teacher);
        welcomeLetterService.sendWelcomeLetter(teacher);
    }

    @Override
    public void signUpEmployer(SignUpEmployerDto form) {
        Employer employer = Employer.builder()
                .mail(form.getMail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .companyName(form.getCompanyName())
                .role(Role.EMPLOYER)
                .state(State.NOT_CONFIRMED)
                .phoneNumber(form.getPhoneNumber())
                .build();

        employerRepository.save(employer);
        welcomeLetterService.sendWelcomeLetter(employer);
    }
}