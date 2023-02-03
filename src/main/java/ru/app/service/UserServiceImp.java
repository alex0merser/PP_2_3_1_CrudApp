package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.repository.UserDao;
import web.models.User;


import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        userDao.removeUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User findOne(int id) {
        return userDao.findOne(id);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        userDao.update(id, user);
    }
}
