package ru.kpfu.itis.dao.impl.jdbc;

import org.apache.log4j.Logger;
import ru.kpfu.itis.dao.UsersDao;
import ru.kpfu.itis.dao.factory.JDBCConnectionFactory;
import ru.kpfu.itis.dao.impl.hibernate.AutosDaoHibernateImpl;
import ru.kpfu.itis.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoJdbcImpl implements UsersDao {

    private static final Logger logger = Logger.getLogger(AutosDaoHibernateImpl.class);

    private Connection getConnection() throws SQLException {
        return JDBCConnectionFactory.getInstance().getConnection();
    }

    @Override
    public void save(User user) {
        String sql = "INSERT INTO users (nickname, password, firstname, surname, avatar, email, role) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
        PreparedStatement ptmt = con.prepareStatement(sql)) {
            ptmt.setString(1, user.getNickname());
            ptmt.setString(2, user.getPassword());
            ptmt.setString(3, user.getFirstname());
            ptmt.setString(4, user.getSurname());
            ptmt.setString(5, user.getAvatar());
            ptmt.setString(6, user.getEmail());
            ptmt.setString(7, user.getRole());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findOne(Long userId) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByNickname(String nickname) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findByNicknameIgnoreCase(String name) {
        String sql = "SELECT * FROM users WHERE UPPER(nickname) = ?";
        User user = null;

        try (Connection con = getConnection();
        PreparedStatement ptmt = con.prepareStatement(sql)) {
            ptmt.setString(1, name.toUpperCase());
            try (ResultSet rs = ptmt.executeQuery()) {
                if (rs.next()) {
                    user = new User(
                            rs.getString("nickname"),
                            rs.getString("password"),
                            rs.getString("firstname"),
                            rs.getString("surname"),
                            rs.getString("avatar"),
                            rs.getString("email"),
                            rs.getString("role")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User findByEmailIgnoreCase(String email) {
        return null;
    }
}
