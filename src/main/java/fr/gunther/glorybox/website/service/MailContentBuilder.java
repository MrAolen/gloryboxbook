package fr.gunther.glorybox.website.service;

import java.util.Map;

public interface MailContentBuilder {
    String build(Map<String, String> model,String templateName);
}
