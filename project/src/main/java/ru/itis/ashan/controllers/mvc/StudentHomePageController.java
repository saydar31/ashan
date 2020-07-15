package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.ashan.entities.edit.student.StudentEditDto;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.FileService;
import ru.itis.ashan.services.StudentService;
import ru.itis.ashan.services.TeacherService;
import ru.itis.ashan.services.UserService;

import java.util.List;

@Controller
public class StudentHomePageController {

    @Autowired
    private FileService fileService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @PreAuthorize("hasAuthority('STUDENT')")
    @GetMapping("/student/home")
    public String getHomePage(Authentication authentication, Model model){
        UserDetailsImpl userDetail = (UserDetailsImpl) authentication.getPrincipal();
        Student student = (Student) userDetail.getUser();
        List<TeacherDto> teacherDtoList = teacherService.findConfirmedTeachers();
        model.addAttribute("student", student);
        model.addAttribute("teachers", teacherDtoList);
        return "student_profile";
    }

    @PostMapping("/student/photo")
    public String uploadPhoto(@RequestParam("photo") MultipartFile multipartFile, Model model, Authentication authentication) {
        UserDetailsImpl userDetail = (UserDetailsImpl) authentication.getPrincipal();
        Student student = (Student) userDetail.getUser();
        //проверяем, что файл не пустой
        if (!multipartFile.isEmpty()) {
            fileService.save(multipartFile, student);
        }
        model.addAttribute("student", student);
        return "student_profile";
    }

    @PostMapping("/student/home/edit")
    @PreAuthorize("hasAuthority('STUDENT')")
    public String editProfileData(StudentEditDto studentEditDto, Authentication authentication){
        UserDetailsImpl userDetail = (UserDetailsImpl) authentication.getPrincipal();
        Student student = (Student) userDetail.getUser();
        studentService.updateStudentData(student, studentEditDto);
        return "redirect:/student/home";

    }
}
