package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.ashan.entities.fileInfo.FileInfo;
import ru.itis.ashan.entities.teacher.Teacher;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.entities.teacher.TeacherEditForm;
import ru.itis.ashan.services.AuthenticationService;
import ru.itis.ashan.services.FileService;
import ru.itis.ashan.services.StudentService;
import ru.itis.ashan.services.TeacherService;

@Controller
public class TeacherPersonalPageController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private FileService fileService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teacher/home")
    @PreAuthorize("hasAnyAuthority('TEACHER')")
    public String getTeacherHomePage(Authentication authentication, Model model){
        TeacherDto teacher = authenticationService.getTeacher(authentication);
        model.addAttribute("teacher", teacher);
        model.addAttribute("students", studentService.getConfirmedStudentsByTeacher(teacher));
        return "teacher_profile";
    }

    @GetMapping("/teacher/home/edit")
    @PreAuthorize("hasAuthority('TEACHER')")
    public String getEditProfilePage(Authentication authentication, Model model){
        TeacherDto teacher = authenticationService.getTeacher(authentication);
        model.addAttribute("teacher", teacher);
        return "teacher_edit_page";
    }

    @PostMapping("/teacher/edit")
    @PreAuthorize("hasAuthority('TEACHER')")
    public String editProfile(Authentication authentication, TeacherEditForm teacherEditForm) {
        Teacher teacher = (Teacher) authenticationService.getUserModel(authentication);

        FileInfo fileInfo = null;
        if(!teacherEditForm.getImage().isEmpty()){
            fileInfo = fileService.save(teacherEditForm.getImage(), teacher);
        }
        teacherService.editTeacher(teacher.getId(), teacherEditForm, fileInfo);
        return "redirect:/teacher/home/edit";
    }
}