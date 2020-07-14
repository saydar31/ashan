package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.ashan.entities.admin.Admin;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.AdminService;

@Controller
public class AdminHomePageController {

    @Autowired
    private AdminService adminService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin/home")
    public String getPage(Authentication authentication, Model model) {
        UserDetailsImpl userDetail = (UserDetailsImpl) authentication.getPrincipal();
        Admin admin = (Admin) userDetail.getUser();
        model.addAttribute("admin", admin);

        return "admin_profile";
    }
}
