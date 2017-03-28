package ru.kpfu.itis.dao;

import ru.kpfu.itis.model.User;

import java.util.List;

public interface UsersDao {

    void save(User user);

    User findOne(Long userId);

    List<User> findAll();

    User findByNickname(String nickname);

    User findByEmail(String email);

    User findByNicknameIgnoreCase(String name);

    User findByEmailIgnoreCase(String email);
}
