package ru.itis.ashan.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.FileService;

@Controller
public class StudentHomePageController {

    @Autowired
    private FileService fileService;

    private Student student;

    @PreAuthorize("hasAuthority('STUDENT')")
    @GetMapping("/student/home")
    public String getHomePage(Authentication authentication, Model model){
        UserDetailsImpl userDetail = (UserDetailsImpl) authentication.getPrincipal();
        student = (Student) userDetail.getUser();
        model.addAttribute("student", student);
        return "student_profile";
    }

    @PostMapping("/student/photo")
    public String uploadPhoto(@RequestParam("photo") MultipartFile multipartFile, Model model) {
        //проверяем, что файл не пустой
        if (!multipartFile.isEmpty()) {
            fileService.save(multipartFile, student);
        }
        model.addAttribute("student", student);
        return "student_profile";
    }
}
