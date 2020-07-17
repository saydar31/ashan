package ru.itis.ashan.services.email;

import java.util.Map;

public interface MailContentService {
    String getContent(String templateName, Map<String,Object> model);
}
