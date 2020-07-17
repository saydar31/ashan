package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.ashan.entities.admin.Admin;
import ru.itis.ashan.entities.tag.Tag;
import ru.itis.ashan.entities.tag.TagDto;
import ru.itis.ashan.security.details.UserDetailsImpl;
import ru.itis.ashan.services.TagService;

import java.util.List;

@Controller
public class TagPanelController {

    @Autowired
    private TagService tagService;

    @GetMapping("/admin/tag_panel")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getPage(Authentication authentication, Model model){
        UserDetailsImpl userDetail = (UserDetailsImpl) authentication.getPrincipal();
        Admin admin = (Admin) userDetail.getUser();
        List<TagDto> tagDtoList = tagService.getAllTags();

        model.addAttribute("admin", admin);
        model.addAttribute("tagList", tagDtoList);
        return "tag_panel";
    }
}
