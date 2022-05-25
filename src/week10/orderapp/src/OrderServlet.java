

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		// Get data from HTML form
		String selectedProduct = request.getParameter("product");
		String specifiedQuantity = request.getParameter("quantity");
		// Parse to processable type
		int code = Integer.parseInt(selectedProduct);
		int quantity = Integer.parseInt(specifiedQuantity);
		// Get price of product and product name
		double price = 0.00;
		String productName = "";
		switch (code) {
			case 101:
				productName = "McChicken Value Meal";
				price = 13.20;
				break;
			case 102:
				productName = "Smoky Grilled Beef Meal";
				price = 17.90;
				break;
			case 103:
				productName = "Ayam Goreng McD Spicy Meal 2pcs";
				price = 16.95;
				break;
			case 104:
				productName = "Spicy McChicken Deluxe Meal";
				price = 16.65;
				break;
			case 105:
				productName = "Chicken McNuggets 6pcs Meal";
				price = 13.20;
				break;
		}
		// Calculate total and service tax
		double subTotal = quantity * price;
		double serviceTax = subTotal * 0.06;
		double total = subTotal + serviceTax;
		// Get writer
		PrintWriter writer =response.getWriter();
		// Display detail of amount
		writer.print("<html><h3>Details of Ordered Product</h3>");
		writer.print("Product: " + productName + "<br>");
		writer.print("Price per quantity: RM " + 
		String.format("%.2f", price) + "<br>");
		writer.print("Quantity: " + quantity + "<br><br>");
		writer.print("<b>Total Amount: RM " + 
		String.format("%.2f", total) + "</b><br>");
		writer.print("Service total: RM " + 
		String.format("%.2f", serviceTax) + "<br>");
		writer.print("Amount before tax: RM " + 
		String.format("%.2f", subTotal) + "<br></html>");
	}

}
