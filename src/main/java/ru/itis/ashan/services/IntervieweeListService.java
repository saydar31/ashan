package ru.itis.ashan.services;

import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.student.StudentDto;

import java.util.Set;

public interface IntervieweeListService {
    Set<StudentDto> getInterviewees(Employer employer);
}
