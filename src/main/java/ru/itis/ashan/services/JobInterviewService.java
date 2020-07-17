package ru.itis.ashan.services;

import ru.itis.ashan.entities.employer.Employer;

public interface JobInterviewService {
    void invite(Long studentId, Employer employer);
}
