package ru.kpfu.itis.service.impl;

import ru.kpfu.itis.dao.UsersDao;
import ru.kpfu.itis.dao.impl.hibernate.UserDaoHibernateImpl;
import ru.kpfu.itis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.itis.service.UsersService;

import java.util.List;

public class UsersServiceImpl implements UsersService {

    private UsersDao usersDao;

    @Autowired
    public UsersServiceImpl(UserDaoHibernateImpl usersDao) {
        this.usersDao = usersDao;
    }

    public User addUser(User user) {
        usersDao.save(user);
        return user;
    }

    public User findById(Long id) {
        User user = usersDao.findOne(id);
        return user;
    }

    public void update(User user) {
        usersDao.save(user);
    }

    public List<User> findAll() {
        return usersDao.findAll();
    }

    public User findByNickname(String name) {
        return usersDao.findByNicknameIgnoreCase(name);
    }

    public User findByEmail(String email) {
        return usersDao.findByEmailIgnoreCase(email);
    }
}