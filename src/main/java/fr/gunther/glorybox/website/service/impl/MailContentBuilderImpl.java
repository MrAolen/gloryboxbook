package fr.gunther.glorybox.website.service.impl;

import fr.gunther.glorybox.website.service.MailContentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Service
public class MailContentBuilderImpl implements MailContentBuilder {

    @Autowired
    private TemplateEngine templateEngine;

    public String build(Map<String, String> model, String templateName) {
        Context context = new Context();
        model.forEach((k,v) -> context.setVariable(k,v));
        return templateEngine.process(templateName, context);
    }
}
