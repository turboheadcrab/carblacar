package ru.kpfu.itis.dao.impl.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import ru.kpfu.itis.dao.DriversDao;
import ru.kpfu.itis.dao.factory.HibernateConnectionFactory;
import ru.kpfu.itis.model.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriversDaoHibernateImpl implements DriversDao {

    private static final Logger logger = Logger.getLogger(DriversDaoHibernateImpl.class);

    @Override
    public void save(Driver driver) {
        Session session = null;
        try {
            session = HibernateConnectionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(driver);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("error saving driver by Hibernate", e.getCause());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Driver findOne(Long id) {
        return null;
    }

    @Override
    public List<Driver> findAll() {
        Session session = null;
        List drivers = new ArrayList();
        try {
            session = HibernateConnectionFactory.getSessionFactory().openSession();
            drivers = session.createCriteria(Driver.class).list();
        } catch (Exception e) {
            logger.error("error finding all by Hibernate", e.getCause());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return drivers;
    }

    @Override
    public List<Driver> findTop9ByOrderByRatingDesc() {
        Session session = null;
        Criteria criteria;
        List drivers = new ArrayList();
        try {
            session = HibernateConnectionFactory.getSessionFactory().openSession();
            criteria = session.createCriteria(Driver.class);
            criteria.addOrder(Order.desc("rating"));
            criteria.setMaxResults(9);
            drivers = criteria.list();
        } catch (Exception e) {
            logger.error("error finding all by Hibernate", e.getCause());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return drivers;
    }
}
