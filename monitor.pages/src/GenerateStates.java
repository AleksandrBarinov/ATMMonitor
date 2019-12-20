import DAO.models.State;
import service.ATMReportService;
import service.impl.ATMReportServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/generate")
public class GenerateStates extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ATMReportService service = ATMReportServiceImpl.getATMReportService();

        service.generateStates();

        List<State> states = service.getCurrentStates();

        req.setAttribute("states", states);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(req, resp);

    }
}
