package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.ashan.entities.student.CompetenceState;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.repositories.StudentRepository;

import java.util.LinkedList;
import java.util.List;

@Component
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentDto> findAllNotConfirmedСompetenceByTeacher(TeacherDto teacherDto) {
        Teacher teacher = Teacher.castToModel(teacherDto);
        List<Student> studentList = studentRepository.findAllNotConfirmedCompetenceByTeacher(teacher);
        List<StudentDto> studentDtoList = new LinkedList<>();

        for (Student student : studentList) {
            studentDtoList.add(StudentDto.castToDto(student));
        }
        return studentDtoList;
    }

    @Override
    public List<StudentDto> findAllConfirmedСompetenceByTeacher(TeacherDto teacherDto) {
        Teacher teacher = Teacher.castToModel(teacherDto);
        List<Student> studentList = studentRepository.findAllConfirmedCompetenceByTeacher(teacher);
        List<StudentDto> studentDtoList = new LinkedList<>();

        for (Student student : studentList) {
            studentDtoList.add(StudentDto.castToDto(student));
        }
        return studentDtoList;
    }

    @Override
    public boolean confirmCompetence(StudentDto studentDto, TeacherDto teacherDto) {
        Teacher teacher = Teacher.castToModel(teacherDto);
        if (studentRepository.existStudentByIdAndTeacher(studentDto.getId(), teacher).equals(1L)
                && studentDto.getCompetenceState().equals(CompetenceState.NOT_CONFIRMED)) {

            studentRepository.confirmCompetence(studentDto.getId());
            studentDto.setCompetenceState(CompetenceState.CONFIRMED);
            return true;
        }
        return false;
    }
}
