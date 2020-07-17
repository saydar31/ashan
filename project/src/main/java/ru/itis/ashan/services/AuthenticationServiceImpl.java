package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.ashan.entities.admin.Admin;
import ru.itis.ashan.entities.admin.AdminDto;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.employer.EmployerDto;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.entities.user.UserModel;
import ru.itis.ashan.repositories.UserRepository;
import ru.itis.ashan.security.details.UserDetailsImpl;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public StudentDto getStudent(Authentication authentication) {
        Student student = (Student) getUserModel(authentication);
        return StudentDto.castToDto(student);
    }

    @Override
    public AdminDto getAdmin(Authentication authentication) {
        Admin admin = (Admin) getUserModel(authentication);
        return AdminDto.castToDto(admin);
    }

    @Override
    public EmployerDto getEmployer(Authentication authentication) {
        Employer employer = (Employer) getUserModel(authentication);
        return EmployerDto.castToDto(employer);
    }

    @Override
    public UserModel getUserModel(Authentication authentication) {
        UserDetailsImpl userDetail = (UserDetailsImpl) authentication.getPrincipal();
        Long id = userDetail.getUser().getId();
        Optional<UserModel> userModelOptional = userRepository.findById(id);
        if (userModelOptional.isPresent()) {
            return userModelOptional.get();
        } else throw new UsernameNotFoundException("User with id: " + id + " not found");
    }

    @Override
    public TeacherDto getTeacher(Authentication authentication) {
        Teacher teacher = (Teacher) getUserModel(authentication);
        return  TeacherDto.castToDto(teacher);
    }
}

