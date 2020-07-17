package ru.itis.ashan.services.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Mail {
    private String subject;
    private String fromEmail;
    private String toEmail;
    private String content;
}
