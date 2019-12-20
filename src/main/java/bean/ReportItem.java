package bean;

import java.util.Date;

public class ReportItem {

    private Long atmId;
    private String atmLocation;
    private String atmDescription;
    private Date date;
    private String sensorName;
    private double sensorValue;

    public ReportItem() {}

    public ReportItem(Long atmId, String atmLocation, String atmDescription, Date date, String sensorName, double sensorValue) {
        this.atmId = atmId;
        this.atmLocation = atmLocation;
        this.atmDescription = atmDescription;
        this.date = date;
        this.sensorName = sensorName;
        this.sensorValue = sensorValue;
    }

    public Long getAtmId() {
        return atmId;
    }

    public void setAtmId(Long atmId) {
        this.atmId = atmId;
    }

    public String getAtmLocation() {
        return atmLocation;
    }

    public void setAtmLocation(String atmLocation) {
        this.atmLocation = atmLocation;
    }

    public String getAtmDescription() {
        return atmDescription;
    }

    public void setAtmDescription(String atmDescription) {
        this.atmDescription = atmDescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public double getSensorValue() {
        return sensorValue;
    }

    public void setSensorValue(double sensorValue) {
        this.sensorValue = sensorValue;
    }
}
