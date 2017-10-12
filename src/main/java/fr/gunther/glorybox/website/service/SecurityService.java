package fr.gunther.glorybox.website.service;

public interface SecurityService {
    String findLoggedInUsername();
    void autologin(String username, String password);
}
