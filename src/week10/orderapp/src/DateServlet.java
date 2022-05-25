

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

/**
 * Servlet implementation class TimeServlet
 */
public class DateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
    		HttpServletResponse response)
    		throws ServletException, IOException {
    		// Get link parameter
    		int paramValue =
    		Integer.parseInt(request.getParameter("param"));
    		// Get writer
    		PrintWriter writer = response.getWriter();
    		
    		if (paramValue == 0) {
        		// Get current date
    			LocalDate now = LocalDate.now();
        		// Display current date
        		writer.println("Today is " + now.toString());
    		}
    		else if (paramValue == 1) {
    			// Get current date
    			LocalDate now = LocalDate.now();
    			// Get tomorrow date
    			LocalDate tomorrow = now.plusDays(paramValue);
        		// Display tomorrow date
        		writer.println("Tomorrow is " + tomorrow.toString());
    		}
    		else if (paramValue == -1) {
        		// Get current date
    			LocalDate now = LocalDate.now();
    			// Get yesterday date
    			LocalDate yesterday = now.minusDays(-paramValue);
        		// Display yesterday date
        		writer.println("Yesterday is " + yesterday.toString());
    		}

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
