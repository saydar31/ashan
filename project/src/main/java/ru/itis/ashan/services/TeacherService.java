package ru.itis.ashan.services;

import ru.itis.ashan.entities.fileInfo.FileInfo;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.student.StudentEditForm;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.entities.teacher.TeacherEditForm;

import java.util.List;

public interface TeacherService {

    List<TeacherDto> findConfirmedTeachers();
    TeacherDto getTeacherById(Long id);
    List<TeacherDto> findAll();
    TeacherDto getTeacherOfStudent(StudentDto student);
    void editTeacher(Long id, TeacherEditForm teacherEditForm, FileInfo fileInfo);
}

