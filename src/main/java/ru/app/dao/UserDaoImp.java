package web.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.models.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(int id) {
            entityManager.remove(findOne(id));
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User findOne(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(int id, User user) {
        User oldUser = entityManager.find(User.class, id);
        oldUser.setFirstName(user.getFirstName());
        oldUser.setAge(user.getAge());
    }
}
