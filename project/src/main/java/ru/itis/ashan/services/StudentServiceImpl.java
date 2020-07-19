package ru.itis.ashan.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.ashan.entities.fileInfo.FileInfo;
import ru.itis.ashan.entities.student.CompetenceState;
import ru.itis.ashan.entities.student.StudentEditForm;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.tag.Tag;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.repositories.StudentRepository;
import ru.itis.ashan.repositories.TagRepository;
import ru.itis.ashan.repositories.TeacherRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TagRepository tagRepository;

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
    public List<StudentDto> getConfirmedStudentsByTeacher(TeacherDto teacher) {
        List<Student> students = studentRepository.findAllConfirmedCompetenceByTeacher(Teacher.castToModel(teacher));
        return students.stream().map(StudentDto::castToDto).collect(Collectors.toList());
    }

    @Override
    public void editStudent(Long id, StudentEditForm studentEditForm, FileInfo fileInfo) {
        Student student = studentRepository.getOne(id);
        student.setName(studentEditForm.getName());
        student.setSurname(studentEditForm.getSurname());
        student.setPatronymic(studentEditForm.getPatronymic());
        if(student.getCompetence() != null) {
            if (!student.getCompetence().equals(studentEditForm.getCompetence())) {
                student.setCompetence(studentEditForm.getCompetence());
                student.setCompetenceState(CompetenceState.NOT_CONFIRMED);
            }
        }else {
            student.setCompetence(studentEditForm.getCompetence());
            student.setCompetenceState(CompetenceState.NOT_CONFIRMED);
        }
        student.setTeacher(getTeacher(studentEditForm.getTeacherId()));
        student.setTagSet(createTagSet(studentEditForm));

        if(fileInfo != null){
            student.setMainPhoto(fileInfo);
        }

        studentRepository.save(student);
    }

    private Set<Tag> createTagSet(StudentEditForm studentEditForm){
        Map<Long, Tag> tagMap = new HashMap<>();

        if (studentEditForm.getTag1Id() != null){
            Optional<Tag> optionalTag = tagRepository.findById(studentEditForm.getTag1Id());
            if(optionalTag.isPresent()){
                Tag tag = optionalTag.get();
                tagMap.put(tag.getId(), tag);
            }
        }

        if (studentEditForm.getTag2Id() != null){
            Optional<Tag> optionalTag = tagRepository.findById(studentEditForm.getTag2Id());
            if(optionalTag.isPresent()){
                Tag tag = optionalTag.get();
                tagMap.put(tag.getId(), tag);
            }
        }

        if (studentEditForm.getTag3Id() != null){
            Optional<Tag> optionalTag = tagRepository.findById(studentEditForm.getTag3Id());
            if(optionalTag.isPresent()){
                Tag tag = optionalTag.get();
                tagMap.put(tag.getId(), tag);
            }
        }

        if (studentEditForm.getTag4Id() != null){
            Optional<Tag> optionalTag = tagRepository.findById(studentEditForm.getTag4Id());
            if(optionalTag.isPresent()){
                Tag tag = optionalTag.get();
                tagMap.put(tag.getId(), tag);
            }
        }

        if (studentEditForm.getTag5Id() != null){
            Optional<Tag> optionalTag = tagRepository.findById(studentEditForm.getTag5Id());
            if(optionalTag.isPresent()){
                Tag tag = optionalTag.get();
                tagMap.put(tag.getId(), tag);
            }
        }

        return new HashSet<>(tagMap.values());
    }
}
