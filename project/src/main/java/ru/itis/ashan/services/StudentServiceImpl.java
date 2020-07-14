package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.repositories.StudentRepository;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto getStudentById(Long id) {
        Optional<Student> optionalStudent =  studentRepository.findById(id);

        if(!optionalStudent.isPresent()){
            throw new UsernameNotFoundException("User with id " + id + " doesn't exist");
        }
       return StudentDto.castToDto(optionalStudent.get());

    }

    @Override
    public List<StudentDto> findAll() {
        return StudentDto.from(studentRepository.findAll());
    }
}
