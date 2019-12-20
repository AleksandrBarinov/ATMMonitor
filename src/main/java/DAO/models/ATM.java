package DAO.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "atms")
public class ATM extends BaseEntity{

    private String location;

    private String description;

    public ATM(){}

    public ATM(String location, String description, Date date) {
        this.location = location;
        this.description = description;
        super.setDate(date);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
