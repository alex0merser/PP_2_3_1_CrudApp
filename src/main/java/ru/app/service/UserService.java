package web.services;

import web.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void removeUser(int id);
    List<User> getAllUsers();

    User findOne(int id);

    void update(int id, User user);
}
