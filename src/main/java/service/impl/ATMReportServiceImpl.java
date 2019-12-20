package service.impl;

import DAO.DAOImpl;
import DAO.models.ATM;
import DAO.models.State;
import bean.ReportItem;
import service.ATMReportService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ATMReportServiceImpl implements ATMReportService {

    private static ATMReportServiceImpl atmReportService = null;

    public static ATMReportServiceImpl getATMReportService() {
        if (atmReportService == null) {
            atmReportService = new ATMReportServiceImpl();
        }
        return atmReportService;
    }

    private DAOImpl dao = DAOImpl.getDaoImpl();

    @Override
    public void generateStates() {

        List<ATM> atms;

        if (dao.getATMs().size() == 0) {
            dao.addATM("location", "description", new Date());
            dao.addATM("location1", "description1", new Date());
            dao.addATM("location2", "description2", new Date());
            dao.addATM("location3", "description3", new Date());
            dao.addATM("location4", "description4", new Date());
        }

        atms = dao.getATMs();

        for (ATM atmItem: atms) {
            for (int i = 0; i < 5; i++) {
                dao.addState(
                            atmItem
                            ,new Date(),
                            Math.random(),
                            Math.random(),
                            Math.random(),
                            Math.random(),
                            Math.random()
                );
            }
        }
    }

    @Override
    public List<ReportItem> generateReport(String atm, String sensor, String dateFrom, String timeFrom, String dateTo, String timeTo) throws UnsupportedEncodingException, ParseException {

        List<ReportItem> reportItems = new ArrayList<>();
        List<State> states = dao.getStates();

        ReportItem reportItem;

        //filter by sensor
        if (!sensor.equals("")
                || sensor.equals("0")
                || sensor.equals("1")
                || sensor.equals("2")
                || sensor.equals("3")
                || sensor.equals("4")
        ) {
            String sensorName = null;
            double sensorValue = 0.0;

            for (State state: states) {
                switch (sensor){
                    case "0":
                        sensorName = "sensor";
                        sensorValue = state.getSensor();
                        break;
                    case "1":
                        sensorName = "sensor1";
                        sensorValue = state.getSensor1();
                        break;
                    case "2":
                        sensorName = "sensor2";
                        sensorValue = state.getSensor2();
                        break;
                    case "3":
                        sensorName = "sensor3";
                        sensorValue = state.getSensor3();
                        break;
                    case "4":
                        sensorName = "sensor4";
                        sensorValue = state.getSensor4();
                        break;
                }
                reportItem = new ReportItem(
                        state.getAtm().getId(),
                        state.getAtm().getLocation(),
                        state.getAtm().getDescription(),
                        state.getDate(),
                        sensorName,
                        sensorValue
                );
                reportItems.add(reportItem);
            }

            //filter by date
            if (!dateFrom.equals("") && !dateTo.equals("")) {

                if (timeFrom.equals("")) timeFrom = "00:00";

                String encodedTimeFrom = URLDecoder.decode(timeFrom, "utf-8");

                if (timeTo.equals("")) timeTo = "00:00";

                String encodedTimeTo = URLDecoder.decode(timeTo, "utf-8");

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date from = format.parse(dateFrom + " " + encodedTimeFrom);
                Date to = format.parse(dateTo + " " + encodedTimeTo);

                Iterator<ReportItem> reportItemByDate = reportItems.iterator();
                while (reportItemByDate.hasNext()) {
                    reportItem = reportItemByDate.next();
                    if (!(reportItem.getDate().after(from) && reportItem.getDate().before(to))) {
                        reportItemByDate.remove();
                    }
                }
            }

            //filter by atm
            if (!atm.equals("")) {
                Iterator<ReportItem> reportItemByAtm = reportItems.iterator();
                while (reportItemByAtm.hasNext()) {
                    reportItem = reportItemByAtm.next();
                    if (!(reportItem.getAtmId().equals(Long.parseLong(atm)))) {
                        reportItemByAtm.remove();
                    }
                }
            }
        }

        return reportItems;
    }

    @Override
    public List<State> getCurrentStates() {
        List<State> states;
        states = dao.getStates();

        Map<Long, State> resultMap = new HashMap<>();

        Date tempDate;
        Long tempId;

        for (State state: states) {
            tempDate = state.getDate();
            tempId = state.getAtm().getId();

            resultMap.put(tempId, state);

            for (State state1: states) {

                if (state1.getAtm().getId().equals(tempId) && state1.getDate().after(tempDate)) {

                    resultMap.put(tempId, state1);
                }
            }
        }

        states = new ArrayList<>();

        for (Map.Entry<Long, State> entry: resultMap.entrySet()) {
            states.add(entry.getValue());
        }

        return states;
    }
}
