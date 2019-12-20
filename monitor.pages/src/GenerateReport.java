import bean.ReportItem;
import service.ATMReportService;
import service.impl.ATMReportServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@WebServlet("/report")
public class GenerateReport extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String atm = req.getParameter("atm");
        String sensor = req.getParameter("sensor");
        String dateFrom = req.getParameter("dateFrom");
        String timeFrom = req.getParameter("timeFrom");
        String dateTo = req.getParameter("dateTo");
        String timeTo = req.getParameter("timeTo");

        ATMReportService service = ATMReportServiceImpl.getATMReportService();

        List<ReportItem> states = null;
        try {
            states = service.generateReport(
                    atm, sensor, dateFrom, timeFrom, dateTo, timeTo
            );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        req.setAttribute("states", states);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/jsp/report.jsp");
        requestDispatcher.forward(req, resp);
    }
}
