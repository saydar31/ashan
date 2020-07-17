package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.ashan.entities.student.CompetenceState;
import ru.itis.ashan.entities.student.StudentEditForm;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.repositories.StudentRepository;
import ru.itis.ashan.repositories.TeacherRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    private Teacher getTeacher(Long teacherId) {
        if (teacherId != null) {
            Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
            if (optionalTeacher.isPresent()) {
                return optionalTeacher.get();
            } throw new UsernameNotFoundException("teacher with id: " + teacherId + " not found");
        } return null;
    }

    @Override
    public List<StudentDto> getUnconfirmedStudentsByTeacher(Teacher teacher) {
        List<Student> students = studentRepository.findAllNotConfirmedCompetenceByTeacher(teacher);
        return students.stream().map(StudentDto::castToDto).collect(Collectors.toList());
    }

    @Override
    public void editStudent(Long id, StudentEditForm studentEditForm) {
        Student student = studentRepository.getOne(id);
        student.setName(studentEditForm.getName());
        student.setSurname(studentEditForm.getSurname());
        student.setPatronymic(studentEditForm.getPatronymic());
        if (!student.getCompetence().equals(studentEditForm.getCompetence())) {
            student.setCompetence(studentEditForm.getCompetence());
            student.setCompetenceState(CompetenceState.NOT_CONFIRMED);
        }
        student.setTeacher(getTeacher(studentEditForm.getTeacherId()));
        studentRepository.save(student);
    }
}
