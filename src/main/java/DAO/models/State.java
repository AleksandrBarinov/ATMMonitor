package DAO.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "states")
public class State extends BaseEntity{

    @OneToOne
    private ATM atm;

    private double sensor;
    private double sensor1;
    private double sensor2;
    private double sensor3;
    private double sensor4;

    public State(){}

    public State(ATM atm, double sensor, double sensor1, double sensor2, double sensor3, double sensor4) {
        this.atm = atm;
        this.sensor = sensor;
        this.sensor1 = sensor1;
        this.sensor2 = sensor2;
        this.sensor3 = sensor3;
        this.sensor4 = sensor4;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public double getSensor() {
        return sensor;
    }

    public void setSensor(double sensor) {
        this.sensor = sensor;
    }

    public double getSensor1() {
        return sensor1;
    }

    public void setSensor1(double sensor1) {
        this.sensor1 = sensor1;
    }

    public double getSensor2() {
        return sensor2;
    }

    public void setSensor2(double sensor2) {
        this.sensor2 = sensor2;
    }

    public double getSensor3() {
        return sensor3;
    }

    public void setSensor3(double sensor3) {
        this.sensor3 = sensor3;
    }

    public double getSensor4() {
        return sensor4;
    }

    public void setSensor4(double sensor4) {
        this.sensor4 = sensor4;
    }
}
