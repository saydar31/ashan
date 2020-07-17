package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.student.StudentEditForm;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.AuthenticationService;
import ru.itis.ashan.services.FileService;
import ru.itis.ashan.services.StudentService;
import ru.itis.ashan.services.TeacherService;
import java.util.List;

@Controller
public class StudentProfileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private AuthenticationService authenticationService;

    @PreAuthorize("hasAuthority('STUDENT')")
    @GetMapping("/student/home")
    public String getHomePage(Authentication authentication, Model model){
        StudentDto student = authenticationService.getStudent(authentication);
        model.addAttribute("student", student);
        return "student_profile";
    }

    @GetMapping("/student/home/edit")
    @PreAuthorize("hasAuthority('STUDENT')")
    public String getEditProfilePage(Authentication authentication, Model model){
        StudentDto student = authenticationService.getStudent(authentication);
        model.addAttribute("student", student);
        model.addAttribute("teachers", teacherService.findConfirmedTeachers());
        return "student_edit_page";
    }

    @PostMapping("/student/edit")
    public ResponseEntity<Object> editProfile(Authentication authentication, StudentEditForm studentEditForm) {
        StudentDto student = authenticationService.getStudent(authentication);
        studentService.editStudent(student.getId(), studentEditForm);
        return ResponseEntity.ok().build();
    }
}

//    @PostMapping("/student/photo")
//    public String uploadPhoto(@RequestParam("photo") MultipartFile multipartFile, Model model, Authentication authentication) {
////        Student student = (Student) authenticationService.getUserModel(authentication);
////        //проверяем, что файл не пустой
////        if (!multipartFile.isEmpty()) {
////            fileService.save(multipartFile, student);
////        }
////        model.addAttribute("student", student);
////        return "student_profile";
//    }
