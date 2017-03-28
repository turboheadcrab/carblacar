package ru.kpfu.itis.dao.impl.jdbc;

import org.apache.log4j.Logger;
import ru.kpfu.itis.dao.DriversDao;
import ru.kpfu.itis.dao.factory.JDBCConnectionFactory;
import ru.kpfu.itis.dao.impl.hibernate.AutosDaoHibernateImpl;
import ru.kpfu.itis.model.Driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DriversDaoJdbcImpl implements DriversDao {

    private static final Logger logger = Logger.getLogger(AutosDaoHibernateImpl.class);

    private Connection getConnection() throws SQLException {
        return JDBCConnectionFactory.getInstance().getConnection();
    }

    @Override
    public void save(Driver driver) {

    }

    @Override
    public Driver findOne(Long id) {
        return null;
    }

    @Override
    public List<Driver> findAll() {
        return null;
    }

    @Override
    public List<Driver> findTop9ByOrderByRatingDesc() {
        String sql = "SELECT * FROM drivers ORDER BY rating DESC LIMIT 9";
        List<Driver> drivers = new ArrayList<>();

        try (Connection conn = getConnection();
        PreparedStatement ptmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = ptmt.executeQuery()) {
                while (rs.next()) {
                    drivers.add(new Driver(rs.getInt("experience"), rs.getInt("rating")));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return drivers;
    }
}
