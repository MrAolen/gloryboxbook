package fr.gunther.glorybox.website.service;

public interface EmailService {
    void sendCommandValidation(String to, String link, String name, String forname);
    void sendCommandConfirmation(String to, String name, String forname);
}
