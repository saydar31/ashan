package ru.itis.ashan.services;

import ru.itis.ashan.entities.employer.Employer;

public interface InterviewResultService {
    void accept(Long studentId, Employer employer);
    void refuse(Long studentId, Employer employer);
}
