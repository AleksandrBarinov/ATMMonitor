package DAO;

import DAO.models.ATM;
import DAO.models.State;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.Date;
import java.util.List;

public class DAOImpl implements DAO{

    private static DAOImpl daoImpl = null;

    public static DAOImpl getDaoImpl() {
        if (daoImpl == null) {
            daoImpl = new DAOImpl();
        }
        return daoImpl;
    }

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void addState(ATM atm, Date date, double sensor, double sensor1, double sensor2, double sensor3, double sensor4) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        State state = new State();
        state.setAtm(atm);
        state.setDate(date);
        state.setSensor(sensor);
        state.setSensor1(sensor1);
        state.setSensor2(sensor2);
        state.setSensor3(sensor3);
        state.setSensor4(sensor4);

        session.update(state.getAtm());
        session.save(state);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void addATM(String location, String description, Date date) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        ATM atm = new ATM();
        atm.setLocation(location);
        atm.setDescription(description);
        atm.setDate(date);

        session.save(atm);

        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<State> getStates(){

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from State");

        List<State> states = (List<State>)query.getResultList();

        session.getTransaction().commit();
        session.close();

        return states;
    }

    @Override
    public List<ATM> getATMs() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from ATM ");

        List<ATM> atms = (List<ATM>)query.getResultList();

        session.getTransaction().commit();
        session.close();

        return atms;
    }
}
