package ru.itis.ashan.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.employer.EmployerDto;
import ru.itis.ashan.entities.employer.EmployerEditDto;
import ru.itis.ashan.entities.fileInfo.FileInfo;
import ru.itis.ashan.services.AuthenticationService;
import ru.itis.ashan.services.EmployerService;
import ru.itis.ashan.services.FileService;

@Controller
public class EmployerEditPageController {

    @Autowired
    private FileService fileService;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private EmployerService employerService;

    @GetMapping("/home/employer/edit")
    @PreAuthorize("hasAuthority('EMPLOYER')")
    public ModelAndView getEditPage(Authentication authentication) {
        EmployerDto employerDto = authenticationService.getEmployer(authentication);
        ModelAndView modelAndView = new ModelAndView("employer_edit");
        modelAndView.addObject("employer", employerDto);
        return modelAndView;
    }

    @PostMapping("/home/employer/edit")
    @PreAuthorize("hasAuthority('EMPLOYER')")
    public ModelAndView editEmployer(Authentication authentication, EmployerEditDto employerEditDto) {
        Employer employer = (Employer) authenticationService.getUserModel(authentication);

        FileInfo fileInfo = null;
        if (!employerEditDto.getImage().isEmpty()) {
            fileInfo = fileService.save(employerEditDto.getImage(), employer);
        }
        employerService.edit(employer, employerEditDto, fileInfo);
        return new ModelAndView("redirect:/home/employer/edit");
    }
}
