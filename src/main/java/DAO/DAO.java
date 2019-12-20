package DAO;

import DAO.models.ATM;
import DAO.models.State;

import java.util.Date;
import java.util.List;

public interface DAO {

    void addState(ATM atm, Date date, double sensor, double sensor1, double sensor2, double sensor3, double sensor4);

    void addATM(String location, String description, Date date);

    List<State> getStates();

    List<ATM> getATMs();
}
