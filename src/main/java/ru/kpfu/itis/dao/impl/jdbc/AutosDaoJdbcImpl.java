package ru.kpfu.itis.dao.impl.jdbc;

import ru.kpfu.itis.dao.AutosDao;
import ru.kpfu.itis.dao.factory.JDBCConnectionFactory;
import ru.kpfu.itis.model.Automobile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutosDaoJdbcImpl implements AutosDao{

    Connection con = null;
    PreparedStatement ptmt = null;
    ResultSet rs = null;

    private Connection getConnection() throws SQLException {
        return JDBCConnectionFactory.getInstance().getConnection();
    }


    public void save(Automobile automobile) {

    }

    public List<Automobile> findAll() {
        return new ArrayList<Automobile>();
    }

    public Automobile findOne(Long id) {
        return null;
    }
}
