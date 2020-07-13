package ru.itis.ashan.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.user.Role;
import ru.itis.ashan.entities.user.UserModel;
import ru.itis.ashan.security.details.UserDetailsImpl;

@Controller
public class RootController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/")
    public String getRootPage(Authentication authentication) {
        if (authentication != null) {
            UserDetailsImpl userDetail = (UserDetailsImpl) authentication.getPrincipal();
            UserModel userModel = userDetail.getUser();
            Role role = userModel.getRole();

            if (role.equals(Role.STUDENT)) {
                return "redirect:/student/home";
            } else if (role.equals(Role.TEACHER)) {
                return "redirect:/profile_teacher";
            }else if (role.equals(Role.EMPLOYER)) {
                return "redirect:/profile_employer";
            }else if (role.equals(Role.ADMIN)) {
                return "redirect:/profile_admin";
            } else {
                throw new IllegalArgumentException("this role is not exist");
            }
        } else {
            return "redirect:/signIn";
        }
    }

}
