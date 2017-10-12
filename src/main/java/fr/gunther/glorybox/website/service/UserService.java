package fr.gunther.glorybox.website.service;

import fr.gunther.glorybox.website.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
