package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.employer.EmployerDto;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.entities.user.UserDto;
import ru.itis.ashan.entities.user.UserModel;
import ru.itis.ashan.repositories.EmployerRepository;
import ru.itis.ashan.repositories.StudentRepository;
import ru.itis.ashan.repositories.TeacherRepository;
import ru.itis.ashan.repositories.UserRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class AdminServiceImpl implements AdminService{

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<EmployerDto> getAllNotConfirmedEmployers() {
        List<Employer> notConfirmedEmployers = employerRepository.findAllNotConfirmed();
        List<EmployerDto> notConfirmedDtoList = new LinkedList<>();

        for (Employer employer : notConfirmedEmployers){
            notConfirmedDtoList.add(EmployerDto.castToDto(employer));
        }
        return notConfirmedDtoList;
    }

    @Override
    public List<StudentDto> getAllNotConfirmedStudents() {
        List<Student> notConfirmedStudents = studentRepository.findAllNotConfirmed();
        List<StudentDto> notConfirmedDtoList = new LinkedList<>();

        for (Student student : notConfirmedStudents){
            notConfirmedDtoList.add(StudentDto.castToDto(student));
        }
        return notConfirmedDtoList;
    }

    @Override
    public List<TeacherDto> getAllNotConfirmedTeachers() {
        List<Teacher> notConfirmedTeacher = teacherRepository.findAllNotConfirmed();
        List<TeacherDto> notConfirmedDtoList = new LinkedList<>();

        for (Teacher teacher : notConfirmedTeacher){
            notConfirmedDtoList.add(TeacherDto.castToDto(teacher));
        }
        return notConfirmedDtoList;
    }

    @Override
    public boolean confirmUser(UserDto userDto) {
        UserModel userModel = UserModel.castToModel(userDto);
        Optional<UserModel> optionalUserModel = userRepository.findById(userDto.getId());

        if(optionalUserModel.isPresent()){
            if(optionalUserModel.get().getState().equals(State.NOT_CONFIRMED)) {
                userRepository.confirmUser(userModel.getId());
                userDto.setState(State.CONFIRMED);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean refuseUser(UserDto userDto) {
        UserModel userModel = UserModel.castToModel(userDto);
        Optional<UserModel> optionalUserModel = userRepository.findById(userDto.getId());

        if(optionalUserModel.isPresent()){
            if(optionalUserModel.get().getState().equals(State.NOT_CONFIRMED)) {
                userRepository.refuseUser(userModel.getId());
                userDto.setState(State.REFUSED);
                return true;
            }
        }
        return false;
    }
}
