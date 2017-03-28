package ru.kpfu.itis.dao.impl.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import ru.kpfu.itis.dao.AutosDao;
import ru.kpfu.itis.dao.factory.HibernateConnectionFactory;
import ru.kpfu.itis.model.Automobile;

import java.util.ArrayList;
import java.util.List;

public class AutosDaoHibernateImpl implements AutosDao {

    private static final Logger logger = Logger.getLogger(AutosDaoHibernateImpl.class);

    public void save(Automobile automobile) {
        Session session = null;
        try {
            session = HibernateConnectionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(automobile);
            session.getTransaction().commit();
        } catch (Exception e) {
            logger.error("error saving automobile by Hibernate", e.getCause());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<Automobile> findAll() {
        Session session = null;
        List autos = new ArrayList();
        try {
            session = HibernateConnectionFactory.getSessionFactory().openSession();
            autos = session.createCriteria(Automobile.class).list();
        } catch (Exception e) {
            logger.error("error finding all automobile by Hibernate", e.getCause());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return autos;
    }

    public Automobile findOne(Long id) {
        return null;
    }
}
