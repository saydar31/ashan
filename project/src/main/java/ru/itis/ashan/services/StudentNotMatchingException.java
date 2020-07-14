package ru.itis.ashan.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class StudentNotMatchingException  extends RuntimeException{
}
