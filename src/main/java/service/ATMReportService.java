package service;

import DAO.models.State;
import bean.ReportItem;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;

public interface ATMReportService {

    void generateStates();

    List<ReportItem> generateReport(
            String atm, String sensor, String dateFrom, String timeFrom, String dateTo, String timeTo
    ) throws UnsupportedEncodingException, ParseException;

    List<State> getCurrentStates();
}
