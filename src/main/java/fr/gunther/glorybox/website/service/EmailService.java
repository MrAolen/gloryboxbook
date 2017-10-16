package fr.gunther.glorybox.website.service;

import java.util.Map;

public interface EmailService {
    void prepareAndSend(String from, String to, String subject, Map<String, String> model, String templateName);
}
