package ru.itis.ashan.services;

import ru.itis.ashan.entities.employer.Employer;
import ru.itis.ashan.entities.student.Student;

public interface InterviewNotificationService {
    void sendInterviewNotification(Employer employer, Student student);
}
