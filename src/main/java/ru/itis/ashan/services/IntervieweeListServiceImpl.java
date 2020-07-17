package ru.itis.ashan.services;

import org.springframework.stereotype.Component;
import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.student.Student;
import ru.itis.ashan.entities.student.StudentDto;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class IntervieweeListServiceImpl implements IntervieweeListService {

    private final Function<Student,StudentDto> castFunction = student -> StudentDto.builder()
            .mail(student.getMail())
            .competence(student.getCompetence())
            .surname(student.getSurname())
            .name(student.getName())
            .patronymic(student.getPatronymic())
            .id(student.getId())
            .groupNumber(student.getGroupNumber())
            .build();

    @Override
    public Set<StudentDto> getInterviewees(Employer employer) {
        return employer.getInvitedStudents().stream().map(castFunction).collect(Collectors.toSet());
    }
}
