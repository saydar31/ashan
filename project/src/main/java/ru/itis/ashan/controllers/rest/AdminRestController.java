package ru.itis.ashan.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.ashan.entities.employer.EmployerDto;
import ru.itis.ashan.entities.rest.request.AdminRequestDto;
import ru.itis.ashan.entities.rest.response.AdminResponseDto;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;
import ru.itis.ashan.entities.teacher.TeacherDto;
import ru.itis.ashan.entities.user.State;
import ru.itis.ashan.entities.user.UserDto;
import ru.itis.ashan.services.AdminService;
import ru.itis.ashan.services.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class AdminRestController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @GetMapping("/api/admin/not_confirmed_students")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<StudentDto>> getNotConfirmedStudents() {

        List<StudentDto> studentDtoList = adminService.getAllNotConfirmedStudents();
        return ResponseEntity.ok().body(studentDtoList);
    }

    @GetMapping("/api/admin/not_confirmed_teachers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<TeacherDto>> getNotConfirmedTeachers() {

        List<TeacherDto> teacherDtoList = adminService.getAllNotConfirmedTeachers();
        return ResponseEntity.ok().body(teacherDtoList);
    }

    @GetMapping("/api/admin/not_confirmed_employers")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<EmployerDto>> getNotConfirmedEmployers() {

        List<EmployerDto> employerDtoList = adminService.getAllNotConfirmedEmployers();
        return ResponseEntity.ok().body(employerDtoList);
    }

    @PostMapping("/api/admin/confirm_user")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<AdminResponseDto> confirmUser(@RequestBody AdminRequestDto adminRequestDto) {

        Optional<UserDto> optionalUserDto = userService.findUserModelById(adminRequestDto.getId());
        if (!optionalUserDto.isPresent()) {
            return ResponseEntity.ok().body(
                    new AdminResponseDto("fail", "user is not exist"));
        }

        UserDto userDto = optionalUserDto.get();
        if (!userDto.getState().equals(State.NOT_CONFIRMED)) {
            return ResponseEntity.ok().body(
                    new AdminResponseDto("fail", "user has " + userDto.getState().toString() + " state"));
        }

        adminService.confirmUser(userDto);
        return ResponseEntity.ok().body(
                new AdminResponseDto("success", "user has confirmed"));
    }

    @PostMapping("/api/admin/refuse_user")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<AdminResponseDto> refuseUser(@RequestBody AdminRequestDto adminRequestDto) {

        Optional<UserDto> optionalUserDto = userService.findUserModelById(adminRequestDto.getId());
        if (!optionalUserDto.isPresent()) {
            return ResponseEntity.ok().body(
                    new AdminResponseDto("fail", "user is not exist"));
        }

        UserDto userDto = optionalUserDto.get();
        if (!userDto.getState().equals(State.NOT_CONFIRMED)) {
            return ResponseEntity.ok().body(
                    new AdminResponseDto("fail", "user has " + userDto.getState().toString() + " state"));
        }

        adminService.refuseUser(userDto);
        return ResponseEntity.ok().body(
                new AdminResponseDto("success", "user has refused"));
    }
}
