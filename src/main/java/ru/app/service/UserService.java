package ru.app.service;



import ru.app.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void removeUser(int id);
    List<User> getAllUsers();

    User findUser(int id);

    void update(int id, User user);
}
