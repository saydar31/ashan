package ru.itis.ashan.services.email;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

@Component
public class MailContentServiceImpl implements MailContentService {
    @Autowired
    @Qualifier("mailTemplateFreeMarkerConfigurationFactory")
    Configuration configuration;

    @Override
    public String getContent(String templateName, Map<String, Object> model) {
        try {
            Template template = configuration.getTemplate(templateName);
            StringWriter writer = new StringWriter();
            template.process(model,writer);
            return writer.toString();
        } catch (IOException | TemplateException e) {
            throw new IllegalArgumentException();
        }
    }
}
